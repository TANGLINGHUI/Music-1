package com.hwadee.music.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.music.domain.User;
import com.hwadee.music.service.UserService;
import com.hwadee.music.service.impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet {
private UserService userService = new UserServiceImpl();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if("list".equals(type)){
			listUsers(request,response);//显示所有用户信息
		}else if("del".equals(type)){
			delUser(request,response);//删除用户信息
		}else if("add".equals(type)){
			addUser(request,response);//新增用户信息
		}else if("search".equals(type)){
			findByName(request,response);//根据姓名查找用户信息
			}else if("findById".equals(type)){
				findById(request,response);//根据编号查找用户信息
			}else if("edit".equals(type)){
				editUser(request,response);//修改用户信息
			}
		}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		int  id = Integer.parseInt(request.getParameter("id"));
		
		User user = new User(id,name,email,gender,pwd);
		
		userService.editUser(user);
		listUsers(request,response);
	}

	private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//根据ID查询用户的详细信息 显示在edit.jsp
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userService.getUserById(id);
			
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("User/edit.jsp").forward(request, response);
		
	}

	private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("username");
		User user = userService.getUserByName(name);
		
	
		List<User> list = new ArrayList<User>();
		list.add(user);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("User/index.jsp").forward(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		
		User user = new User(0,name,email,gender,pwd);
		
		userService.addUser(user);
		
		//返回用户列表
		listUsers(request,response);
	}

	private void delUser(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//得到用户传入的id
		int id = Integer.parseInt(request.getParameter("id"));
		userService.delUser(id);
		//返回index.jsp页面-------用户列表 
		listUsers(request,response);
	}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   //列表
			System.out.println("用户列表查询");
			List<User> list = userService.getAllUsers();
			//list返回给界面显示
			request.setAttribute("list", list);
			request.getRequestDispatcher("sys/User/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//登录
		
		
		//1.得到页面的输入
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		User user = new User();
		user.setUser_name(name);
		user.setUser_pwd(pwd);
		//2.验证输入是否能够登录
		UserService service = new UserServiceImpl();
		boolean flag = service.validateLogin(user);//通过接口定义了实现方法的规范
		//3.根据结果返回对应的页面:
		//相对路径
		//http://localhost:8088/music/UserServlet
		if(flag){
			//http://localhost:8088/music/UserServlet/sys/index.html
			response.sendRedirect("index.html");
		}else{
			//http://localhost:8088/music/UserServlet/login.html
			response.sendRedirect("login.html");
		}
		
	}
}
