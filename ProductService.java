package database;
import java.util.Set;

import database.Product;
import database.ProductDAO;
import database.ConcreteProductDao;

public class ProductService {
        ProductDAO sd = new ConcreteProductDao();
	
	public int add(Product product)
	{
		return this.sd.addProduct(product);
	}
	
	public int delete(String name)
	{
		return this.sd.deleteProduct(name);
	}
	
	public int update(String name)
	{
		return this.sd.updateProduct(name);
	}
	
	public Product find(String name)
	{
		return this.sd.findProduct(name);
	}
	
	/*public Set<Product> findAll()
	{
		return this.sd.findAll();
	}*/

}
