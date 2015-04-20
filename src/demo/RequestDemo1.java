package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestUrl = req.getRequestURL().toString();
		String requestUri = req.getRequestURI();
		String queryString = req.getQueryString();
		String remodeAddr = req.getRemoteAddr();
		String remoteHost =  req.getRemoteHost();
		int tremotePort = req.getRemotePort();
		String remoteUser = req.getRemoteUser();
		String method = req.getMethod();
		String pathInfo = req.getPathInfo();
		String localAddr = req.getLocalAddr();
		String localName = req.getLocalName();
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("或得到的客户及信息如下");
		out.write("<hr/>");
		out.write("请求的URL地址:"+requestUrl+"<br />");
		out.write("请求的资源:"+requestUri+"<br />");
		out.write("请求的URL附带的参数:"+queryString+"<br />");
		out.write("请求的IP:"+remodeAddr+"<br />");
		out.write("请求的主机:"+remoteHost+"<br />");
		out.write("请求的端口号:"+tremotePort+"<br />");
		out.write("remoteUser:"+remoteUser+"<br />");
		out.write("请求使用的方法:"+method+"<br />");
		out.write("pathInfo:"+pathInfo+"<br />");
		out.write("localAddr:"+localAddr+"<br />");
		out.write("localName:"+localName+"<br />");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
