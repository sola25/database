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

public class TypeDAOMSImpl extends DAOBase implements TypeDAO {//继承DAOBase连接基类，实现TypeDAO接口中声明的方法
			@SuppressWarnings("resource")
			public static void Input(Type typ) throws IOException{
//此方法用于输入商品类型信息
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("请输入一个商品类型的信息：");
				System.out.println("类型ID：");		 
		 		typ.setTypeId(ReadStr.nextLine());
		 		System.out.println("类型名：");
		 		typ.setTypeName(ReadStr.nextLine());
		 		
		 		
		 		
			}
			private static final String CREATE_TYPE_SQL ="INSERT INTO type values(?,?)";
			@Override
			public void insertType(Type typ) {//实现插入方法（增）
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//连接数据库
					Input(typ);//输入商品信息
					pst = conn.prepareStatement(CREATE_TYPE_SQL);
					pst.setString(1,typ.getTypeId());
					pst.setString(2, typ.getTypeName());
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
			public void updateType(Type typ) {//实现更新（改）方法
				//先删除，再插入；
				// TODO Auto-generated method stub
				try{
					Connection conn = null;
					Statement stmt = null;
					int rs ;
					try {
						conn = getConnection();//连接数据库
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("请输入要更新类型的ID：");	 
						stmt = conn.createStatement();
						String sql = "delete from type where type_id=";
//删除已有商品类型信息
						rs = stmt.executeUpdate(sql+ReadStr.nextLine());
//返回结果
						insertType(typ);//插入新的商品信息
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
			public void deleteType(String sid) {//实现删除方法
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//连接数据库
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要删除商品类型的ID：");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from type where type_id=";
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
			private static final String SEARCH_TYPEC1 = "SELECT type_id,type_name FROM type WHERE type_id=";
			@Override
			public Type getType(String sid) {//实现查询一个商品类型信息的方法
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				Type typ = new Type();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要查询商品类型ID：");		 
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
//实现查询多个商品信息的方法
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
