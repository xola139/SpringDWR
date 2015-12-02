package com.elkardumen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProyectoController {

	@RequestMapping("/inicial.html")
    public String loadIndex() {
		return "index";
    }
    
}