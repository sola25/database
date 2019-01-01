package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAOMSImpl extends DAOBase implements UserDAO {//�̳�DAOBase���ӻ��࣬ʵ��UserDAO�ӿ��������ķ���
			@SuppressWarnings("resource")
			public static void Input(User user) throws IOException{
//�˷������������û�������Ϣ
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("������һ���û�����Ϣ��");
				System.out.println("�û�ID��");		 
		 		user.setUserId(ReadStr.nextLine());
		 		System.out.println("�û�����");
		 		user.setUserName(ReadStr.nextLine());
		 		System.out.println("�û����䣺");
		 		user.setUserAge(ReadStr.nextLine());
		 		System.out.println("�û��Ա�");
		 		user.setUserSex(ReadStr.nextLine());
		 		System.out.println("�û��绰��");
		 		user.setUserTele(ReadStr.nextLine());
		 		System.out.println("�û���ַ��");
		 		user.setUserAdd(ReadStr.nextLine());
		 		System.out.println("�û����룺");
		 		user.setUserpass(ReadStr.nextLine());
		 		
		 		
		 		
			}
			private static final String CREATE_USER_SQL ="INSERT INTO buyer values(?,?,?,?,?,?,?)";
			@Override
			public void insertUser(User user) {//ʵ�ֲ��뷽��������
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//�������ݿ�
					Input(user);//�����û���Ϣ
					pst = conn.prepareStatement(CREATE_USER_SQL);
					pst.setString(1,user.getUserId());
					pst.setString(2, user.getUserName());
					pst.setString(3, user.getUserAge());
					pst.setString(4, user.getUserSex());
					pst.setString(5, user.getUserTele());
					pst.setString(6, user.getUserAdd());
					pst.setString(7, user.getUserpass());
					
					int row=pst.executeUpdate();
					System.out.println("�ɹ�������"+row+"������!");
					pst.close();
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(pst!=null)
						try {
							pst.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			@Override
			public void updateUser(User user) {//ʵ�ָ��£��ģ�����
				//��ɾ�����ٲ��룻
				// TODO Auto-generated method stub
				try{
					Connection conn = null;
					Statement stmt = null;
					int rs ;
					try {
						conn = getConnection();//�������ݿ�
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("������Ҫ�����û���ID��");	 
						stmt = conn.createStatement();
						String sql = "delete from user where user_id=";
//ɾ�������û���Ϣ
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//���ؽ��
						insertUser(user);//�����µ���Ʒ��Ϣ
						//��ʽ�ͷ���Դ
						stmt.close();		
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(stmt!=null)
							try {
								stmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}catch(Exception e){
					e.printStackTrace();
				}			
			}
			@Override
			public void deleteUser(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ���û���ID��");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from user where user_id=";
					rs = stmt.executeUpdate(sql+Integer.parseInt(sid));//���ؽ��
					System.out.println("�ɹ�ɾ����"+rs+"������!");
					//��ʽ�ͷ���Դ
					stmt.close();		
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			private static final String SEARCH_USERC1 = "SELECT user_id,user_name,user_age,user_sex,user_telephone,user_address,user_password FROM user WHERE user_id=";
			@Override
			public User getUser(String sid) {//ʵ�ֲ�ѯһ����Ʒ������Ϣ�ķ���
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				User user = new User();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ�û�ID��");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_USERC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						user.setUserId(rs.getString("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setUserAge(rs.getString("user_age"));
						user.setUserSex(rs.getString("user_sex"));
						user.setUserTele(rs.getString("user_telephone"));
						user.setUserAdd(rs.getString("user_address"));
						user.setUserpass(rs.getString("user_password"));
						
						
						
						System.out.println(user.getUserId()+""+user.getUserName()+""+user.getUserAge()+""+user.getUserSex()+""+user.getUserTele()+""+user.getUserAdd()+""+user.getUserpass());
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(rs!=null)
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				return null;
			}
			private static final String SEARCH_USERTC = "SELECT user_id,user_name,user_age,user_sex,user_telephone,user_address,user_password FROM user ";
			@Override
			public List<User> getUserByC(String sql) {
//ʵ�ֲ�ѯ����û���Ϣ�ķ���
				List<User> users = new ArrayList<User>();
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					conn = getConnection();
					stmt = conn.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_USERTC;
					}else{
						endsql = SEARCH_USERTC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						User user = new User();
						user.setUserId(rs.getString("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setUserAge(rs.getString("user_age"));
						user.setUserSex(rs.getString("user_sex"));
						user.setUserTele(rs.getString("user_telephone"));
						user.setUserAdd(rs.getString("user_address"));
						user.setUserpass(rs.getString("user_password"));
					}
					for(int i=0;i<users.size();i++){
						User s = new User();
				 		s=users.get(i);
				 		System.out.println(s.getUserId()+""+s.getUserName()+""+s.getUserAge()+""+s.getUserSex()+""+s.getUserTele()+""+s.getUserAdd()+""+s.getUserpass());
					 }
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(rs!=null)
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				return users;
			}
}
