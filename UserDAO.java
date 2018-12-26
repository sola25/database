package database;
import java.util.Set;

import database.User; 
public interface UserDAO {
public int addUser(User user) ;
	
	public int deleteUser(String name);
	
	public int updateUser(String name);
	
	public Order findUser(String name);
	
	public Set<User> findAll();
}
