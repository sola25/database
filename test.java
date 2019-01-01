package express;

public class test {

	public static void main(String[] args) {
		ExpressDAO expressDAO=DAOFactory.getInstance().getExpressDAO();
		Express express=new Express();
        expressDAO.insertExpress(express);
        expressDAO.updateExpress(express);
        expressDAO.getExpress(null);
        expressDAO.getExpressByC("");
        expressDAO.deleteExpress(null);
	    
	   
	}

}
