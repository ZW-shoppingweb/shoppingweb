package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.Null;
//gitimport org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by cxzhao on 3/28/16.
 */
public class ImplementProduct {
    public String getPaginationProductList(Map<String,Object>para){
        System.out.println("start"+para.get("start"));
        if (para.get("filterName")==null||para.get("filterName")=="")
        return  "select * from product limit "+ para.get("start")+","+para.get("size");
           else return "select * from product where "+para.get("filterName")+"="+para.get("filterValue")+" limit "+ para.get("start")+","+para.get("size");

    }
    public String getNumOfProducts(Map<String,Object>para){
        if (para.get("filterName")==null||para.get("filterName")=="")
            return "select count(1) from product";

        else return "select count(1) from product where "+para.get("filterName")+"="+para.get("filterValue");


    }
}
