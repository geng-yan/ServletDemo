package demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setHeader("refresh", "5");
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 20);
		g.setColor(Color.BLUE);
		g.setFont(new Font(null,Font.BOLD,20));
		g.drawString(makeNum(), 0, 20);
		resp.setContentType("image/jpeg");
		resp.setDateHeader("expries", -1);
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-cache");
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}
	private String makeNum(){
		Random random = new Random();
		String num = random.nextInt(9999999)+"";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 7-num.length(); i++) {
			sb.append(0);
		}
		num = sb.toString()+num;
		return num;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
