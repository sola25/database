package list;

public class test {

	public static void main(String[] args) {
		OrderDAO orderDAO=DAOFactory.getInstance().getOrderDAO();
		Order order=new Order();
        orderDAO.insertOrder(order);
        orderDAO.updateOrder(order);
        orderDAO.getOrder(null);
        orderDAO.getOrderByC("");
        orderDAO.deleteOrder(null);
	    
	   
	}

}
