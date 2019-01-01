package user;

import user.DAOFactory;
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
	public static UserDAO getUserDAO(){
//���UserDAO������ʵ��UserDAOMSImpl����
		UserDAO userDAO = new UserDAOMSImpl();
		return userDAO;
	}
}
