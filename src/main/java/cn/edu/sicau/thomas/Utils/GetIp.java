/**
 * 
 */
package cn.edu.sicau.thomas.Utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Thomas
 *
 */

	
	public class GetIp {
		
		
		
		
		// ∑µªÿ”√IPµÿ÷∑
		public static String getIpAddr(HttpServletRequest request) {
			String ip = request.getHeader(" x-forwarded-for ");
			if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
				ip = request.getHeader(" Proxy-Client-IP ");
			}
			if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
				ip = request.getHeader(" WL-Proxy-Client-IP ");
			}
			if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			return ip;
		}

	}


