package com.hk.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.hk.api.dao.db2.AuthorDao;
import com.hk.api.vo.AuthorVo;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final Logger logger = LoggerFactory.getLogger("com.hk.api.service");

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AuthorDao authorDao;


	@Override
	public AuthorVo getAuthor(int id) {
		logger.debug("user get the author with id: " + id);
		return authorDao.getAuthor(id);
	}
}
