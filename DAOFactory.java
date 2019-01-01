package list_pro;

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
	public static list_proDAO getlist_proDAO(){
//���ProductDAO������ʵ��ProductDAOMSImpl����
		list_proDAO list_proDAO = new list_proDAOMSImpl();
		return list_proDAO;
	}
}
