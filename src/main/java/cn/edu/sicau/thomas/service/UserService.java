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
	// 登录操作
	User findUserByNameAndPassword(String userName, String password);

	// 注册操作
	int insertUser(User user);

	// 根据用户名查询
	User getUserByUserName(String userName);
	
	
}
