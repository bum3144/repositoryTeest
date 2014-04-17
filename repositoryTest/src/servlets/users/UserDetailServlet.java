package servlets.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/user/detail.bit")
public class UserDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<link rel='stylesheet' type='text/css' href='/repositoryTest/css.css'>"
				+ "<title>사용자상세정보</title></head><body>");
		try {
			out.println("<h1>사용자 상세정보</h1>");

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");

			int no = Integer.parseInt(request.getParameter("no"));

			UserVo user = dao.detail(no);

			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<td style='text-align:left;'>" + user.getNo() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>이메일</th>");
			out.println("	<td style='text-align:left;'>" + user.getEmail() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>비밀번호</th>");
			out.println("	<td style='text-align:left;'>" + user.getPasswd() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>이름</th>");
			out.println("	<td style='text-align:left;'>" + user.getName() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>전화번호</th>");
			out.println("	<td style='text-align:left;'>" + user.getTel() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>팩스번호</th>");
			out.println("	<td style='text-align:left;'>" + user.getFax() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>주소</th>");
			out.println("	<td style='text-align:left;'>("+ user.getPostno() + ") " + user.getAddress() + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("	<th>사진경로</th>");
			out.println("	<td style='text-align:left;'>" + user.getPhoto() + "</td>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a>");
			out.println("<a href='delete.bit?no=" + user.getNo() + "'>삭제</a>");
			out.println("<a href='update.bit?no=" + user.getNo() + "'>변경</a><br>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
