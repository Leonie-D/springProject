package team.vert.order.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import team.vert.order.dao.ItemRepository;
import team.vert.order.entity.Item;
import team.vert.order.entity.Order;
import team.vert.order.service.OrderService;
import team.vert.order.dao.OrderRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadDatabase implements ApplicationRunner {
    private OrderRepository orderRepository;
    private OrderService orderService;
    private ItemRepository itemRepository;

    @Autowired
    public LoadDatabase(OrderRepository orderRepository, OrderService orderService, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Order order = new Order();
        order.setName("Test");
        order.setCustomerId(2L);
        order.setItems((List) new ArrayList<Long>(Arrays.asList(1L, 3L, 45L)));
        orderRepository.save(order);

        // importer les items
        Item[] items = orderService.getItemsList();
        for(int i = 0; i < items.length; i++) {
            itemRepository.save(items[i]);
        }
    }
}
