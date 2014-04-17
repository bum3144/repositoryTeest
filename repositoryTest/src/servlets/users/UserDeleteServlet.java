package users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/user/delete.bit")
public class UserDeleteServlet extends HttpServlet{

	@Override
  protected void doGet(
  		HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		
		try {

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");
			int no = Integer.parseInt(request.getParameter("no"));

			dao.delete(no);
			
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
			
		}catch (Throwable e){
			e.printStackTrace();
		}
	}
}