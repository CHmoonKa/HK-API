package com.hk.api.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.hk.api.dao.AppDao;
import com.hk.api.vo.AppVo;

@Service
public class AppServiceImpl implements AppService {

    private static final Logger logger = LoggerFactory.getLogger("com.hk.api.service");

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private AppDao appDao;

    @Override
    public AppVo getApp(int id) {
    	logger.debug("user get the app version with id: " + id);
        return appDao.getAppVersion(id);
    }
}
