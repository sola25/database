package express;

import java.util.List;
public interface ExpressDAO{
			public void insertExpress(Express exp);//声明插入（增）方法
			public void updateExpress(Express exp);//声明更新（改）方法
			public void deleteExpress(String sid);//声明删除方法
			public Express getExpress(String sid);//声明查询一个商品信息的方法
			public List<Express> getExpressByC(String sql);// 声明查询多个商品信息的方法
}


