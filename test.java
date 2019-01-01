package list_pro;

public class test {

	public static void main(String[] args) {
		list_proDAO list_proDAO=DAOFactory.getInstance().getlist_proDAO();
		list_pro lp=new list_pro();
		list_proDAO.insertlist_pro(lp);
		list_proDAO.updatelist_pro(lp);
		list_proDAO.getlist_pro(null);
		list_proDAO.getlist_proByC("");
		list_proDAO.deletelist_pro(null);
	   
	    
	   
	}

}
