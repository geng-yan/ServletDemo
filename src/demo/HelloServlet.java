package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 最简单的Servlet
 * @author Winter Lau
 */
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		downloadFileByOutputStream(resp);
		
	}
	private void downloadFileByOutputStream(HttpServletResponse response)
		throws FileNotFoundException,IOException {
		String realPath = "/Users/mcdreamy/Desktop/2.properties";
		String fileName = realPath.substring(realPath.lastIndexOf("/")+1);
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		byte[] buffer = new byte[1024];
		OutputStream out = response.getOutputStream();
		while((len = in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		in.close();
	}
}
