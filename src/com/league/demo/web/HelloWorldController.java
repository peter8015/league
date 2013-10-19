package com.league.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demo hello world controller
 * 
 * @author Peter Zhang
 * @since 2013-10-15
 * @version
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
	model.addAttribute("message", "Hi");
	return "demo/index";
    }

    @RequestMapping(value = "/helloWorld")
    public String helloWorld(Model model) {
	System.out.println();
	model.addAttribute("message", "同志们,hello world!");
	return "demo/helloWorld";
    }

}
