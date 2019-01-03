package test;

import express.ExpressDAO;
import express.ExpressDAOMSImpl;
import list.OrderDAO;
import list.OrderDAOMSImpl;
import pro.ProductDAO;
import pro.ProductDAOMSImpl;
import type.TypeDAO;
import type.TypeDAOMSImpl;
import user.UserDAO;
import user.UserDAOMSImpl;

public class DAOFactory {
	private static DAOFactory instance;	//声明instance为工厂类
	static{
		instance = new DAOFactory();	//new一个工厂类的instance
	}	
	private DAOFactory(){//构造函数
	}	
	public static DAOFactory getInstance(){
		return instance;					//返回一个工厂类的instance
	}	

	public  UserDAO getUserDAO(){
		//获得UserDAO对象，其实是UserDAOMSImpl对象
				UserDAO userDAO = new UserDAOMSImpl();
				return userDAO;
			}
	
	public  TypeDAO getTypeDAO(){
		//获得TypeDAO对象，其实是TypeDAOMSImpl对象
				TypeDAO typeDAO = new TypeDAOMSImpl();
				return typeDAO;
			}
	
	public  ProductDAO getProductDAO(){
		//获得ProductDAO对象，其实是ProductDAOMSImpl对象
				ProductDAO productDAO = new ProductDAOMSImpl();
				return productDAO;
			}
	
	public  OrderDAO getOrderDAO(){
		//获得ProductDAO对象，其实是ProductDAOMSImpl对象
				OrderDAO orderDAO = new OrderDAOMSImpl();
				return orderDAO;
			}
	
	public  ExpressDAO getExpressDAO(){
		//获得ProductDAO对象，其实是ProductDAOMSImpl对象
				ExpressDAO expressDAO = new ExpressDAOMSImpl();
				return expressDAO;
			}
}
