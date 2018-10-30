package kr.or.ddit.login.vo;

import java.util.Date;

public class UserVo {
	private String userId; // 회원아이디
	private String name; // 회원이름
	private String password; // 회원비번
	private Date birth; // 회원생일
	private String addr1; // 회원주소
	private String addr2; // 회원상세주소
	private String zipcd; // 회원우편번호
	private String email; // 회원이메일
	private String tel; // 회원전화번호
	private String profile; // 회원프로필경로
//	private int rnum;
	private Integer right;
	
	public UserVo() {
		
	}
//	public int getRnum() {
//		return rnum;
//	}
//
//	public void setRnum(int rnum) {
//		this.rnum = rnum;
//	}

	public Integer getRight() {
		return right;
	}

	public void setRight(Integer right) {
		this.right = right;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipCd() {
		return zipcd;
	}

	public void setZipCd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", password="
				+ password + ", birth=" + birth + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", zipcd=" + zipcd + ", email=" + email
				+ ", tel=" + tel + ", profile=" + profile + ", right=" + right
				+ "]";
	}

	/**
	* Method : authPass
	* 작성자 : pc23
	* 변경이력 :
	* @param encryptPass
	* @return
	* Method 설명 :
	*/
	public boolean authPass(String encryptPass) {
		return getPassword().equals(encryptPass);
	}
}
