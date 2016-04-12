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
    HistoryMapper historyMapper;
    @Autowired
    UserMapper userMapper;
    private final static Logger logPrint = Logger.getLogger(HistoryService.class);


    public HistoryMapper getHistoryMapper() {
        return historyMapper;
    }

    public void setHistoryMapper(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<History> getHistoryByUser(String userName) {
        return historyMapper.getHistoryByUser(userName);
    }
    public boolean insertHistory(User user,History history){
        try {
            if(userMapper.findUserByName(user)  != null) {
                if(historyMapper.findHistory(history) != null){
                    return historyMapper.updateTime(history) > 0;
                }
                else{
                    return historyMapper.insertHistory(history)>0;
                }
            }
            else {
                return (userMapper.insertUser(user)>0 && historyMapper.insertHistory(history)>0);
            }
        }catch (Exception e) {
            logPrint.error(e);
        }
        return false;
    }
}
