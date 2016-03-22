package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/indexofshoppingweb")
    public String indexofshoppingweb(Model model) {
        List<Product> products=productService.getAllProduct();
        model.addAttribute("allproducts",products);
        return "index";
    }

}
