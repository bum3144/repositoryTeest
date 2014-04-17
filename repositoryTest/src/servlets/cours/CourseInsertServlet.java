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

@WebServlet("/course/insert.bit")
@SuppressWarnings("serial")
public class CourseInsertServlet extends HttpServlet {
	
	@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		doGet(request, response);
  }
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<link rel='stylesheet' type='text/css' href='/repositoryTest/css.css'>"
				+ "<title>과정등록</title></head><body>");
		try {
			out.println("<h1>과정 등록 결과</h1>");

			CourseDao dao = (CourseDao)this.getServletContext().getAttribute("courseDao");

			
			CourseVo vo = new CourseVo();
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));
			vo.setHour(Integer.parseInt(request.getParameter("hour")));

			dao.insert(vo);
			
			out.println("등록성공!!");
			response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		}catch (Throwable e){
			out.println(e);
			out.println("오류 발생!!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
