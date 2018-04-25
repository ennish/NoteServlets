package com.enn.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enn.service.BasicService;

import java.io.IOException;

/**
 * Servlet implementation class ServletA
 */
@WebServlet(name = "ServletA", urlPatterns = "/test")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String echostr = request.getParameter("echostr");
		System.out.println(echostr);
		BasicService service = new BasicService();
//		if (service.validate(request, response)) {
//			response.getWriter().write(echostr);
//		} else {
//			response.getWriter().write("fail");
//		}
		response.getWriter().write(echostr==null?"":echostr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
