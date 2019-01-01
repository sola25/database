package list_pro;

import java.util.List;
public interface list_proDAO{
			public void insertlist_pro(list_pro pro);//声明插入（增）方法
			public void updatelist_pro(list_pro pro);//声明更新（改）方法
			public void deletelist_pro(String sid);//声明删除方法
			public list_pro getlist_pro(String sid);//声明查询一个商品信息的方法
			public List<list_pro> getlist_proByC(String sql);// 声明查询多个商品信息的方法
}


