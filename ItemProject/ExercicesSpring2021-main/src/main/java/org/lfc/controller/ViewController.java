package org.lfc.controller;

import org.lfc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/view")
public class ViewController {
	@Autowired
	private ItemService itemService ;
	
	@GetMapping
	// public String findOwner(@PathVariable String ownerId, Model model) {
	public String findOwner(Model model) {
		model.addAttribute("items", itemService.getAll());
		return "view";
	}
}
