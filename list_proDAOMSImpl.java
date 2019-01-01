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

public class list_proDAOMSImpl extends DAOBase implements list_proDAO {//继承DAOBase连接基类，实现ProdutDAO接口中声明的方法
			@SuppressWarnings("resource")
			public static void Input(list_pro lp) throws IOException{
//此方法用于输入商品信息
				Scanner ReadStr=new Scanner(System.in);
				
				System.out.println("请输入一个商品订单的信息：");
				System.out.println("商品ID：");		 
		 		lp.setProId(ReadStr.nextLine());
		 		System.out.println("订单ID：");		 
		 		lp.setOrdId(ReadStr.nextLine());
		 		
		 		
			}
			private static final String CREATE_LIST_PRO_SQL ="INSERT INTO list_product values(?,?)";
			@Override
			public void insertlist_pro(list_pro lp) {//实现插入方法（增）
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//连接数据库
					Input(lp);//输入商品信息
					pst = conn.prepareStatement(CREATE_LIST_PRO_SQL);
					pst.setString(1,lp.getProId());
					pst.setString(2, lp.getOrdId());

					int row=pst.executeUpdate();
					System.out.println("成功更新了"+row+"行数据!");
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
			public void updatelist_pro(list_pro lp) {//实现更新（改）方法
				//先删除，再插入；
				// TODO Auto-generated method stub
				try{
					Connection conn = null;
					Statement stmt = null;
					int rs ;
					try {
						conn = getConnection();//连接数据库
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("请输入要更新商品的ID：");	 
						stmt = conn.createStatement();
						String sql = "delete from list_product where product_id=";
//删除已有商品信息
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//返回结果
						insertlist_pro(lp);//插入新的商品信息
						//显式释放资源
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
			public void deletelist_pro(String sid) {//实现删除方法
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//连接数据库
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要删除商品的ID：");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from list_product where product_id=";
					rs = stmt.executeUpdate(sql+Integer.parseInt(sid));//返回结果
					System.out.println("成功删除了"+rs+"行数据!");
					//显式释放资源
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
			public list_pro getlist_pro(String sid) {//实现查询一个商品信息的方法
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				list_pro lp = new list_pro();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要查询商品ID：");		 
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
//实现查询多个商品信息的方法
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
