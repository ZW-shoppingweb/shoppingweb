package com.thoughtworks.shoppingweb.web;

/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Page;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/gotodetails", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView getProduct(String product_id, Model model) {
        System.out.println("=====" + product_id);
        ModelAndView modelAndView = new ModelAndView("productdetail");
        modelAndView.addObject("product", productService.getProduct(product_id));
        return modelAndView;

    }

    @RequestMapping(value = "/indexofshoppingweb")
    public String indexofshoppingweb(Model model) {
        List<Product> products = productService.getAllProduct();
        Page page=new Page();
        page.apartPage(1,products.size(),16);
        model.addAttribute("indexpage",page);
        model.addAttribute("lastpage","尾页");
        model.addAttribute("allproducts", products.subList(0,page.getPagesize()));

        return "index";
    }
    @RequestMapping(value = "/page")
    public String pageable(String pageid,Model model) {
        List<Product> products = productService.getAllProduct();

        Page page=new Page();
        Integer curpageid=Integer.parseInt(pageid);
        page.apartPage(curpageid,products.size(),16);
        model.addAttribute("indexpage",page);
        if(page.getPageidid() != 1){
            model.addAttribute("firstpage","首页");
        }
        if(page.getPageidid() != page.getTotalpage()){
            model.addAttribute("lastpage","尾页");
        }
        if(curpageid*page.getPagesize() > products.size()){

        }
        model.addAttribute("allproducts", products.subList(page.getShowcontentbegin(),page.getShowcontentend()));

        return "index";
    }
}
