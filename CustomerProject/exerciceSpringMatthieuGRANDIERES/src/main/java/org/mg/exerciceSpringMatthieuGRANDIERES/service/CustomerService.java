package org.mg.exerciceSpringMatthieuGRANDIERES.service;

import org.mg.exerciceSpringMatthieuGRANDIERES.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customersArray = new ArrayList<>();

    public CustomerService(){
        customersArray.add(new Customer(1, "Matthieu"));
        customersArray.add(new Customer(2, "Buzz"));
        customersArray.add(new Customer(3, "Woodie"));
        customersArray.add(new Customer(4, "Michel Sardou"));
    }

    public List<Customer> getAllCustomer(){
        return customersArray;
    }

    public Customer getId(int id){
        return customersArray.get(id);
    }

    public Customer deleteId(int id){
        return customersArray.remove(id);
    }

    public Customer createCustomer(){
        int id = customersArray.size() + 1;
        return new Customer(id, "New Customer");
    }

    public void createCustomerView(Customer customer){
        int id = customersArray.size() + 1;
        return new Customer(id, name);
    }


    /*public String searchZipCode(String zipCode){
        String request = "https://geo.api.gouv.fr/communes?codePostal=" + zipCode + "";
        return request;
    }*/

}
