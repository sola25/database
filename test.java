package user;



public class test {

	public static void main(String[] args) {
		UserDAO userDAO=DAOFactory.getInstance().getUserDAO();
		User user=new User();
		user.setUserId("110");
		user.setUserName("����");
		user.setUserAge("12");
		user.setUserSex("��");
		user.setUserTele("110");
		user.setUserAdd("������");
		user.setUserpass("55942");
		userDAO.insertUser(user);
		userDAO.updateUser(user);
		userDAO.getUser(null);
		userDAO.getUserByC("");
		userDAO.deleteUser(null);
	}

}
