package express;

import java.util.List;
public interface ExpressDAO{
			public void insertExpress(Express exp);//�������루��������
			public void updateExpress(Express exp);//�������£��ģ�����
			public void deleteExpress(String sid);//����ɾ������
			public Express getExpress(String sid);//������ѯһ����Ʒ��Ϣ�ķ���
			public List<Express> getExpressByC(String sql);// ������ѯ�����Ʒ��Ϣ�ķ���
}


