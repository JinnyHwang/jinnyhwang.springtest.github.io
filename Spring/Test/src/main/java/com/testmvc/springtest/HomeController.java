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
//Ŭ���̾�Ʈ�� ��û�� URL�� @RequestMapping ������̼��� ���� �̿��ؼ� Ŭ���̾�Ʈ�� ��û�� � ��Ʈ�ѷ��� � �޼��尡 ó���� ���� ����
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//web.xml���� ����name:appServlet, value:"/"�� ����-> url������ value���ΰ�?(�ƴ�): url������ ��¥ ����
	//�׷� requestmapping���� value�� � �������� �޴°�?
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//�������� ������ ���� �̸��� ���� �� home.jsp�並 ���ϴ� ��
		return "home";
	}
	
}
