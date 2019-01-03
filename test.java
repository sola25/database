package type;
import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		TypeDAO typeDAO=DAOFactory.getInstance().getTypeDAO();
		Type type=new Type();
		type.setTypeId("123");
		type.setTypeName("ÒÂ·þ");
		typeDAO.insertType(type);
		typeDAO.updateType(type);
		typeDAO.getType(null);
		typeDAO.getTypeByC(null);
		typeDAO.deleteType(null);
	    
	   
	}

}
