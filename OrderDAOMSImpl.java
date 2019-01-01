package list;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDAOMSImpl extends DAOBase implements OrderDAO {//�̳�DAOBase���ӻ��࣬ʵ��ProdutDAO�ӿ��������ķ���
			@SuppressWarnings("resource")
			public static void Input(Order order) throws IOException{
//�˷�������������Ʒ��Ϣ
				Scanner ReadStr=new Scanner(System.in);
				Scanner ReadFlo=new Scanner(System.in);
				Scanner ReadInt=new Scanner(System.in);
				System.out.println("������һ����������Ϣ��");
				System.out.println("����ID��");		 
		 		order.setOrderId(ReadStr.nextLine());
		 		System.out.println("�û�ID��");		 
		 		order.setUserId(ReadStr.nextLine());
		 		System.out.println("��ݵ�ID��");		 
		 		order.setExpId(ReadStr.nextLine());
		 		System.out.println("����ʱ�䣺");		 
		 		order.setTime(ReadStr.nextLine());
		 		System.out.println("�����۸�");		 
		 		order.setMoney(ReadFlo.nextFloat());
		 		System.out.println("����״̬��");		 
		 		order.setState(ReadStr.nextLine());
		 		System.out.println("�������������");	
		 		order.setBuyName(ReadStr.nextLine());
		 		System.out.println("��������������");	
		 		order.setSelName(ReadStr.nextLine());
		 		System.out.println("������Ʒ����");	
		 		order.setProName(ReadStr.nextLine());
		 		System.out.println("������Ʒ������");	
		 		order.setProNum(ReadInt.nextInt());

			}
			private static final String CREATE_PRODUCT_SQL ="INSERT INTO list values(?,?,?,?,?,?,?,?,?,?)";
			@Override
			public void insertOrder(Order order) {//ʵ�ֲ��뷽��������
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//�������ݿ�
					Input(order);//��������Ϣ
					pst = conn.prepareStatement(CREATE_PRODUCT_SQL);
					pst.setString(1,order.getOrderId());
					pst.setString(2,order.getUserId());
					pst.setString(3,order.getExpId());
					pst.setString(4,order.getTime());
					pst.setFloat(5,order.getMoney());
					pst.setString(6,order.getState());
					pst.setString(7,order.getBuyName());
					pst.setString(8,order.getSelName());
					pst.setString(9,order.getProName());
					pst.setInt(10,order.getProNum());

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
			public void updateOrder(Order ord) {//ʵ�ָ��£��ģ�����
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
						String sql = "delete from list where order_id=";
//ɾ��������Ʒ��Ϣ
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//���ؽ��
						insertOrder(ord);//�����µ���Ʒ��Ϣ
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
			public void deleteOrder(String sid) {//ʵ��ɾ������
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
					String sql = "delete from list where order_id=";
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
			private static final String SEARCH_PRODUCTC1 = "SELECT order_id,user_id,express_id,order_time,order_money,order_state,order_buyername,order_sellername,order_productname,order_productnumber FROM list WHERE order_id=";
			@Override
			public Order getOrder(String sid) {//ʵ�ֲ�ѯһ����Ʒ��Ϣ�ķ���
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				Order order = new Order();
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
						order.setOrderId(rs.getString("order_id"));
						order.setUserId(rs.getString("user_id"));
						order.setExpId(rs.getString("express_id"));
						order.setTime(rs.getString("order_time"));
						order.setMoney(rs.getFloat("order_money"));
						order.setState(rs.getString("order_state"));
						order.setBuyName(rs.getString("order_buyername"));
						order.setSelName(rs.getString("order_sellername"));
						order.setProName(rs.getString("order_productname"));
						order.setProNum(rs.getInt("order_productnmber"));
						
						
						System.out.println(order.getOrderId()+""+order.getUserId()+""+order.getExpId()+""+order.getTime()+""+order.getMoney()+""+order.getState()+""+order.getBuyName()+""+order.getSelName()+""+order.getProName()+""+order.getProNum());
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
			private static final String SEARCH_PRODUCTTC = "SELECT order_id,user_id,express_id,order_time,order_money,order_state,order_buyername,order_sellername,order_productname,order_productnumber FROM product";
			@Override
			public List<Order> getOrderByC(String sql) {
//ʵ�ֲ�ѯ�����Ʒ��Ϣ�ķ���
				List<Order> orders = new ArrayList<Order>();
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
						Order order = new Order();
						order.setOrderId(rs.getString("order_id"));
						order.setUserId(rs.getString("user_id"));
						order.setExpId(rs.getString("express_id"));
						order.setTime(rs.getString("order_time"));
						order.setMoney(rs.getFloat("order_money"));
						order.setState(rs.getString("order_state"));
						order.setBuyName(rs.getString("order_buyername"));
						order.setSelName(rs.getString("order_sellername"));
						order.setProName(rs.getString("order_productname"));
						order.setProNum(rs.getInt("order_productnmber"));
							orders.add(order);
					}
					for(int i=0;i<orders.size();i++){
				 		Order s = new Order();
				 		s=orders.get(i);
				 		System.out.println(s.getOrderId()+""+s.getUserId()+""+s.getExpId()+""+s.getTime()+""+s.getMoney()+""+s.getState()+""+s.getBuyName()+""+s.getSelName()+""+s.getProName()+""+s.getProNum());
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
				return orders;
			}
}
