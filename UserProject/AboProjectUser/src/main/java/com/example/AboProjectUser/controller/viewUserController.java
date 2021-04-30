package com.example.AboProjectUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.AboProjectUser.service.userService;


@Controller
public class viewUserController {
	@Autowired
	private userService service ;
	
	@GetMapping("/view")
	public String view(Model model) {
		
		model.addAttribute("users",service.getUser());
		
		return "view" ;
	}

}
