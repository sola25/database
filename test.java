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
		System.out.println("����������ѡ����Ҫ��ѯ�ı�");
		System.out.println("1��ʾ�û���Ϣ��2��ʾ��Ʒ��Ϣ��3��ʾ�����Ϣ��4��ʾ��Ʒ������Ϣ��5��ʾ������Ϣ");
        Scanner read=new Scanner(System.in);
        int i=read.nextInt();
        switch (i) {
		case 1:
			System.out.println("�û���Ϣ������......");
			System.out.println("������Ҫ�޸ĵ���Ŀ:");
			System.out.println("1��ʾ�������ݣ�2��ʾ�޸����ݣ�3��ʾɾ�����ݣ�4��ʾ��ѯ����");
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
				System.out.println("���������ʽ!");
				break;
			}
		case 2:
			System.out.println("��Ʒ��Ϣ������......");
			System.out.println("������Ҫ�޸ĵ���Ŀ:");
			System.out.println("1��ʾ�������ݣ�2��ʾ�޸����ݣ�3��ʾɾ�����ݣ�4��ʾ��ѯ����");
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
				System.out.println("���������ʽ!");
				break;
			}
		case 3:
			System.out.println("�����Ϣ������......");
			System.out.println("������Ҫ�޸ĵ���Ŀ:");
			System.out.println("1��ʾ�������ݣ�2��ʾ�޸����ݣ�3��ʾɾ�����ݣ�4��ʾ��ѯ����");
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
				System.out.println("���������ʽ!");
				break;
			}
		case 4:
			System.out.println("��Ʒ������Ϣ������......");
			System.out.println("������Ҫ�޸ĵ���Ŀ:");
			System.out.println("1��ʾ�������ݣ�2��ʾ�޸����ݣ�3��ʾɾ�����ݣ�4��ʾ��ѯ����");
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
				System.out.println("���������ʽ!");
				break;
			}
		case 5:
			System.out.println("������Ϣ������......");
			System.out.println("������Ҫ�޸ĵ���Ŀ:");
			System.out.println("1��ʾ�������ݣ�2��ʾ�޸����ݣ�3��ʾɾ�����ݣ�4��ʾ��ѯ����");
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
				System.out.println("���������ʽ!");
				break;
			}
			break;

		default:
			System.out.println("���������ʽ!");
			break;
		}
	}

}
