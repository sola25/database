package list_pro;

import java.util.List;
public interface list_proDAO{
			public void insertlist_pro(list_pro pro);//�������루��������
			public void updatelist_pro(list_pro pro);//�������£��ģ�����
			public void deletelist_pro(String sid);//����ɾ������
			public list_pro getlist_pro(String sid);//������ѯһ����Ʒ��Ϣ�ķ���
			public List<list_pro> getlist_proByC(String sql);// ������ѯ�����Ʒ��Ϣ�ķ���
}


