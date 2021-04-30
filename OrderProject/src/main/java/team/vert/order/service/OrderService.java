package team.vert.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.vert.order.NotFoundException;
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
        if(response.getBody() != null) {
            return response.getBody();
        } else {
            throw new NotFoundException("Une erreur est survenue");
        }
    }

    public Customer[] getCustomersList() throws NotFoundException {
        String resourceUrl
                = "http://localhost:8080"; // TODO update
        ResponseEntity<Customer[]> response
                = restTemplate.getForEntity(resourceUrl, Customer[].class);
        if(response.getBody() != null) {
            return response.getBody();
        } else {
            throw new NotFoundException("Une erreur est survenue");
        }
    }

    public Customer getCustomerDetails(int userId) throws NotFoundException {
        String resourceUrl
                = "http://localhost:8083/userId";
        ResponseEntity<Customer> response
                = restTemplate.getForEntity(resourceUrl, Customer.class);
        if(response.getBody() != null) {
            return response.getBody();
        } else {
            throw new NotFoundException("L'utilisateur demandé n'existe pas");
        }
    }

    public void addOrder(Order order, int userId) {
        Customer customer = this.getCustomerDetails(userId);
        order.setCustomer(customer);
        orderRepository.save(order);
    }
}
