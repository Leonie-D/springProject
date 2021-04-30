package team.vert.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.vert.order.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
}
