package com.testmvc.springtest.ex01.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//view ���� �� ex01 ������ �ۼ��� jsp(��) �̿��� ��

//Ŭ������ ��Ʈ�ѷ��� �����ϴ� �ֳ����̼�
@Controller

//Ư�� URL�� ��Ī�Ǵ� Ŭ������ �޼ҵ带 ����ϴ� �ֳ����̼�
@RequestMapping("/ex01")
public class SampleController1 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
    
	//doA.jsp ���� ����
	//doA �� ������ ��� doA( ) �޼ҵ尡 �̿����� ó���� �ϰڴ�
	
	// Ŭ�������� @RequestMapping�� ���Ǿ��⿡ doA( )�� ó���ϴ� URL�� /ex01/doA
    @RequestMapping("/doA")
    public void doA(){
        logger.info("doA ����..........");
    }
    
  //doB.jsp ���� ����
    @RequestMapping("/doB")
    public void doB(){
        logger.info("doB ����..........");
    }
    
    // void Ÿ���� ��� �����ϴ� URL ��ο� �ش��ϴ� jsp�� ã�� �����Ѵ�.
    // ���� ��� /ex01/doB�� �����ߴٸ� ex01 ���� �Ʒ� doB.jsp�� ã�� �����Ų��.

}
