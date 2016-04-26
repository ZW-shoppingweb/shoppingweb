package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.domain.*;
import com.thoughtworks.shoppingweb.service.*;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    HistoryService historyService;

    public static final int DEFAULT_PAGE_NUM = 1;
    private final static Logger log = Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    public ResponseEntity productList(@RequestBody QueryFilter queryFilter,HttpServletRequest request) {
        PaginationData paginationData = new PaginationData();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setCurrentPageNum(getCurrentPage(queryFilter));
        productService.getProductPaginationData(paginationData);
        HttpSession session = request.getSession(true);
        session.setAttribute("pageInfo",paginationData);
        session.setAttribute("query",queryFilter);
        Map result = new HashMap();
        result.put("indexPage",paginationData);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    private int getCurrentPage(QueryFilter queryFilter) {
        if (queryFilter.getPageId() != "" && queryFilter.getPageId() != null) {
            return Integer.parseInt(queryFilter.getPageId());
        }
        return  DEFAULT_PAGE_NUM;
    }

    @RequestMapping(value = "/productListPage", method = RequestMethod.GET)
    public String productListAll(QueryFilter queryFilter,Model model,HttpServletRequest request) {
        PaginationData paginationData = new PaginationData();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setPageData(productService.getAllProduct(1, 16));
        paginationData.setCurrentPageNum(1);
        paginationData = productService.getProductPaginationData(paginationData);
        HttpSession session = request.getSession(true);
        session.setAttribute("pageInfo",paginationData);
        model.addAttribute("pageData", paginationData.getPageData());
        return "index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        List<Product> products=productService.getNewProduct(new QueryFilter());
        List<Product> products1=products.subList(0,3);
        model.addAttribute("newProduct", products1);
        return "home";
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such PaginationData")  // 404
    public class ProductNotFoundException extends RuntimeException {
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") String id, @RequestParam(value="userName",
            defaultValue = "", required = false) String userName, Model model,HttpServletRequest request) {
        Product product = productService.getProduct(id);
        if (product == null) throw new ProductNotFoundException();
        model.addAttribute("product",product);
        User user=createUser(userName,request);
        createHistory(user,id,model);
        return "productdetail";
    }

    public User createUser(String userName,HttpServletRequest request){
        if(userName == null || userName.equals("")) {
            userName = UUID.randomUUID().toString();
        }
        User user =new User();
        user.setUserName(userName);
        HttpSession session = request.getSession(true);
        session.setAttribute("memberName",userName);
        return user;
    }
    public void createHistory(User user,String id,Model model){
        History history = new History();
        history.setHistoryId(1);
        history.setUserName(user.getUserName());
        history.setProductId(id);
        long nowtime = System.currentTimeMillis();
        history.setSeeTime(new java.sql.Timestamp(nowtime));
        historyService.insertHistory(user,history);
        model.addAttribute("history",historyService.getHistoryByUser(user.getUserName()));
    }
}