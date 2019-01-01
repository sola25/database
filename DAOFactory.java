package type;

import type.DAOFactory;
import type.TypeDAO;
import type.TypeDAOMSImpl;

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
	public static TypeDAO getTypeDAO(){
//获得TypeDAO对象，其实是TypeDAOMSImpl对象
		TypeDAO typeDAO = new TypeDAOMSImpl();
		return typeDAO;
	}
}
