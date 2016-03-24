package com.thoughtworks.shoppingweb.web;

/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Page;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    public static final int PAGE_SIZE = 16;
    public static final String DEFAULT_PAGE_NUM = "1";

    @RequestMapping(value = "/productList", method=RequestMethod.GET)
    public String productList(@RequestParam(value = "pageId", required = false,
            defaultValue = DEFAULT_PAGE_NUM) int pageId, Model model) {
        List<Product> products = productService.getAllProduct();
        Page page = new Page();
        page.apartPage(pageId, products.size(), PAGE_SIZE);
        model.addAttribute("indexPage", page);
        if(pageId > 0 && pageId <= page.getTotalPage()) {


            if (page.getPageId() != 1) {
                model.addAttribute("firstPage", "首页");
            }
            if (page.getPageId() != page.getTotalPage()) {
                model.addAttribute("lastPage", "尾页");
            }
            model.addAttribute("allProducts", products.subList(page.getShowContentBegin(), page.getShowContendEnd()));
            return "index";
        }
        else{
            throw new ProductNotFoundException();
        }
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Page")  // 404
    public class ProductNotFoundException extends RuntimeException {}

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") String id, Model model) {
        System.out.println("=====" + id);
        Product product = productService.getProduct(id);
        if (product == null) throw new ProductNotFoundException();
        model.addAttribute(product);
        return "productdetail";


    }
}