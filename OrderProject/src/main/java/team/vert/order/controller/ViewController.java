package team.vert.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import team.vert.order.entity.Item;
import team.vert.order.entity.Order;
import team.vert.order.service.OrderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "{userId}/home")
    public String index(Model model, @PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByCustomer(userId);
        model.addAttribute("orders", orders);
        return "home";
    }

    @GetMapping(path = "/new-order")
    public String newOrderForm(Model model) {
        model.addAttribute("user", "truc"); // TODO
        List<Item> items = Arrays.asList(orderService.getItemsList());
        model.addAttribute("items", items);
        model.addAttribute("order", new Order());
        return "newOrder";
    }

    @PostMapping(path = "/create")
    public String create(@ModelAttribute Order order) {
        return "redirect:/home";
    }
}
