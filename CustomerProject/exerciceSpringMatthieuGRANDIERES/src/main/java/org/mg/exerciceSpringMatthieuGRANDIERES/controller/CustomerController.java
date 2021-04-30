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
    public String createCustomer() {
        customService.getAllCustomer().add(customService.createCustomer());
        return "User create";
    }

    /**@GetMapping(path="/customers/{zip}")
    public Communes getZip(@PathVariable("zip") int zip) {

        RestTemplate restTemplate = new RestTemplate();
        Communes response
                = restTemplate.getForObject("https://geo.api.gouv.fr/communes/"+zip, Communes.class);
        System.out.println(response);
        return response;

    }**/
}
