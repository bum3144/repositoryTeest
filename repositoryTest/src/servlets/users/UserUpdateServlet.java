package servlets.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");
			UserVo user = dao.detail(no);
			
			request.setAttribute("user", user);
			
			RequestDispatcher rd =request.getRequestDispatcher("/users/updateform.jsp");
			
			rd.forward(request, response);
			
			}catch (Throwable e){
				e.printStackTrace();
			}
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
