package express;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressDAOMSImpl extends DAOBase implements ExpressDAO {//�̳�DAOBase���ӻ��࣬ʵ��ProdutDAO�ӿ��������ķ���
			@SuppressWarnings("resource")
			public static void Input(Express exp) throws IOException{
//�˷�������������Ʒ��Ϣ
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("������һ����ݵ�����Ϣ��");
				System.out.println("��ݵ�ID��");		 
		 		exp.setExpId(ReadStr.nextLine());
		 		System.out.println("����ID��");		 
		 		exp.setOrdId(ReadStr.nextLine());
		 		System.out.println("������Ϣ��");		 
		 		exp.setExpInf(ReadStr.nextLine());
		 		System.out.println("���ԱID��");		 
		 		exp.setExpCourId(ReadStr.nextLine());
		 		System.out.println("���Ա������");		 
		 		exp.setExpCourName(ReadStr.nextLine());
		 		System.out.println("���Ա�绰��");		 
		 		exp.setExpCourId(ReadStr.nextLine());
		 		
		 		
		 		
			}
			private static final String CREATE_PRODUCT_SQL ="INSERT INTO express values(?,?,?,?,?,?)";
			@Override
			public void insertExpress(Express exp) {//ʵ�ֲ��뷽��������
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//�������ݿ�
					Input(exp);//��������Ϣ
					pst = conn.prepareStatement(CREATE_PRODUCT_SQL);
					pst.setString(1,exp.getExpId());
					pst.setString(2,exp.getOrdId());
					pst.setString(3,exp.getExpInf());
					pst.setString(4,exp.getExpCourId());
					pst.setString(5,exp.getExpCourName());
					pst.setString(6,exp.getExpCourTele());
					
					
					
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
			public void updateExpress(Express exp) {//ʵ�ָ��£��ģ�����
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
						String sql = "delete from express where express_id=";
//ɾ��������Ʒ��Ϣ
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//���ؽ��
						insertExpress(exp);//�����µ���Ʒ��Ϣ
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
			public void deleteExpress(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ����ݵ�ID��");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from express where express_id=";
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
			private static final String SEARCH_PRODUCTC1 = "SELECT express_id,order_id,express_infomation,express_courierid,express_couriername,express_couriertelephone  FROM express WHERE express_id=";
			@Override
			public Express getExpress(String sid) {//ʵ�ֲ�ѯһ����Ʒ��Ϣ�ķ���
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				Express exp = new Express();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ���ID��");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_PRODUCTC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){		
						exp.setExpId(rs.getString("express_id"));
						exp.setOrdId(rs.getString("order_id"));
						exp.setExpInf(rs.getString("express_infomation"));
						exp.setExpCourId(rs.getString("express_courierid"));
						exp.setExpCourName(rs.getString("express_couriername"));
						exp.setExpCourTele(rs.getString("express_couriertelephone"));
						
						
						System.out.println(exp.getExpId()+""+exp.getOrdId()+""+exp.getExpInf()+""+exp.getExpCourId()+""+exp.getExpCourName()+""+exp.getExpCourTele());
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
			private static final String SEARCH_PRODUCTTC = "SELECT express_id,order_id,express_infomation,express_courierid,express_couriername,express_couriertelephone FROM product";
			@Override
			public List<Express> getExpressByC(String sql) {
//ʵ�ֲ�ѯ�����Ʒ��Ϣ�ķ���
				List<Express> expresses = new ArrayList<Express>();
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
						Express exp = new Express();
						exp.setExpId(rs.getString("express_id"));
						exp.setOrdId(rs.getString("order_id"));
						exp.setExpInf(rs.getString("express_infomation"));
						exp.setExpCourId(rs.getString("express_courierid"));
						exp.setExpCourName(rs.getString("express_couriername"));
						exp.setExpCourTele(rs.getString("express_couriertelephone"));
						expresses.add(exp);
							
					}
					for(int i=0;i<expresses.size();i++){
				 		Express s = new Express();
				 		s=expresses.get(i);
				 		System.out.println(s.getExpId()+""+s.getOrdId()+""+s.getExpInf()+""+s.getExpCourId()+""+s.getExpCourName()+""+s.getExpCourTele());
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
				return expresses;
			}
}
