package database;
import java.util.Set;

import database.Type; 
public interface TypeDAO {
public int addType(Type type) ;
	
	public int deleteType(String name);
	
	public int updateType(String name);
	
	public Order findType(String name);
	
	public Set<Type> findAll();
}
