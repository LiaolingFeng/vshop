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
import com.vshop.util.StringHelper;

public class SaveInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 修改的保存方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
//		if (session.getAttribute("user") != null) {
			// 调用业务逻辑处理类
			IUserService userService = new UserServiceImpl();
			User user = userService.getUserByUserId(session
					.getAttribute("user").toString());
			user.setUser_name(req.getParameter("user_name"));
			user.setUser_birthday(req.getParameter("user_birthday"));
			user.setUser_city(req.getParameter("user_city"));
			// 修改密码，不填不修改
			String user_pass = req.getParameter("user_pass");
			if (user_pass != "") {
				// 设置新密码
				user.setUser_pass(StringHelper.MD5(user_pass));
			} else {
				// 保持原来的密码
				user.setUser_pass(req.getParameter("hf_pass"));
			}
			user.setUser_faq(Integer.parseInt(req.getParameter("user_faq")));
			user.setUser_answer(req.getParameter("user_answer"));
			boolean b = userService.saveUserInfo(user);
			if (b) {
				req.setAttribute("msg", "恭喜修改信息成功!");
			} else {
				req.setAttribute("msg", "抱歉修改信息失败!");
			}
			req.getRequestDispatcher("success.jsp").forward(req, resp);
//		} else {
//			System.out.println("您还没有登录，请先登录！");
//			resp.sendRedirect(req.getContextPath() + "/index.jsp");
//		}
	}
}
