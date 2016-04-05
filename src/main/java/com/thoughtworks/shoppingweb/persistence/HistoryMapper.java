package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.History;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper {


    public History findHistory(History history);
    public List<History> getHistoryByUser(String userName);
    public int insertHistory(History history);
    public int updateTime(History history);


}






