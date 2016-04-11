package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.History;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.HistoryMapper;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private UserMapper userMapper;
    private final static Logger logPrint = Logger.getLogger(HistoryService.class);
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
    public int insertHistory(String userName,String id){
        User user =new User();
        user.setUserName(userName);
        History history = new History();
        history.setUserName(userName);
        history.setProductId(id);
        long nowtime = System.currentTimeMillis();
        history.setSeeTime(new java.sql.Timestamp(nowtime));
        int result=0;
        try {
            if(userMapper.findUserByName(user)  != null) {
                if(historyMapper.findHistory(history) != null){
                    result= historyMapper.updateTime(history);
                }
                else{
                    result= historyMapper.insertHistory(history);
                }
            }
            else {
                user.setUserType(DEFAULT_TOURIST_TYPE);
                user.setPassword(DEFAULT_PASSWORD);
                userMapper.insertUser(user);
                result= historyMapper.insertHistory(history);
            }
        }catch (Exception e) {
            logPrint.error(e);
        }
        return result;
    }
}
