package servlets.cours;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@SuppressWarnings("serial")
@WebServlet("/course/detail.bit")
public class CourseDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<link rel='stylesheet' type='text/css' href='/repositoryTest/css.css'>"
				+ "<title>과정상세정보</title></head><body>");
		try {
			out.println("<h1>과정 상세정보</h1>");

			CourseDao dao = (CourseDao)this.getServletContext().getAttribute("courseDao");

			int no = Integer.parseInt(request.getParameter("no"));

			CourseVo course = dao.detail(no);

			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<td style='text-align:left;'>" + course.getNo() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>과정명</th>");
			out.println("	<td style='text-align:left;'>" + course.getTitle() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>내용</th>");
			out.println("	<td style='text-align:left;'><textarea rows='5' cols='60'>" + course.getDescription() + "</textarea></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>시간</th>");
			out.println("	<td style='text-align:left;'>" + course.getHour() + " 시간</td>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a>");
			out.println("<a href='delete.bit?no=" + course.getNo() + "'>삭제</a>");
			out.println("<a href='update.bit?no=" + course.getNo() + "'>변경</a><br>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
