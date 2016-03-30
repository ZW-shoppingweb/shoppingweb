package com.thoughtworks.shoppingweb.web;

/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    public static final String DEFAULT_PAGE_SIZE = "16";
    public static final String DEFAULT_PAGE_NUM = "1";
    public static final String DEFAULT_MIN_PRICE = "0";
    public static final String DEFAULT_MAX_PRICE = "100000";
    @RequestMapping(value = "/productList", method=RequestMethod.GET)
    public String productList(@RequestParam(value = "filterName", required = false) String filterName,
                              @RequestParam(value = "filterValue", required = false) String filterValue,
                              @RequestParam(value = "pageId", required = false,
                                      defaultValue = DEFAULT_PAGE_NUM) int pageId,
                              @RequestParam(value = "minPrice", required = false,
                                      defaultValue = DEFAULT_MIN_PRICE) String minPrice,
                              @RequestParam(value = "maxPrice", required = false,
                                      defaultValue = DEFAULT_MAX_PRICE) String maxPrice,
                              @RequestParam(value = "seqName", required = false) String seqName,
                              @RequestParam(value = "sequence", required = false) String sequence,
                              @RequestParam(value="pageSize",
                                      defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
                              Model model) {
        PaginationData paginationData = new PaginationData();
        paginationData.createQueryFilter(filterName, filterValue,minPrice,maxPrice,seqName,sequence);
        paginationData.setCurrentPageNum(pageId);
        paginationData.setPageSize(pageSize);
        paginationData = productService.getProductPaginationData(paginationData);
        model.addAttribute("indexPage", paginationData);
        return "index";
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such PaginationData")  // 404
    public class ProductNotFoundException extends RuntimeException {}

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") String id, Model model) {
        Product product = productService.getProduct(id);
        if (product == null) throw new ProductNotFoundException();
        model.addAttribute(product);
        return "productdetail";

    }
    @RequestMapping(value = "/searchByPrice", method = RequestMethod.POST)
    public String getProductByPrice(@PathVariable("id") String id, Model model) {
        Product product = productService.getProduct(id);
        if (product == null) throw new ProductNotFoundException();
        model.addAttribute(product);
        return "productdetail";


    }

}