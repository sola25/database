package type;

public class test {

	public static void main(String[] args) {
		TypeDAO typeDAO=DAOFactory.getInstance().getTypeDAO();
		Type type=new Type();
		type.setTypeId("123");
		type.setTypeName("�·�");
		typeDAO.insertType(type);
		typeDAO.updateType(type);
		typeDAO.getType(null);
		typeDAO.getTypeByC("");
		typeDAO.deleteType(null);
	    
	   
	}

}
