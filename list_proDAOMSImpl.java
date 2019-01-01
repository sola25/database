package list_pro;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class list_proDAOMSImpl extends DAOBase implements list_proDAO {//�̳�DAOBase���ӻ��࣬ʵ��ProdutDAO�ӿ��������ķ���
			@SuppressWarnings("resource")
			public static void Input(list_pro lp) throws IOException{
//�˷�������������Ʒ��Ϣ
				Scanner ReadStr=new Scanner(System.in);
				
				System.out.println("������һ����Ʒ��������Ϣ��");
				System.out.println("��ƷID��");		 
		 		lp.setProId(ReadStr.nextLine());
		 		System.out.println("����ID��");		 
		 		lp.setOrdId(ReadStr.nextLine());
		 		
		 		
			}
			private static final String CREATE_LIST_PRO_SQL ="INSERT INTO list_product values(?,?)";
			@Override
			public void insertlist_pro(list_pro lp) {//ʵ�ֲ��뷽��������
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//�������ݿ�
					Input(lp);//������Ʒ��Ϣ
					pst = conn.prepareStatement(CREATE_LIST_PRO_SQL);
					pst.setString(1,lp.getProId());
					pst.setString(2, lp.getOrdId());

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
			public void updatelist_pro(list_pro lp) {//ʵ�ָ��£��ģ�����
				//��ɾ�����ٲ��룻
				// TODO Auto-generated method stub
				try{
					Connection conn = null;
					Statement stmt = null;
					int rs ;
					try {
						conn = getConnection();//�������ݿ�
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("������Ҫ������Ʒ��ID��");	 
						stmt = conn.createStatement();
						String sql = "delete from list_product where product_id=";
//ɾ��������Ʒ��Ϣ
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//���ؽ��
						insertlist_pro(lp);//�����µ���Ʒ��Ϣ
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
			public void deletelist_pro(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ����Ʒ��ID��");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from list_product where product_id=";
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
			private static final String SEARCH_LIST_PROC1 = "SELECT product_id,order_id FROM list_product WHERE product_id=";
			@Override
			public list_pro getlist_pro(String sid) {//ʵ�ֲ�ѯһ����Ʒ��Ϣ�ķ���
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				list_pro lp = new list_pro();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ��ƷID��");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_LIST_PROC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						lp.setProId(rs.getString("product_id"));
						lp.setOrdId(rs.getString("order_id"));
						
						
						System.out.println(lp.getProId()+" "+lp.getOrdId());
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
			private static final String SEARCH_PRODUCTTC = "SELECT product_id,order_id FROM list_product";
			@Override
			public List<list_pro> getlist_proByC(String sql) {
//ʵ�ֲ�ѯ�����Ʒ��Ϣ�ķ���
				List<list_pro> list_pros = new ArrayList<list_pro>();
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					conn = getConnection();
					stmt = conn.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_PRODUCTTC;
					}else{
						endsql = SEARCH_PRODUCTTC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						list_pro lp = new list_pro();
						lp.setProId(rs.getString("product_id"));
						lp.setOrdId(rs.getString("order_id"));
						
							
					}
					for(int i=0;i<list_pros.size();i++){
						list_pro s = new list_pro();
				 		s=list_pros.get(i);
				 		System.out.println(s.getProId()+"  "+s.getOrdId());
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
				return list_pros;
			}
}
