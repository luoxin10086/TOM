package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.Student;

@WebServlet("/students.do")
public class StudentServlet extends HttpServlet{

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
		String username = req.getParameter("name");
		String userage = req.getParameter("age");
		System.out.println("name:"+username+"userage"+userage);
		//4.查询所有学生
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("张三", 20));
		students.add(new Student("张三2", 21));
		students.add(new Student("张三3", 22));
		//java对象转变成JSON对象
		String json = JSON.toJSONString(students);
		System.out.println("json:"+json);
		//5.响应数据
		PrintWriter out = resp.getWriter();
		out.write(JSON.toJSONString(students));//发送json数据到前台
		out.close();
	}
	
}
