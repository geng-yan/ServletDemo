package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String clientCheckcode = req.getParameter("validateCode");
		String serverCheckcode = (String) req.getSession().getAttribute("checkcode");
		System.out.println(clientCheckcode);
		System.out.println(serverCheckcode);
		if(clientCheckcode.equals(serverCheckcode)){
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
