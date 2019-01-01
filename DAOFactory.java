package express;

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
	public static ExpressDAO getExpressDAO(){
//���ProductDAO������ʵ��ProductDAOMSImpl����
		ExpressDAO expressDAO = new ExpressDAOMSImpl();
		return expressDAO;
	}
}
