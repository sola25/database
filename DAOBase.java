package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOBase implements DAO {//ʵ��DAO�ӿ��е����ӷ���
			@Override
			public Connection getConnection() {//ʵ������
				Connection conn = null;		
				try {
					//����JDBC����
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					//���ӷ����������ݿ�sample
					String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=JD";
//����url=���ݿ����ϵͳ�ı�ʶ+���ݿ����ϵͳ�ĵ�ַ��ip+�˿ڣ�+ʹ�õ����ݿ�ʵ������
					String userName = "s"; //Ĭ���û���
					String userPwd = "123"; //����
					try{
						Class.forName(driverName);//��������
					}catch (ClassNotFoundException e) {
					System.out.println("�޷��ҵ�������!");
					e.printStackTrace();
					}
					//��������
					conn = DriverManager.getConnection(dbURL,userName,userPwd);
					System.out.println("Connection Successful!"); //������ӳɹ� ����̨���
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
			}
}

