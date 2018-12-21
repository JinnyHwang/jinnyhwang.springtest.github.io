package com.testmvc.springtest.ex01.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
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
@Controller

//특정 URL에 매칭되는 클래스나 메소드를 명시하는 애노테이션
//@RequestMapping("/ex01")
//@WebServlet("/ex01")
//하.. webservlet말고 그냥 requestmapping 쓰자...

//@RequestMapping(value = "/ex01")
//@RequestMapping(value = "/", method = RequestMethod.GET)
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
	@RequestMapping(value = "/home")
	public void home() {
		logger.info("SampleController.java home()");
		
	}
	
	@RequestMapping(value = "/ex01/doA")
	public void doA(){
		logger.info("SampleController.java doA()");
	}

	//doB.jsp 파일 맵핑
	@RequestMapping(value = "/ex01/doB")
	public void doB(){
		logger.info("SampleController.java doB()");
	}

	// void 타입일 경우 접근하는 URL 경로에 해당하는 jsp를 찾아 실행한다.
	// 예를 들어 /ex01/doB로 접근했다면 ex01 폴더 아래 doB.jsp를 찾아 실행시킨다.

}
