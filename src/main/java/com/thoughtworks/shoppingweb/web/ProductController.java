package com.thoughtworks.shoppingweb.web;

/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public @ResponseBody ModelAndView getProduct(String product_id, Model model) {
        System.out.println("====="+product_id);
        ModelAndView modelAndView = new ModelAndView("productdetail");
        modelAndView.addObject("product",productService.getProduct(product_id));
        return modelAndView;

    }
}
