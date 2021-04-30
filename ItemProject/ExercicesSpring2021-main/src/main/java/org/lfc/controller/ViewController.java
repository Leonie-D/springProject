package org.lfc.controller;

import org.lfc.entity.Item;
import org.lfc.exception.APIException;
import org.lfc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/itemview")
public class ViewController {
	@Autowired
	private ItemService itemService ;
	
	@GetMapping
	// public String findOwner(@PathVariable String ownerId, Model model) {
	public String findOwner(Model model) {
		model.addAttribute("items", itemService.getAll());
		return "view";
	}
	
	 @PostMapping("/additem")
	    public String create(@ModelAttribute("item") Item item) throws APIException  {
	            itemService.create(item);
	            return "redirect:/itemview";
	    }


	    @DeleteMapping("/deleteitem/{id}")
	    public String delete(@PathVariable("id") String id) throws APIException {

	            itemService.delete(id);
	       

	        return "redirect:/itemview";
	    }
	

}
