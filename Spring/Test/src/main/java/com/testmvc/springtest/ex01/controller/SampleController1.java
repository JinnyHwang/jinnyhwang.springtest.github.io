package com.testmvc.springtest.ex01.controller;

import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 */

//view 폴더 중 ex01 폴더에 작성된 jsp(뷰) 이용할 것

//클래스를 컨트롤러로 설정하는 애노테이션


//특정 URL에 매칭되는 클래스나 메소드를 명시하는 애노테이션
//@RequestMapping("/ex01")
//@WebServlet("/ex01")
//하.. webservlet말고 그냥 requestmapping 쓰자...

//@RequestMapping(value = "/ex01")
//@RequestMapping(value = "/", method = RequestMethod.GET)

//@Controller

//@RequestMapping(value = "/")
public class SampleController1{

	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);

	//doA.jsp 파일 맵핑
	//doA 로 접근할 경우 doA( ) 메소드가 이에대한 처리를 하겠다

	// 클래스에도 @RequestMapping이 사용되었기에 doA( )가 처리하는 URL은 /ex01/doA
	//@RequestMapping("/doA")
	//@RequestMapping(value = "/", method = RequestMethod.GET)

	//https://javatutorial.net/servlet-annotation-example
	/*
	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.getWriter().println("Hello World!");
		logger.info("SampleController.java doGet() start");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String servletName = getServletConfig().getServletName();
		writer.println("handling request, servlet name: " + servletName);
		writer.println("<br/>");
		writer.println("user: "+reqest.getUserPrincipal().getName());
		writer.println( "<br/><a href=\"/doA.jsp\">Main Page</a>");
	}
	 */

	//int num = 0;
	//int num2 = 10;



	@RequestMapping(value="/")
	public String home(Locale locale, Model model) {
		logger.info("SampleController.java home()");

		//ko_KR라는 이름이 담긴다. -> 특정 나라의 시간을 담기 위해 사용됨
		logger.info("Welcome home! The client locale is {}.", locale);
		//num++;
		//logger.info("몇 번 접근하는가? {} ", num);

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		//jsp에 값을 전달하기 위해 model사용 어트리뷰트 명을 정하고 값을 담아 보내면 jsp에선 attribute명으로 값 사용 가능!
		//실시간 접속시간X 처음 서버에 접속했을 때 시간!
		model.addAttribute("serverTime", formattedDate );

		//브라우저에 보여줄 뷰의 이름을 전달 즉 home.jsp뷰를 뜻하는 것
		return "home";
	}

	//doB.jsp 파일 맵핑
	@RequestMapping(value = "/ex01/doB")
	public void doB(){
		logger.info("SampleController.java doB()");
		//num2--;
		//logger.info("몇 번 접근하는가? {}, {} ", num, num2);	
	}

	//주소창에 msg 파라미터 값을 가져와 변수에 저장?
	@RequestMapping(value = "/ex01/test")
	public void doA(@ModelAttribute("msg") String msg){
		logger.info("SampleController.java doA()");
		//num2++;
		//logger.info("몇 번 접근하는가? {}, {}", num, num2);
		logger.info("어떤 값이 출력될까? {} ",msg);
	}

	// void 타입일 경우 접근하는 URL 경로에 해당하는 jsp를 찾아 실행한다.
	// 예를 들어 /ex01/doB로 접근했다면 ex01 폴더 아래 doB.jsp를 찾아 실행시킨다.

}
