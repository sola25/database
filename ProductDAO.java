package database;
//import java.util.Set;

import database.Product; 

public interface ProductDAO {
public int addProduct(Product product) ;
	
	public int deleteProduct(String name);
	
	public int updateProduct(String name);
	
	public Product findProduct(String name);
	
	//public Set<Product> findAll();


}
