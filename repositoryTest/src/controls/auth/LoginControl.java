package controls.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import vo.LoginVo;
import controls.PageController;
import dao.DaoException;
import dao.LoginDao;

public class LoginControl implements PageController {
	LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public String execute(Map<String, Object> model) {
		try {
			if (model.get("email") == null) { // 로그인 폼 출력 
				return "/auth/login.jsp";
				
			} else { // 로그인 수행 
				String email = (String)model.get("email");
				String password = (String)model.get("password");
				String saveEmail = (String)model.get("saveEmail");
				
				LoginVo loginVo = null;
				
				try {
					loginVo = loginDao.getUser(email, password);
				} catch (DaoException e) { // 로그인 실패!
					return "redirect:login.bit";
				}
				
				HashMap<String,Object> sessionMap = new HashMap<String,Object>();
				sessionMap.put("loginUser", loginVo);
				model.put("sessionMap", sessionMap);
				
				if (saveEmail != null) {
					ArrayList<Cookie> cookies = new ArrayList<Cookie>();
					
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("s20.java48.com"); // 서버 범위
					cookie.setPath("/web01");					// 하위 폴더 범위
					
					cookies.add(cookie);
					model.put("cookies", cookies);
				}
				
				return "redirect:../subject/list.bit?pageNo=1&pageSize=10";
			}
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}



















