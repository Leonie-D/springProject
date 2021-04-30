package team.vert.order.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import team.vert.order.dao.CustomerRepository;
import team.vert.order.dao.ItemRepository;
import team.vert.order.entity.Customer;
import team.vert.order.entity.Item;
import team.vert.order.entity.Order;
import team.vert.order.service.OrderService;
import team.vert.order.dao.OrderRepository;

@Component
public class LoadDatabase implements ApplicationRunner {
    private OrderRepository orderRepository;
    private OrderService orderService;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public LoadDatabase(OrderRepository orderRepository, OrderService orderService, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Order order = new Order();
        order.setName("Test");
        order.setCustomer(new Customer(2, "Henry"));
        order.addItem(new Item(3, "robinet"));
        order.addItem(new Item(12, "vélo"));
        order.addItem(new Item(34, "fleur"));
        orderRepository.save(order);

        // importer les items
        /*Item[] items = orderService.getItemsList();
        for(int i = 0; i < items.length; i++) {
            itemRepository.save(items[i]);
        }*/

        // importer les customers
        /*Customer[] customers = orderService.getCustomersList();
        for(int i = 0; i < customers.length; i++) {
            customerRepository.save(customers[i]);
        }*/
    }
}
