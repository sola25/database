package list;

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
	public static OrderDAO getOrderDAO(){
//���ProductDAO������ʵ��ProductDAOMSImpl����
		OrderDAO orderDAO = new OrderDAOMSImpl();
		return orderDAO;
	}
}
