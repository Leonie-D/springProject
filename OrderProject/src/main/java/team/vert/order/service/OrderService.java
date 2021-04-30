package team.vert.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.vert.order.dao.OrderRepository;
import team.vert.order.entity.Customer;
import team.vert.order.entity.Item;
import team.vert.order.entity.Order;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            return null;
        } else {
            return order.get();
        }
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Item[] getItemsList() {
        String resourceUrl
            = "http://localhost:8081"; // TODO update
        ResponseEntity<Item[]> response
                = restTemplate.getForEntity(resourceUrl, Item[].class);
        return response.getBody();
    }

    public Customer[] getCustomersList() {
        String resourceUrl
                = "http://localhost:8080"; // TODO update
        ResponseEntity<Customer[]> response
                = restTemplate.getForEntity(resourceUrl, Customer[].class);
        return response.getBody();
    }

    public Customer getCustomerDetails(int userId) {
        String resourceUrl
                = "http://localhost:8080"; // TODO update
        ResponseEntity<Customer> response
                = restTemplate.getForEntity(resourceUrl, Customer.class);
        return response.getBody();
    }
}
