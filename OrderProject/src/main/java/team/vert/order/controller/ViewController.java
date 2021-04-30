package team.vert.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import team.vert.order.entity.Customer;
import team.vert.order.entity.Item;
import team.vert.order.entity.Order;
import team.vert.order.service.OrderService;

import java.util.Arrays;

@Controller
public class ViewController {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "{userId}/home")
    public String index(Model model, @PathVariable int userId) {
        model.addAttribute("customer", orderService.getCustomerDetails(userId));
        model.addAttribute("orders", orderService.getOrdersByCustomer(userId));
        return "home";
    }

    @GetMapping(path = "{userId}/new-order")
    public String newOrderForm(Model model, @PathVariable int userId) {
        model.addAttribute("customer", orderService.getCustomerDetails(userId));
        model.addAttribute("items", Arrays.asList(orderService.getItemsList()));
        model.addAttribute("order", new Order());
        return "newOrder";
    }

    @GetMapping(path = "show-order/{id}")
    public String showOrder(Model model, @PathVariable int id) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "showOrder";
    }

    @PostMapping(path = "{userId}/create-order")
    public String create(@ModelAttribute Order order, @PathVariable int userId) {
        orderService.addOrder(order, userId);
        return "redirect:/" + userId + "/home";
    }
}
