package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.History;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.HistoryMapper;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private UserMapper userMapper;
    public static final String DEFAULT_TOURIST_TYPE = "tourist";
    public static final String DEFAULT_PASSWORD = "123456";

    public HistoryMapper getHistoryMapper() {
        return historyMapper;
    }

    public void setHistoryMapper(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    public List<History> getHistoryByUser(String userName) {
        return historyMapper.getHistoryByUser(userName);
    }

    public int insertHistory(String userName, String id) {
        User user = new User();
        user.setUserName(userName);
        History history = new History();
        history.setUserName(userName);
        history.setProductId(id);
        long nowtime = System.currentTimeMillis();
        history.setSeeTime(new java.sql.Timestamp(nowtime));
        if (userMapper.findUserByName(user) != null) {
            if (historyMapper.findHistory(history) != null) {
                return historyMapper.updateTime(history);
            } else {
                return historyMapper.insertHistory(history);
            }
        } else {
            user.setUserType(DEFAULT_TOURIST_TYPE);
            user.setPassword(DEFAULT_PASSWORD);
            userMapper.insertUser(user);
            return historyMapper.insertHistory(history);
        }
    }

}
