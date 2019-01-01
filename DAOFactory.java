package user;

import user.DAOFactory;
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
	public static UserDAO getUserDAO(){
//获得UserDAO对象，其实是UserDAOMSImpl对象
		UserDAO userDAO = new UserDAOMSImpl();
		return userDAO;
	}
}
