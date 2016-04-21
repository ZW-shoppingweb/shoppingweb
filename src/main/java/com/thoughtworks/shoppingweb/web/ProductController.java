package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.domain.*;
import com.thoughtworks.shoppingweb.service.*;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    HistoryService historyService;
    @Autowired
    UserService userService;

    public static final int DEFAULT_PAGE_NUM = 1;
    private final static Logger log = Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    public String productList(@ModelAttribute QueryFilter queryFilter, Model model) {
        PaginationData paginationData = new PaginationData();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setCurrentPageNum(getCurrentPage(queryFilter));
        productService.getProductPaginationData(paginationData);
        model.addAttribute("indexPage", paginationData);
        model.addAttribute("query", queryFilter);
        return "index";
    }
    private int getCurrentPage(QueryFilter queryFilter) {
        if (queryFilter.getPageId() != "" && queryFilter.getPageId() != null) {
            return Integer.parseInt(queryFilter.getPageId());
        }
        return  DEFAULT_PAGE_NUM;
    }

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public String productListAll(Model model) {
        PaginationData paginationData = new PaginationData();
        QueryFilter queryFilter = new QueryFilter();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setPageData(productService.getAllProduct(1, 16));
        paginationData.setCurrentPageNum(1);
        paginationData = productService.getProductPaginationData(paginationData);
        model.addAttribute("indexPage", paginationData);
        return "index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("newProduct", productService.getThreeNewProduct());
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