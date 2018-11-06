package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/checkName.do")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.设置编码
		req.setCharacterEncoding("UTF-8");
		//2.响应格式
		resp.setContentType("text/html;charset=utf-8");
		//3.获取参数
		String username = req.getParameter("username");
		//4.判断
		//将用户账户与服务器数据进行对比
		boolean flag = false;
		String[] list = {"admin","user","username"};
		for(int i=0;i<list.length;i++){
			if(list[i].equals(username)){
				flag = true;
				break;
			}
		}
		//5.响应数据
		PrintWriter out = resp.getWriter();
		out.print(flag);
		out.close();
		
	}
	
}
