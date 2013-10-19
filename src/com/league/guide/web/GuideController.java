package com.league.guide.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuideController {

    @RequestMapping(value="/guider")
    public String guide() {
	return "igo/guide/guider";
		
    }
    
}
