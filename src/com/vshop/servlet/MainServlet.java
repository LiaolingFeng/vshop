package com.vshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.vshop.entity.Sys;
import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		IUserService userSerive = new UserServiceImpl();
		String user_id = req.getParameter("user");
		if (user_id == null) {
			user_id = session.getAttribute("user").toString();
		}
		User user = userSerive.getUserByUserId(user_id);
		if (user != null) {
			List<User> userList = userSerive.getList(user.getLeft_num(),
					user.getRight_num(), user.getUser_level());
			int i = 0;
			for (User user2 : userList) {

				if (user2.getUser_level() == user.getUser_level() + 1) {
					// 第二层
					switch (i) {
					case 0:
						req.setAttribute("user_1", user2); // jake
						break;
					case 1:
						req.setAttribute("user_2", user2); //
						break;
					default:
						req.setAttribute("user_3", user2);
						break;
					}
					i++;
				} else {
					// 第三层

				}
			}
			req.setAttribute("current_user", user);
			// req.setAttribute("list", userList);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("error.jsp");
		}
	}
}
