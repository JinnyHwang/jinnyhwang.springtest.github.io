package com.testmvc.springtest.ex01.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testmvc.springtest.ex01.vo.MemberVO;

@Controller
@RequestMapping("/ex01")
public class SampleController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	

	
	private String getIp(HttpServletRequest request) {
		 
        String ip = request.getHeader("X-Forwarded-For");
 
        logger.info(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            logger.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            logger.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            logger.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            logger.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        logger.info(">>>> Result : IP Address : "+ip);
 
        return ip;
 
    }

	
	
	@RequestMapping("/doD")
	public String doD(Model model, HttpServletRequest request) {
		
		getIp(request);
		
		logger.info("SampleController2 doD() ");
		
		MemberVO member = new MemberVO();
		member.setUserid("userid-01");
		member.setUserpw("userpw-01");
		
		//이름을 지정하지 않을 경우 자동적으로 객체의 클래스명 앞글자를 소문자로 처리해서 이름으로 사용한다.
		model.addAttribute("member", member);
		
		logger.info("MemberVO : " + member.toString());
		
		return "ex01/data";
	}
	
	@RequestMapping("/doE")
	public String doE(Model model) {
		
		logger.info("SampleController2 doE() ");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", "userid-02");
		map.put("userpw", "userpw-02");
		
		model.addAttribute("map", map);
		
		return "ex01/data";
	}
	

}











