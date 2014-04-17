package servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import vo.UserVo;

@WebServlet("/user/list.bit")
@SuppressWarnings("serial")
public class UserListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<link rel='stylesheet' type='text/css' href='/repositoryTest/css.css'>"
				+ "<title>사용자목록</title></head><body>");
		try {
			out.println("<h1>사용자 목록</h1>");
			out.println("<script src='//code.jquery.com/jquery-1.11.0.min.js'></script>");
			
			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<UserVo> list = dao.list(pageNo, pageSize);

			out.println("<a href='/repositoryTest/'>HOME</a> ");
			out.println("<a href='form.html'>사용자추가</a><br>");
			out.println("<table>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<th>이름</th>");
			out.println("	<th>이메일</th>");
			out.println("</tr>");
			
			for (UserVo user : list) {
				out.println("<tr>");
				out.println("	<td>" + user.getNo() + "</td>");
				out.println("	<td><a href='detail.bit?no=" + user.getNo() + "'>" + user.getName() + "</a></td>");
				out.println("	<td><a href='detail.bit?no=" + user.getNo() + "'>" + user.getEmail() + "</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}