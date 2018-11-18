/**
 * 
 */
package cn.edu.sicau.thomas.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sicau.thomas.mapper.UserMapper;
import cn.edu.sicau.thomas.pojo.User;
import cn.edu.sicau.thomas.service.UserService;

/**
 * @author lenovo
 *
 */
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserMapper userMapper;
	//��½ʱȷ����Ϣ
	public User findUserByNameAndPassword(String userName, String password) {

		return userMapper.findUserByNameAndPassword(userName, password);
	}

	
	//ע��
	public int insertUser(User user) {
		System.out.println(user);
		return userMapper.insertUser(user);
	}

	//ע��ʱ�û���У��
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);

	}


	
}
