package mentees.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mentees.service.NoticeService;

/**
 * Servlet implementation class NoticeSearchController
 */
@WebServlet("/noticesearch")
public class NoticeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final NoticeService noticeService = new NoticeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email"); 
		if (email == null) {
			out.print("<script>alert('로그인 후 이용해주세요'); location.href='login.jsp'; </script>");
		}
		else {
			String query = request.getParameter("query");
			request.setAttribute("noticeList", noticeService.search(query));
		
			RequestDispatcher dispatch =  request.getRequestDispatcher("noticePage.jsp");
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
