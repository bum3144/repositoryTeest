package servlets.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@WebServlet("/user/insert.bit")
@SuppressWarnings("serial")
public class UserInsertServlet extends HttpServlet {
	
	@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		doGet(request, response);
  }
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		try {

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");

			
			UserVo vo = new UserVo();
			vo.setEmail(request.getParameter("email"));
			vo.setPasswd(request.getParameter("passwd"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostno(request.getParameter("postno"));
			vo.setAddress(request.getParameter("address"));
			vo.setPhoto(request.getParameter("photo"));

			dao.insert(vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/user/insert.jsp");
			rd.forward(request, response);
			
		}catch (Throwable e){
			e.printStackTrace();
		}
	}
}
