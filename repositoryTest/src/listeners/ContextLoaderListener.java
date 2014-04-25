package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.DBConnectionPool;
import controls.FileUploadControl;
import controls.SubjectDeleteControl;
import controls.SubjectDetailControl;
import controls.SubjectInsertControl;
import controls.SubjectListControl;
import controls.SubjectUpdateControl;
import controls.auth.LoginControl;
import controls.auth.LogoutControl;
import dao.MysqlCourseDao;
import dao.MysqlLoginDao;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;

/* ServetContextListener
 *  - 웹 애플리케이션의 시작/종료 이벤트 처리
 *  - 구현체 작성 => web.xml등록
 *  - <listener></listener>
 */

public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool = null;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized...");
		ServletContext sc = event.getServletContext();

		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));

		MysqlSubjectDao subjectdao = new MysqlSubjectDao();
		subjectdao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectdao);

		MysqlCourseDao coursedao = new MysqlCourseDao();
		coursedao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("courseDao", coursedao);

		MysqlUserDao userdao = new MysqlUserDao();
		userdao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userdao);
		
		MysqlLoginDao logindao = new MysqlLoginDao();
		logindao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("loginDao", logindao);

		SubjectListControl subjectListControl = new SubjectListControl();
		subjectListControl.setSubjectDao(subjectdao);
		sc.setAttribute("/subject/list.bit", subjectListControl);
		
		SubjectDetailControl subjectDetailControl = 
				new SubjectDetailControl();
		subjectDetailControl.setSubjectDao(subjectdao);
		sc.setAttribute("/subject/detail.bit", subjectDetailControl);
		
		SubjectInsertControl subjectInsertControl = 
				new SubjectInsertControl();
		subjectInsertControl.setSubjectDao(subjectdao);
		sc.setAttribute("/subject/insert.bit", subjectInsertControl);

		SubjectUpdateControl subjectUpdateControl = 
				new SubjectUpdateControl();
		subjectUpdateControl.setSubjectDao(subjectdao);
		sc.setAttribute("/subject/update.bit", subjectUpdateControl);
		
		SubjectDeleteControl subjectDeleteControl = 
				new SubjectDeleteControl();
		subjectDeleteControl.setSubjectDao(subjectdao);
		sc.setAttribute("/subject/delete.bit", subjectDeleteControl);
		
		LoginControl loginControl = new LoginControl();
		loginControl.setLoginDao(logindao);
		sc.setAttribute("/auth/login.bit", loginControl);
		
		LogoutControl logoutControl = new LogoutControl();
		sc.setAttribute("/auth/logout.bit", logoutControl);
		
		FileUploadControl fileUploadControl = new FileUploadControl();
		sc.setAttribute("/file/upload.bit", fileUploadControl);
		
	}

}
