package com.testmvc.springtest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

//@Controller
//클라이언트가 요청한 URL과 @RequestMapping 어노테이션의 값을 이용해서 클라이언트의 요청을 어떤 컨트롤러의 어떤 메서드가 처리할 지가 결정
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//web.xml에서 서블릿name:appServlet, value:"/"로 맵핑-> url패턴이 value값인가?(아님): url패턴은 진짜 패턴
	//그럼 requestmapping에서 value는 어떤 기준으로 받는가?
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//브라우저에 보여줄 뷰의 이름을 전달 즉 home.jsp뷰를 뜻하는 것
		return "home";
	}
	
}
