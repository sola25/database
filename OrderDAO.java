package list;

import java.util.List;
public interface OrderDAO{
			public void insertOrder(Order list);//�������루��������
			public void updateOrder(Order list);//�������£��ģ�����
			public void deleteOrder(String sid);//����ɾ������
			public Order getOrder(String sid);//������ѯһ����Ʒ��Ϣ�ķ���
			public List<Order> getOrderByC(String sql);// ������ѯ�����Ʒ��Ϣ�ķ���
}


