package team.vert.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    private int id;

    @Column
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
