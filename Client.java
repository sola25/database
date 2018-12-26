package database;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import database.Product;
import database.ProductService;

public class Client {
	public static void main(String[] args)
	   {
		   Product pro = new Product();
		   Set<Product> set = new HashSet<Product>();
		   pro.setProName("zhangsan");
		   pro.setProId(110);
		   pro.setProprice((float) 36.5);

		   ProductService ss = new ProductService();
		   System.out.println(ss.add(pro));
		   System.out.println(ss.delete("aa"));
		   System.out.println(ss.update("bb"));
		   pro = ss.find("cc");
		   System.out.println(pro.getProName() +" " +pro.getProId()+" "+pro.getProprice());
		   //set = ss.findAll() ;
		   Iterator<Product> iterator = set.iterator();
		   while(iterator.hasNext())
		   {
			   Product product =  (Product)iterator.next() ;
			  System.out.println(product.getProName() +" " +product.getProId()+" "+product.getProprice());
		   }
	   }

}
