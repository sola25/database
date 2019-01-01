package user;
import java.util.List;

import user.User;
public interface UserDAO {
	public void insertUser(User user);//�������루��������
	public void updateUser(User user);//�������£��ģ�����
	public void deleteUser(String sid);//����ɾ������
	public User getUser(String sid);//������ѯһ���û���Ϣ�ķ���
	public List<User> getUserByC(String sql);// ������ѯ����û���Ϣ�ķ���
}
