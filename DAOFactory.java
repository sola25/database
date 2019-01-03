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
	private static DAOFactory instance;	//����instanceΪ������
	static{
		instance = new DAOFactory();	//newһ���������instance
	}	
	private DAOFactory(){//���캯��
	}	
	public static DAOFactory getInstance(){
		return instance;					//����һ���������instance
	}	

	public  UserDAO getUserDAO(){
		//���UserDAO������ʵ��UserDAOMSImpl����
				UserDAO userDAO = new UserDAOMSImpl();
				return userDAO;
			}
	
	public  TypeDAO getTypeDAO(){
		//���TypeDAO������ʵ��TypeDAOMSImpl����
				TypeDAO typeDAO = new TypeDAOMSImpl();
				return typeDAO;
			}
	
	public  ProductDAO getProductDAO(){
		//���ProductDAO������ʵ��ProductDAOMSImpl����
				ProductDAO productDAO = new ProductDAOMSImpl();
				return productDAO;
			}
	
	public  OrderDAO getOrderDAO(){
		//���ProductDAO������ʵ��ProductDAOMSImpl����
				OrderDAO orderDAO = new OrderDAOMSImpl();
				return orderDAO;
			}
	
	public  ExpressDAO getExpressDAO(){
		//���ProductDAO������ʵ��ProductDAOMSImpl����
				ExpressDAO expressDAO = new ExpressDAOMSImpl();
				return expressDAO;
			}
}
