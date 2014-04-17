package users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/user/detail.bit")
public class UserDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		try {

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");

			int no = Integer.parseInt(request.getParameter("no"));

			UserVo user = dao.detail(no);
			
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/users/detail.jsp");
			rd.forward(request, response);

		} catch (Throwable e) {
			e.printStackTrace();
		}
}
}
