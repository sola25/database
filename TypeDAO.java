package type;

import java.util.List;

import type.Type;
public interface TypeDAO{
			public void insertType(Type typ);//声明插入（增）方法
			public void updateType(Type typ);//声明更新（改）方法
			public void deleteType(String sid);//声明删除方法
			public Type getType(String sid);//声明查询一个商品类型信息的方法
			public List<Type> getTypeByC(String sql);// 声明查询多个商品类型信息的方法
}


