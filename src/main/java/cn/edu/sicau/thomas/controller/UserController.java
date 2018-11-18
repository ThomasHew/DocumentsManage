/**
 * 
 */
package cn.edu.sicau.thomas.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import cn.edu.sicau.thomas.pojo.FileInfor;
import cn.edu.sicau.thomas.pojo.User;
import cn.edu.sicau.thomas.service.FilesService;
import cn.edu.sicau.thomas.service.UserService;

/**
 * @author Thomas
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	} // 登录

	@RequestMapping("login")
	public String login(String autologin, String userName, String password, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		User user = userService.findUserByNameAndPassword(userName, password);
		if (user != null) {
			// 如果auto的值不为空，即选择了自动登录
			if (autologin != null) {

				int time = 60 * 60;
				// 保存在cookie中(user == password)
				Cookie cookie = new Cookie("user", user.getUserName() + "==" + user.getPassword());
				// 设置cookie存活时间
				cookie.setMaxAge(time);
				// 添加到cookie中
				response.addCookie(cookie);

			}
			// 将登录信息放到Seesion中
			request.getSession().setAttribute("user", user);
			return "index";
		} else

		{
			String msg = "用户名或密码错误，请重新输入！";
			request.setAttribute("msg", msg);
			return "login";
		}

	}

	// 自动登录
	@RequestMapping("index")
	public String success(HttpServletRequest request, HttpServletResponse response) {
		// 获取cookie
		Cookie[] cookie = request.getCookies();
		String[] cookies = null;
		if (cookie != null) {
			for (int i = 0; i < cookie.length; i++) {
				Cookie c = cookie[i];
				String usercookie = c.getValue();
				// 将获取的cookie按“==”分割
				cookies = usercookie.split("==");
				if (cookies.length == 2) {
					String userName = cookies[0];
					String password = cookies[1];

					// 实现自动登录
					User user2 = userService.findUserByNameAndPassword(userName, password);
					if (user2 != null) {
						// 将user信息保存到Session中
						request.getSession().setAttribute("user", user2);
						return "forward:index";
					}
				}

			}
		}
		return "redirect:toLogin.do";

	}
	//退出登录
	@RequestMapping("loginout")
	public String loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:toLogin.do";
	}

	// 注册
	@RequestMapping("/toregister")
	public String toregister() {
		return "register";
	}

	@RequestMapping("/register")
	public String register(User user) {

		Integer i = userService.insertUser(user);
		if (i != null) {
			return "registerSuccess"; // 注册成功，跳转到注册成功页面

		}
		return "null";

	}

	// 注册账户时对账户名是否已被注册进行校验
	@RequestMapping("queryByUser")
	public @ResponseBody User queryByUser(String userName) {

		return userService.getUserByUserName(userName);

	}
	//获得小组名称
	
	@RequestMapping("toindex")
	public String toindex() {
		return "index";
	}

	//文件上传页面
	@RequestMapping("upload_file")
	public String lay2(HttpServletRequest request) {
	
		return "upload_file";
	}
	
}
