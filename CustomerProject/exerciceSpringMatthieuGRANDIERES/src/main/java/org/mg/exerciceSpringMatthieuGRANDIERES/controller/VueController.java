package org.mg.exerciceSpringMatthieuGRANDIERES.controller;

import org.mg.exerciceSpringMatthieuGRANDIERES.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class VueController {

    @Autowired
    CustomerService customService;

    @GetMapping(path = "/view-id/{id}")
    public String viewById(@PathVariable String id, Model model){
        model.addAttribute("customer", customService.getId(Integer.parseInt(id)));
        return "view-id";
    }

    @GetMapping(path = "/view")
    public String view(Model model){
        model.addAttribute("customers", customService.getAllCustomer());
        return "view";
    }
}
