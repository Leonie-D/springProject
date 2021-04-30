package team.vert.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.vert.order.dao.OrderRepository;
import team.vert.order.dto.ItemDTO;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public ItemDTO[] getItemsList() {
        String resourceUrl
            = "http://localhost:8081"; // TODO update
        ResponseEntity<ItemDTO[]> response
                = restTemplate.getForEntity(resourceUrl, ItemDTO[].class);
        return response.getBody();
    }
}
