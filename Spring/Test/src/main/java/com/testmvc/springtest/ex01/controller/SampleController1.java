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

//view ���� �� ex01 ������ �ۼ��� jsp(��) �̿��� ��

//Ŭ������ ��Ʈ�ѷ��� �����ϴ� �ֳ����̼�


//Ư�� URL�� ��Ī�Ǵ� Ŭ������ �޼ҵ带 ����ϴ� �ֳ����̼�
//@RequestMapping("/ex01")
//@WebServlet("/ex01")
//��.. webservlet���� �׳� requestmapping ����...

//@RequestMapping(value = "/ex01")
//@RequestMapping(value = "/", method = RequestMethod.GET)

//@Controller

//@RequestMapping(value = "/")
public class SampleController1{

	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);

	//doA.jsp ���� ����
	//doA �� ������ ��� doA( ) �޼ҵ尡 �̿����� ó���� �ϰڴ�

	// Ŭ�������� @RequestMapping�� ���Ǿ��⿡ doA( )�� ó���ϴ� URL�� /ex01/doA
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

		//ko_KR��� �̸��� ����. -> Ư�� ������ �ð��� ��� ���� ����
		logger.info("Welcome home! The client locale is {}.", locale);
		//num++;
		//logger.info("�� �� �����ϴ°�? {} ", num);

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		//jsp�� ���� �����ϱ� ���� model��� ��Ʈ����Ʈ ���� ���ϰ� ���� ��� ������ jsp���� attribute������ �� ��� ����!
		//�ǽð� ���ӽð�X ó�� ������ �������� �� �ð�!
		model.addAttribute("serverTime", formattedDate );

		//�������� ������ ���� �̸��� ���� �� home.jsp�並 ���ϴ� ��
		return "home";
	}

	//doB.jsp ���� ����
	@RequestMapping(value = "/ex01/doB")
	public void doB(){
		logger.info("SampleController.java doB()");
		//num2--;
		//logger.info("�� �� �����ϴ°�? {}, {} ", num, num2);	
	}

	//�ּ�â�� msg �Ķ���� ���� ������ ������ ����?
	@RequestMapping(value = "/ex01/test")
	public void doA(@ModelAttribute("msg") String msg){
		logger.info("SampleController.java doA()");
		//num2++;
		//logger.info("�� �� �����ϴ°�? {}, {}", num, num2);
		logger.info("� ���� ��µɱ�? {} ",msg);
	}

	// void Ÿ���� ��� �����ϴ� URL ��ο� �ش��ϴ� jsp�� ã�� �����Ѵ�.
	// ���� ��� /ex01/doB�� �����ߴٸ� ex01 ���� �Ʒ� doB.jsp�� ã�� �����Ų��.

}
