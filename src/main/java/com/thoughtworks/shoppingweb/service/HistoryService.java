package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.History;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.HistoryMapper;
import com.thoughtworks.shoppingweb.persistence.ProductMapper;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private UserMapper userMapper;

    public HistoryMapper getHistoryMapper() {
        return historyMapper;
    }

    public void setHistoryMapper(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    public List<History> getHistoryByUser(String userName) {
        return historyMapper.getHistoryByUser(userName);
    }
    public int insertHistory(String userName,String id){
        User user =new User();
        user.setUserName(userName);
        if(userMapper.findUserByName(user)  != null) {
            History history = new History();
            history.setUserName(userName);
            history.setProductId(id);
            long nowtime = System.currentTimeMillis();
            history.setSeeTime(new java.sql.Timestamp(nowtime));
            if(historyMapper.findHistory(history) != null){
                return historyMapper.updateTime(history);
            }
            else{
                return historyMapper.insertHistory(history);
            }
        }
        else {
            return 0;
        }
    }

}
