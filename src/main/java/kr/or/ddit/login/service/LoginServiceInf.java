package kr.or.ddit.login.service;

import kr.or.ddit.login.vo.UserVo;

public interface LoginServiceInf {
	
	/**
	* Method : selectUserByIdAndPassword
	* 작성자 : pc23
	* 변경이력 :
	* @param userId 
	* @param password 
	* @return 사용자 객체
	* Method 설명 : 아이디 체크
	*/
	public UserVo selectUserByIdAndPassword(UserVo userVo);
}
