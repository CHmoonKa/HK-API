package com.hk.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.api.service.AppService;
import com.hk.api.vo.AppVo;

@Controller
@SuppressWarnings("unchecked")
public class AppController {

    @Autowired
    private AppService appService;

    
	@RequestMapping(value = "/hello/version.hk", method = RequestMethod.GET)
    public ResponseEntity<String> signup(HttpServletRequest request) {
    	String sid = request.getParameter("id");
    	JSONObject obj = new JSONObject();
    	int id = 1;
    	if(sid != null){
    		try {
				id = Integer.parseInt(sid);
			} catch (NumberFormatException e) {
				id = 1;
			}
    	}
    	AppVo av = appService.getApp(id);
    	obj.put("version", av.getVersion());
    	obj.put("update", av.getUpdated());
    	
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(obj.toString(), responseHeaders, HttpStatus.OK);
    }
}
