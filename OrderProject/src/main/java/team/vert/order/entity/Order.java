package team.vert.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CustomerOrder")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
}
