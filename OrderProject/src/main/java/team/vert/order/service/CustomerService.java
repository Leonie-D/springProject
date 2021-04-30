package team.vert.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.vert.order.dao.CustomerRepository;
import team.vert.order.entity.Customer;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        if(!customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
        }
    }
}
