package servlets.cours;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<link rel='stylesheet' type='text/css' href='/repositoryTest/css.css'>"
				+ "<title>과정목록</title></head><body>");
		try {
			out.println("<h1>과정 목록</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext().getAttribute("courseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<CourseVo> list = dao.list(pageNo, pageSize);

			out.println("<a href='/repositoryTest/'>HOME</a> ");
			out.println("<a href='form.html'>새과정</a><br>");
			out.println("<table>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<th>과목명</th>");
			out.println("	<th>시간</th>");
			out.println("</tr>");
			
			for (CourseVo course : list) {
				out.println("<tr>");
				out.println("	<td>" + course.getNo() + "</td>");
				out.println("	<td><a href='detail.bit?no=" + course.getNo() + "'>" + course.getTitle() + "</a></td>");
				out.println("	<td>" + course.getHour() + "</td>");
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