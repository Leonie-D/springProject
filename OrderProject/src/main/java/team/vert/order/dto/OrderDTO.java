package team.vert.order.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private String name;
    private CustomerDTO customer;
    private List<ItemDTO> items = new ArrayList<ItemDTO>();

    public OrderDTO(Long id, String name, CustomerDTO customer, List<ItemDTO> items) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.items = items;
    }
}
