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

@WebServlet("/user/update.bit")
@SuppressWarnings("serial")
public class UserUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<link rel='stylesheet' type='text/css' href='/repositoryTest/css.css'>"
				+ "<title>과정변경</title></head><body>");
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");
			UserVo vo = dao.detail(no);
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>사용자변경폼</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>사용자변경</h1>");
			out.println("<form action='update.bit' method='post'>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>번호</th><td style='text-align:left;'><input type='text' name='no' value='" + vo.getNo() + "' readonly></td>");
			out.println("</tr><tr>");
			out.println("<th>이메일</th><td style='text-align:left;'><input type='text' name='email' value='" + vo.getEmail() + "'></td>");
			out.println("</tr><tr>");
			out.println("<th>비밀번호</th><td style='text-align:left;'><input type='password' name='passwd' value='" + vo.getPasswd() + "'></td>");
			out.println("</tr><tr>");
			out.println("<th>이름</th><td style='text-align:left;'><input type='text' name='name' value='" + vo.getName() + "'></td>");
			out.println("</tr><tr>");
			out.println("<th>전화번호</th><td style='text-align:left;'><input type='text' name='tel' value='" + vo.getTel() + "'></td>");
			out.println("</tr>");
			out.println("</tr><tr>");
			out.println("<th>팩스번호</th><td style='text-align:left;'><input type='text' name='fax' value='" + vo.getFax() + "'></td>");
			out.println("</tr>");
			out.println("</tr><tr>");
			out.println("<th>우편번호</th><td style='text-align:left;'><input type='text' name='postno' value='" + vo.getPostno() + "'></td>");
			out.println("</tr>");
			out.println("</tr><tr>");
			out.println("<th>주소</th><td style='text-align:left;'><input type='text' name='address' value='" + vo.getAddress() + "'></td>");
			out.println("</tr>");
			out.println("</tr><tr>");
			out.println("<th>사진</th><td style='text-align:left;'><input type='text' name='photo' value='" + vo.getPhoto() + "'></td>");
			out.println("</tr>");
			out.println("<tr><td colspan='2'>");
			out.println("<input type='submit' value='변경'>");
			out.println("<input type='button' value='취소' onclick=\"location.href='detail.bit?no=" + vo.getNo() + "'\">");
			out.println("</td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
			}catch (Throwable e){
				out.println("오류 발생!!");
				e.printStackTrace();
			}
			out.println("</body></html>");
		}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		// CharacterEncodingFilter로 대체함.
		//request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자변경</title></head><body>");
		try {
			out.println("<h1>사용자 변경 결과</h1>");

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");

			
			
			UserVo vo = new UserVo();
			vo.setNo(Integer.parseInt(request.getParameter("no")));
			vo.setEmail(request.getParameter("email"));
			vo.setPasswd(request.getParameter("passwd"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostno(request.getParameter("postno"));
			vo.setAddress(request.getParameter("address"));
			vo.setPhoto(request.getParameter("photo"));

			dao.update(vo);
			
			out.println("수정성공!!");
			response.sendRedirect("detail.bit?no=" + vo.getNo());
		}catch (Throwable e){
			out.println("오류 발생!!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
