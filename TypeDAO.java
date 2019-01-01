package type;

import java.util.List;

import type.Type;
public interface TypeDAO{
			public void insertType(Type typ);//�������루��������
			public void updateType(Type typ);//�������£��ģ�����
			public void deleteType(String sid);//����ɾ������
			public Type getType(String sid);//������ѯһ����Ʒ������Ϣ�ķ���
			public List<Type> getTypeByC(String sql);// ������ѯ�����Ʒ������Ϣ�ķ���
}


