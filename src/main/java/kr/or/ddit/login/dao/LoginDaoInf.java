package kr.or.ddit.login.dao;

import kr.or.ddit.login.vo.UserVo;

public interface LoginDaoInf {
	
	/**
	* Method : selectUserByIdAndPassword
	* 작성자 : pc23
	* 변경이력 :
	* @param userId 
	* @param password 
	* @return 사용자 객체 반환
	* Method 설명 : 아이디 체크
	*/
	public UserVo selectUserByIdAndPassword(UserVo userVo);
}
