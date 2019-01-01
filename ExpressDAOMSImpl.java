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

public class ExpressDAOMSImpl extends DAOBase implements ExpressDAO {//继承DAOBase连接基类，实现ProdutDAO接口中声明的方法
			@SuppressWarnings("resource")
			public static void Input(Express exp) throws IOException{
//此方法用于输入商品信息
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("请输入一个快递单的信息：");
				System.out.println("快递单ID：");		 
		 		exp.setExpId(ReadStr.nextLine());
		 		System.out.println("订单ID：");		 
		 		exp.setOrdId(ReadStr.nextLine());
		 		System.out.println("订单信息：");		 
		 		exp.setExpInf(ReadStr.nextLine());
		 		System.out.println("快递员ID：");		 
		 		exp.setExpCourId(ReadStr.nextLine());
		 		System.out.println("快递员姓名：");		 
		 		exp.setExpCourName(ReadStr.nextLine());
		 		System.out.println("快递员电话：");		 
		 		exp.setExpCourId(ReadStr.nextLine());
		 		
		 		
		 		
			}
			private static final String CREATE_PRODUCT_SQL ="INSERT INTO express values(?,?,?,?,?,?)";
			@Override
			public void insertExpress(Express exp) {//实现插入方法（增）
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//连接数据库
					Input(exp);//输入快递信息
					pst = conn.prepareStatement(CREATE_PRODUCT_SQL);
					pst.setString(1,exp.getExpId());
					pst.setString(2,exp.getOrdId());
					pst.setString(3,exp.getExpInf());
					pst.setString(4,exp.getExpCourId());
					pst.setString(5,exp.getExpCourName());
					pst.setString(6,exp.getExpCourTele());
					
					
					
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
			public void updateExpress(Express exp) {//实现更新（改）方法
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
						String sql = "delete from express where express_id=";
//删除已有商品信息
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//返回结果
						insertExpress(exp);//插入新的商品信息
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
			public void deleteExpress(String sid) {//实现删除方法
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//连接数据库
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要删除快递的ID：");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from express where express_id=";
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
			private static final String SEARCH_PRODUCTC1 = "SELECT express_id,order_id,express_infomation,express_courierid,express_couriername,express_couriertelephone  FROM express WHERE express_id=";
			@Override
			public Express getExpress(String sid) {//实现查询一个商品信息的方法
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				Express exp = new Express();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要查询快递ID：");		 
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
//实现查询多个商品信息的方法
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
