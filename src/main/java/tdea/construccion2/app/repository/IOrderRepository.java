package tdea.construccion2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.app.models.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
	public Order findById(int id);
	 public boolean existsById(int id);
}
