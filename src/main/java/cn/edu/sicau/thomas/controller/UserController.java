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
	} // ��¼

	@RequestMapping("login")
	public String login(String autologin, String userName, String password, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		User user = userService.findUserByNameAndPassword(userName, password);
		if (user != null) {
			// ���auto��ֵ��Ϊ�գ���ѡ�����Զ���¼
			if (autologin != null) {

				int time = 60 * 60;
				// ������cookie��(user == password)
				Cookie cookie = new Cookie("user", user.getUserName() + "==" + user.getPassword());
				// ����cookie���ʱ��
				cookie.setMaxAge(time);
				// ��ӵ�cookie��
				response.addCookie(cookie);

			}
			// ����¼��Ϣ�ŵ�Seesion��
			request.getSession().setAttribute("user", user);
			return "index";
		} else

		{
			String msg = "�û���������������������룡";
			request.setAttribute("msg", msg);
			return "login";
		}

	}

	// �Զ���¼
	@RequestMapping("index")
	public String success(HttpServletRequest request, HttpServletResponse response) {
		// ��ȡcookie
		Cookie[] cookie = request.getCookies();
		String[] cookies = null;
		if (cookie != null) {
			for (int i = 0; i < cookie.length; i++) {
				Cookie c = cookie[i];
				String usercookie = c.getValue();
				// ����ȡ��cookie����==���ָ�
				cookies = usercookie.split("==");
				if (cookies.length == 2) {
					String userName = cookies[0];
					String password = cookies[1];

					// ʵ���Զ���¼
					User user2 = userService.findUserByNameAndPassword(userName, password);
					if (user2 != null) {
						// ��user��Ϣ���浽Session��
						request.getSession().setAttribute("user", user2);
						return "forward:index";
					}
				}

			}
		}
		return "redirect:toLogin.do";

	}
	//�˳���¼
	@RequestMapping("loginout")
	public String loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:toLogin.do";
	}

	// ע��
	@RequestMapping("/toregister")
	public String toregister() {
		return "register";
	}

	@RequestMapping("/register")
	public String register(User user) {

		Integer i = userService.insertUser(user);
		if (i != null) {
			return "registerSuccess"; // ע��ɹ�����ת��ע��ɹ�ҳ��

		}
		return "null";

	}

	// ע���˻�ʱ���˻����Ƿ��ѱ�ע�����У��
	@RequestMapping("queryByUser")
	public @ResponseBody User queryByUser(String userName) {

		return userService.getUserByUserName(userName);

	}
	//���С������
	
	@RequestMapping("toindex")
	public String toindex() {
		return "index";
	}

	//�ļ��ϴ�ҳ��
	@RequestMapping("upload_file")
	public String lay2(HttpServletRequest request) {
	
		return "upload_file";
	}
	
}
