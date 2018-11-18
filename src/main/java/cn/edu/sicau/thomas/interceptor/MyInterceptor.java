/**
 * 
 */
package cn.edu.sicau.thomas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.sicau.thomas.pojo.User;

/**
 * @author Thomas
 *
 */
public class MyInterceptor  implements HandlerInterceptor{


	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		final String LOGIN_URL = "/user/toLogin.do";
		//判断session中是否存在登录信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user==null ) {
			response.sendRedirect(request.getContextPath()+LOGIN_URL);
			return false;
		}
	
		return true;
	}
	 
  
	
}
