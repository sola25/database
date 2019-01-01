package type;

import type.DAOFactory;
import type.TypeDAO;
import type.TypeDAOMSImpl;

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
	public static TypeDAO getTypeDAO(){
//���TypeDAO������ʵ��TypeDAOMSImpl����
		TypeDAO typeDAO = new TypeDAOMSImpl();
		return typeDAO;
	}
}
