package team.vert.order.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import team.vert.order.service.OrderService;
import team.vert.order.dao.OrderRepository;

@Component
public class LoadDatabase implements ApplicationRunner {
    private OrderRepository orderRepository;
    private OrderService orderService;

    @Autowired
    public LoadDatabase(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {}
}
