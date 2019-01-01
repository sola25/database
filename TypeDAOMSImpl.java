package type;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypeDAOMSImpl extends DAOBase implements TypeDAO {//�̳�DAOBase���ӻ��࣬ʵ��TypeDAO�ӿ��������ķ���
			@SuppressWarnings("resource")
			public static void Input(Type typ) throws IOException{
//�˷�������������Ʒ������Ϣ
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("������һ����Ʒ���͵���Ϣ��");
				System.out.println("����ID��");		 
		 		typ.setTypeId(ReadStr.nextLine());
		 		System.out.println("��������");
		 		typ.setTypeName(ReadStr.nextLine());
		 		
		 		
		 		
			}
			private static final String CREATE_TYPE_SQL ="INSERT INTO type values(?,?)";
			@Override
			public void insertType(Type typ) {//ʵ�ֲ��뷽��������
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//�������ݿ�
					Input(typ);//������Ʒ��Ϣ
					pst = conn.prepareStatement(CREATE_TYPE_SQL);
					pst.setString(1,typ.getTypeId());
					pst.setString(2, typ.getTypeName());
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
			public void updateType(Type typ) {//ʵ�ָ��£��ģ�����
				//��ɾ�����ٲ��룻
				// TODO Auto-generated method stub
				try{
					Connection conn = null;
					Statement stmt = null;
					int rs ;
					try {
						conn = getConnection();//�������ݿ�
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("������Ҫ�������͵�ID��");	 
						stmt = conn.createStatement();
						String sql = "delete from type where type_id=";
//ɾ��������Ʒ������Ϣ
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//���ؽ��
						insertType(typ);//�����µ���Ʒ��Ϣ
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
			public void deleteType(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ����Ʒ���͵�ID��");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from type where type_id=";
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
			private static final String SEARCH_TYPEC1 = "SELECT type_id,type_name FROM type WHERE type_id=";
			@Override
			public Type getType(String sid) {//ʵ�ֲ�ѯһ����Ʒ������Ϣ�ķ���
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				Type typ = new Type();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ��Ʒ����ID��");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_TYPEC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						typ.setTypeId(rs.getString("type_id"));
						typ.setTypeName(rs.getString("type_name"));
						
						System.out.println(typ.getTypeId()+""+typ.getTypeName());
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
			private static final String SEARCH_TYPETC = "SELECT type_id,type_name FROM type";
			@Override
			public List<Type> getTypeByC(String sql) {
//ʵ�ֲ�ѯ�����Ʒ��Ϣ�ķ���
				List<Type> types = new ArrayList<Type>();
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					conn = getConnection();
					stmt = conn.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_TYPETC;
					}else{
						endsql = SEARCH_TYPETC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						Type typ = new Type();
						typ.setTypeId(rs.getString("type_id"));
						typ.setTypeName(rs.getString("type_name"));

					}
					for(int i=0;i<types.size();i++){
						Type s = new Type();
				 		s=types.get(i);
				 		System.out.println(s.getTypeId()+"  "+s.getTypeName());
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
				return types;
			}
}
