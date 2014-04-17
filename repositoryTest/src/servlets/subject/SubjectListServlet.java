package servlets.subject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

/*과목명에 상세보기 링크 추가
 * 
 */

@WebServlet("/subject/list.bit")
@SuppressWarnings("serial")
public class SubjectListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		try {
			
			SubjectDao dao = (SubjectDao)this.getServletContext().getAttribute("subjectDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<SubjectVo> list = dao.list(pageNo, pageSize);

			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/subject/list.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
