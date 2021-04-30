package team.vert.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.vert.order.dao.OrderRepository;
import team.vert.order.entity.Item;
import team.vert.order.entity.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Item[] getItemsList() {
        String resourceUrl
            = "http://localhost:8081"; // TODO update
        ResponseEntity<Item[]> response
                = restTemplate.getForEntity(resourceUrl, Item[].class);
        return response.getBody();
    }
}
