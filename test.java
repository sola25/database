package test;
import pro.*;


import java.util.Scanner;

import express.*;
import list.*;
import type.*;
import user.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDAO productDAO=DAOFactory.getInstance().getProductDAO();
		TypeDAO typeDAO=DAOFactory.getInstance().getTypeDAO();
		UserDAO userDAO=DAOFactory.getInstance().getUserDAO();
		ExpressDAO expressDAO=DAOFactory.getInstance().getExpressDAO();
		OrderDAO orderDAO=DAOFactory.getInstance().getOrderDAO();
		Order order=new Order();
		Express express=new Express();
		Product product=new Product();
		Type type=new Type();
		User user=new User();
		System.out.println("请输入数字选择需要查询的表：");
		System.out.println("1表示用户信息，2表示产品信息，3表示快递信息，4表示产品类型信息，5表示订单信息");
        Scanner read=new Scanner(System.in);
        int i=read.nextInt();
        switch (i) {
		case 1:
			System.out.println("用户信息加载中......");
			System.out.println("请输入要修改的项目:");
			System.out.println("1表示增加数据，2表示修改数据，3表示删除数据，4表示查询数据");
			Scanner read1=new Scanner(System.in);
			int q1=read1.nextInt();
			switch (q1) {
			case 1:
				userDAO.insertUser(user);
				break;
			case 2:
				userDAO.updateUser(user);
				break;
			case 3:
				userDAO.deleteUser(null);
				break;
			case 4:
				userDAO.getUser(null);
				userDAO.getUserByC("");
				break;
			default:
				System.out.println("请检查输入格式!");
				break;
			}
		case 2:
			System.out.println("产品信息加载中......");
			System.out.println("请输入要修改的项目:");
			System.out.println("1表示增加数据，2表示修改数据，3表示删除数据，4表示查询数据");
			Scanner read2=new Scanner(System.in);
			int q2=read2.nextInt();
			switch (q2) {
			case 1:
				 productDAO.insertProduct(product);
				break;
			case 2:
				 productDAO.updateProduct(product);
                break;
			case 3:
				productDAO.deleteProduct(null);
				break;
			case 4:
			    productDAO.getProduct(null);
		        productDAO.getProductByC("");
		     break;
			default:
				System.out.println("请检查输入格式!");
				break;
			}
		case 3:
			System.out.println("快递信息加载中......");
			System.out.println("请输入要修改的项目:");
			System.out.println("1表示增加数据，2表示修改数据，3表示删除数据，4表示查询数据");
			Scanner read3=new Scanner(System.in);
			int q3=read3.nextInt();
			switch (q3) {
			case 1:
				expressDAO.insertExpress(express);
				break;
			case 2:
				 expressDAO.updateExpress(express);
				 break;
			case 3:
				expressDAO.deleteExpress(null);
			     break;
			case 4:
				 expressDAO.getExpress(null);
			     expressDAO.getExpressByC("");
			default:
				System.out.println("请检查输入格式!");
				break;
			}
		case 4:
			System.out.println("产品类型信息加载中......");
			System.out.println("请输入要修改的项目:");
			System.out.println("1表示增加数据，2表示修改数据，3表示删除数据，4表示查询数据");
			Scanner read4=new Scanner(System.in);
			int q4=read4.nextInt();
			switch (q4) {
			case 1:
				typeDAO.insertType(type);
				break;
			case 2:
				typeDAO.updateType(type);
				break;
			case 3:
				typeDAO.deleteType(null);
				break;
			case 4:
				typeDAO.getType(null);
				typeDAO.getTypeByC(null);
				break;
			default:
				System.out.println("请检查输入格式!");
				break;
			}
		case 5:
			System.out.println("订单信息加载中......");
			System.out.println("请输入要修改的项目:");
			System.out.println("1表示增加数据，2表示修改数据，3表示删除数据，4表示查询数据");
			Scanner read5=new Scanner(System.in);
			int q5=read5.nextInt();
			switch (q5) {
			case 1:
				orderDAO.insertOrder(order);
				break;
			case 2:
				 orderDAO.updateOrder(order);
				 break;
			case 3:
				 orderDAO.deleteOrder(null);
				 break;
			case 4:
				orderDAO.getOrder(null);
		        orderDAO.getOrderByC("");
		        break;
			default:
				System.out.println("请检查输入格式!");
				break;
			}
			break;

		default:
			System.out.println("请检查输入格式!");
			break;
		}
	}

}
