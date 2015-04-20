package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

public class CookieDemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			out.write("您上次访问的时间是：");
			for(int i=0;i<cookies.length;++i) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toLocaleString());
				}
			}
		} else {
			out.write("第一次访问");
		}
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		resp.addCookie(cookie);
	}
}
