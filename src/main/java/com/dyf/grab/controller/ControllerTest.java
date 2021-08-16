package com.dyf.grab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

	@RequestMapping("test")
	public String test() {

		logger.info("ControllerTest.........");
		return "/views/index";
	}
    @GetMapping(value = "/")
    public String index(){
        return "/views/index";
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "/views/welcome";
    }
}
