package team.vert.order.dto;

import team.vert.order.entity.Customer;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private String name;
    private String city;
    private List<Customer> customers = new ArrayList<>();

    public OrderDTO(Long id, String name, String city, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.customers = customers;
    }
}
