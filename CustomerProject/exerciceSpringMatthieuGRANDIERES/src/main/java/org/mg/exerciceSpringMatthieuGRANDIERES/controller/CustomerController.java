package org.mg.exerciceSpringMatthieuGRANDIERES.controller;

import org.mg.exerciceSpringMatthieuGRANDIERES.entity.Communes;
import org.mg.exerciceSpringMatthieuGRANDIERES.entity.Customer;
import org.mg.exerciceSpringMatthieuGRANDIERES.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customService;

    @GetMapping(path = "/customers")
    public List<Customer> getCustomers(){

        return customService.getAllCustomer();
    }

    @GetMapping(path = "/customers/{id}")
    public Customer getId(@PathVariable("id") int id){
        return customService.getId(id - 1);
    }

    @DeleteMapping(path = "/customers/delete/{id}")
    public Customer deleteId(@PathVariable("id") int id){
        return customService.deleteId(id - 1);
    }

    @PostMapping(path = "/customers/create")
    public RedirectView createCustomer() {
        RedirectView redirectView = new RedirectView();
        customService.getAllCustomer().add(customService.createCustomer());
        redirectView.setUrl("http://localhost:8080/view");
        return redirectView;
    }


    /*@PostMapping(path = "/customers/createCustomer")
    public String createCustomerView(@RequestBody Customer newCustomer) {
        customService.getAllCustomer().add(customService.createCustomerView());
        return "redirect:/view";
    }*/

}
