package com.vshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;

public class InfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
//		if (session.getAttribute("user") != null) {
			// 调用业务逻辑处理类
			IUserService userService = new UserServiceImpl();
			User user = userService.getUserByUserId(session
					.getAttribute("user").toString());
			req.setAttribute("user", user);
			req.getRequestDispatcher("info.jsp").forward(req, resp);
//		} else {
//			System.out.println("您还没有登录，请先登录！");
//			resp.sendRedirect(req.getContextPath() + "/index.jsp");
//		})

	}

}
