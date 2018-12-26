package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import database.Product;
import database.ProductDAO;
import database.JDBCUtils;

public class ConcreteProductDao implements ProductDAO{

	//删除一个商品
    public int addProduct(Product product)
    {
    	Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = JDBCUtils.getConnection();
    	    String sql = "insert into product(proId,proName,proprice) values(?,?,?)";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setInt(1, product.getProId());
    	    ps.setString(2, product.getProName());
    	    ps.setFloat(3, product.getProprice());
    	    
    	    i = ps.executeUpdate() ;
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		JDBCUtils.free(null, ps, con);
    	}
    	return i;
    }
	
    //删除一个商品
	public int deleteProduct(String name)
	{
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = JDBCUtils.getConnection();
    	    String sql = "delete from product where proName =?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1, name);
    	    
    	    i = ps.executeUpdate() ;
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		JDBCUtils.free(null, ps, con);
    	}
	    	
		return i;
	}
	
	//修改一个商品
	public int updateProduct(String name)
	{
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = JDBCUtils.getConnection();
    	    String sql = "update product set proprice=proprice+1  where proName =?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1, name);
    	    
    	    i = ps.executeUpdate() ;
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		JDBCUtils.free(null, ps, con);
    	}
		
		return i;
	}
	//查询一行
	public Product Product(String name)
	{
		Connection con = null ;
    	PreparedStatement ps = null ;
    	Product pro = null ;
    	ResultSet rs = null;
    	try
    	{
    	    con = JDBCUtils.getConnection();
    	    String sql = "select proName,proId,proprice from product where proName =?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1, name);
    	    
    	    rs = ps.executeQuery() ;
    	    pro = new Product();
    	    while(rs.next())
    	    {
    	    	pro.setProId(rs.getInt(1));
    	    	pro.setProName(rs.getString(2));
    	    	pro.setProprice(rs.getFloat(3));
    	    }
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		JDBCUtils.free(rs, ps, con);
    	}
		
		return pro;
	}
	
	//查询所有
	public Set<Product> findAll()
	{
		Connection con = null ;
    	PreparedStatement ps = null ;
    	Product pro = null ;
    	ResultSet rs = null;
    	Set<Product> set = null ;
    	try
    	{
    	    con = JDBCUtils.getConnection();
    	    String sql = "select proName,proId,proprice from product";
    	    ps = con.prepareStatement(sql);
    	    
    	    set = new HashSet<Product>() ;
    	    rs = ps.executeQuery() ;
    	    
    	    while(rs.next())
    	    {
    	    	pro = new Product();
    	    	
    	    	pro.setProId(rs.getInt(1));
    	    	pro.setProName(rs.getString(2));
    	    	pro.setProprice(rs.getFloat(3));
    	    	
    	    	set.add(pro);
    	    }
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		JDBCUtils.free(rs, ps, con);
    	}
		
		return set;
	}



}
