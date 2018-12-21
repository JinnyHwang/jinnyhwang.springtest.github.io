package com.testmvc.springtest.ex01.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//view 폴더 중 ex01 폴더에 작성된 jsp(뷰) 이용할 것

//클래스를 컨트롤러로 설정하는 애노테이션
@Controller

//특정 URL에 매칭되는 클래스나 메소드를 명시하는 애노테이션
@RequestMapping("/ex01")
public class SampleController1 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
    
	//doA.jsp 파일 맵핑
	//doA 로 접근할 경우 doA( ) 메소드가 이에대한 처리를 하겠다
	
	// 클래스에도 @RequestMapping이 사용되었기에 doA( )가 처리하는 URL은 /ex01/doA
    @RequestMapping("/doA")
    public void doA(){
        logger.info("doA 실행..........");
    }
    
  //doB.jsp 파일 맵핑
    @RequestMapping("/doB")
    public void doB(){
        logger.info("doB 실행..........");
    }
    
    // void 타입일 경우 접근하는 URL 경로에 해당하는 jsp를 찾아 실행한다.
    // 예를 들어 /ex01/doB로 접근했다면 ex01 폴더 아래 doB.jsp를 찾아 실행시킨다.

}
