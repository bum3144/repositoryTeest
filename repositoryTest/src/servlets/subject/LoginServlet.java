package servlets.subject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

@WebServlet("/auth/login2.bit")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	try{
			
		RequestDispatcher rd = request.getRequestDispatcher("/auth/login.jsp");
		rd.forward(request, response);
		
		}catch (Throwable e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		try {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String saveEmail = request.getParameter("saveEmail");
			
			if(saveEmail != null){
				Cookie cookie = new Cookie("loginEmail", email);
				
				cookie.setDomain("s20.java48.com");
				cookie.setPath("/repositoryTest");
				
				cookie.setMaxAge(40);
				
				response.addCookie(cookie);		
				
			}
			
			response.sendRedirect("../subject/list.bit?pageNo=1&pageSize=10");
		}catch (Throwable e){
			e.printStackTrace();
		}
	}
}
