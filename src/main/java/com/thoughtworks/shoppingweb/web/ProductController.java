package com.thoughtworks.shoppingweb.web;

/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.domain.*;
import com.thoughtworks.shoppingweb.service.*;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    HistoryService historyService;
    public static final String DEFAULT_PAGE_SIZE = "16";
    public static final String DEFAULT_PAGE_NUM = "1";
    private final static Logger log = Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    public String productList(@ModelAttribute QueryFilter queryFilter, Model model) {
        PaginationData paginationData = new PaginationData();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setCurrentPageNum(1);
        if (queryFilter.getPageId() != "" && queryFilter.getPageId() != null) {
            paginationData.setCurrentPageNum(Integer.parseInt(queryFilter.getPageId()));
        }
        paginationData.setPageSize(16);
        paginationData.getMaxPageNum();
        paginationData = productService.getProductPaginationData(paginationData);
        model.addAttribute("indexPage", paginationData);
        model.addAttribute("query", queryFilter);
        return "index";
    }

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public String productListAll(
            @RequestParam(value = "pageId", required = false,
                    defaultValue = DEFAULT_PAGE_NUM) int pageId,
            @RequestParam(value = "pageSize",
                    defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            Model model) {

        PaginationData paginationData = new PaginationData();
        QueryFilter queryFilter = new QueryFilter();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setPageData(productService.getAllProduct(pageId, pageSize));
        paginationData.setCurrentPageNum(pageId);
        paginationData.setPageSize(pageSize);
        paginationData = productService.getProductPaginationData(paginationData);
        model.addAttribute("indexPage", paginationData);
        return "index";
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such PaginationData")  // 404
    public class ProductNotFoundException extends RuntimeException {
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") String id, @RequestParam(value="userName",
            defaultValue = "", required = false) String userName, Model model) {
        Product product = productService.getProduct(id);
        if (product == null) throw new ProductNotFoundException();
        model.addAttribute(product);
        if(userName == null || userName.equals("")) {
            userName = UUID.randomUUID().toString();
        }
        historyService.insertHistory(userName,id);
        model.addAttribute("history",historyService.getHistoryByUser(userName));
        model.addAttribute("user",userName);
        return "productdetail";

    }

    @RequestMapping(value = "/productCart", method = RequestMethod.POST)
    public ResponseEntity loginPage(@RequestBody ShopCart shopCart) {
        return new ResponseEntity(productService.insertToCart(shopCart), HttpStatus.OK);
    }

}