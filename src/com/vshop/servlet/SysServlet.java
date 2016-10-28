package com.vshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vshop.entity.Sys;
import com.vshop.service.ISysService;
import com.vshop.service.impl.SysServiceImpl;

public class SysServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String method = req.getParameter("m");
		if(method == null) {
			
		
		ISysService sysService = new SysServiceImpl();
		List<Sys> list = sysService.getList();
		for (Sys sys : list) {
			switch(sys.getUser_level()) {
			case 1:
				req.setAttribute("sys_one", sys);
				break;
			case 2:
				req.setAttribute("sys_two", sys);
				break;
			case 3:
				req.setAttribute("sys_three", sys);
				break;
			case 4:
				req.setAttribute("sys_four", sys);
				break;
			default:
					req.setAttribute("sys_five", sys);
					break;
			}
			
		}
		System.out.println("记录数：" + list.size());
		req.getRequestDispatcher("sys.jsp").forward(req, resp);
		}else {
			//保存
			save(req, resp);
		}
	}
	
	/**
	 * 保存的操作
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void save(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ISysService sysService = new SysServiceImpl();
		
		//A
		String user_min_one = req.getParameter("user_min_one");
		String user_max_one = req.getParameter("user_max_one");
		String user_money_one = req.getParameter("user_money_one");
		
		Sys sys_one = new Sys();
		sys_one.setId(1);
		sys_one.setUser_level(1);
		sys_one.setUser_min(Integer.parseInt(user_min_one));
		sys_one.setUser_max(Integer.parseInt(user_max_one));
		sys_one.setUser_money(Float.parseFloat(user_money_one));
		sysService.update(sys_one);
		
		
		//B
		String user_min_two = req.getParameter("user_min_two");
		String user_max_two = req.getParameter("user_max_two");
		String user_money_two = req.getParameter("user_money_two");
		
		Sys sys_two = new Sys();
		sys_two.setId(2);
		sys_two.setUser_level(2);
		sys_two.setUser_min(Integer.parseInt(user_min_two));
		sys_two.setUser_max(Integer.parseInt(user_max_two));
		sys_two.setUser_money(Float.parseFloat(user_money_two));
		sysService.update(sys_two);
		
		//C
		String user_min_three = req.getParameter("user_min_three");
		String user_max_three = req.getParameter("user_max_three");
		String user_money_three = req.getParameter("user_money_three");
		
		Sys sys_three = new Sys();
		sys_three.setId(3);
		sys_three.setUser_level(3);
		sys_three.setUser_min(Integer.parseInt(user_min_three));
		sys_three.setUser_max(Integer.parseInt(user_max_three));
		sys_three.setUser_money(Float.parseFloat(user_money_three));
		sysService.update(sys_three);
		
		//D
		String user_min_four = req.getParameter("user_min_four");
		String user_max_four = req.getParameter("user_max_four");
		String user_money_four = req.getParameter("user_money_four");
		
		Sys sys_four = new Sys();
		sys_four.setId(4);
		sys_four.setUser_level(4);
		sys_four.setUser_min(Integer.parseInt(user_min_four));
		sys_four.setUser_max(Integer.parseInt(user_max_four));
		sys_four.setUser_money(Float.parseFloat(user_money_four));
		sysService.update(sys_four);
		
		//E
		String user_min_five = req.getParameter("user_min_five");
		String user_max_five = req.getParameter("user_max_five");
		String user_money_five = req.getParameter("user_money_five");
		
		Sys sys_five = new Sys();
		sys_five.setId(5);
		sys_five.setUser_level(5);
		sys_five.setUser_min(Integer.parseInt(user_min_five));
		sys_five.setUser_max(Integer.parseInt(user_max_five));
		sys_five.setUser_money(Float.parseFloat(user_money_five));
		sysService.update(sys_five);
		
		
		
		req.setAttribute("msg", "系统设置保存成功！");
		req.getRequestDispatcher("success.jsp").forward(req, resp);
	}

		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
