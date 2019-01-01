package list;

import java.util.List;
public interface OrderDAO{
			public void insertOrder(Order list);//声明插入（增）方法
			public void updateOrder(Order list);//声明更新（改）方法
			public void deleteOrder(String sid);//声明删除方法
			public Order getOrder(String sid);//声明查询一个商品信息的方法
			public List<Order> getOrderByC(String sql);// 声明查询多个商品信息的方法
}


