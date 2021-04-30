package team.vert.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.vert.order.dto.ItemDTO;
import team.vert.order.entity.Order;
import team.vert.order.service.OrderService;

@Controller
public class ViewController {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/home")
    public String index(Model model) {
        return "home";
    }

    @GetMapping(path = "/new-order")
    public String create(Model model) {
        model.addAttribute("user", "truc"); // TODO
        ItemDTO[] items = orderService.getItemsList();
        model.addAttribute("items", items);
        model.addAttribute("order", new Order());
        return "create";
    }
}
