package dao;

import vo.LoginVo;

public interface LoginDao {
	LoginVo getUser(String email, String password);
}
