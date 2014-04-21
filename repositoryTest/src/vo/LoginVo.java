package vo;

import java.io.Serializable;

public class LoginVo implements Serializable{
  private static final long serialVersionUID = 1L;

  int 			no;
  String 	email;
  String 	password;
  String 	name;
  String 	tel;
  String 	fax;
  String 	postNo;
  String 	address;
  String 	photoPath;
  
	public int getNo() {
		return no;
	}
	public LoginVo setNo(int no) {
		this.no = no;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public LoginVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public LoginVo setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public LoginVo setName(String name) {
		this.name = name;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public LoginVo setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getFax() {
		return fax;
	}
	public LoginVo setFax(String fax) {
		this.fax = fax;
		return this;
	}
	public String getPostNo() {
		return postNo;
	}
	public LoginVo setPostNo(String postNo) {
		this.postNo = postNo;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public LoginVo setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public LoginVo setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
		return this;
	}
}
















