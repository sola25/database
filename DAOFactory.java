package express;

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
	public static ExpressDAO getExpressDAO(){
//获得ProductDAO对象，其实是ProductDAOMSImpl对象
		ExpressDAO expressDAO = new ExpressDAOMSImpl();
		return expressDAO;
	}
}
