package team.vert.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.vert.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
