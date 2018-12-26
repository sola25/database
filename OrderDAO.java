package database;
import java.util.Set;

import database.Order; 
public interface OrderDAO {
public int addOrder(Order order) ;
	
	public int deleteOrder(String name);
	
	public int updateOrder(String name);
	
	public Order findOrder(String name);
	
	public Set<Order> findAll();
}
