/**
 * 
 */
package cn.edu.sicau.thomas.service;

import java.util.List;

import cn.edu.sicau.thomas.pojo.User;

/**
 * @author lenovo
 *
 */
public interface UserService {
	// ��¼����
	User findUserByNameAndPassword(String userName, String password);

	// ע�����
	int insertUser(User user);

	// �����û�����ѯ
	User getUserByUserName(String userName);
	
	
}
