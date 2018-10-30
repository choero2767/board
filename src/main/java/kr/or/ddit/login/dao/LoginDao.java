package kr.or.ddit.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.login.vo.UserVo;

public class LoginDao implements LoginDaoInf{
	
private static LoginDaoInf dao = null;
	
	private LoginDao() {
	}
	
	public static LoginDaoInf getInstance() {
		if(dao == null) {
			dao = new LoginDao();
		}
		return dao;
	}
	
	
	
	/**
	* Method : selectUserByIdAndPassword
	* 작성자 : pc23
	* 변경이력 :
	* @param userId 유저 아이디
	* @param password 유저 비밀번호
	* @return 유저객체 반환
	* Method 설명 : 아이디 체크
	*/
	@Override
	public UserVo selectUserByIdAndPassword(UserVo userVo) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		UserVo user = session.selectOne("user.selectUserByIdAndPassword", userVo);
		
		if(user != null){
			return user;
		}
		
		return null;
	}
}
