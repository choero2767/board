package kr.or.ddit.login.service;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.login.dao.LoginDao;
import kr.or.ddit.login.dao.LoginDaoInf;
import kr.or.ddit.login.vo.UserVo;

public class LoginService implements LoginServiceInf{
	
	private LoginDaoInf dao = null;
	private static LoginServiceInf service = null;
	
	private LoginService() {
		dao = LoginDao.getInstance();
	}
	
	public static LoginServiceInf getInstance() {
		if(service == null) {
			service = new LoginService();
		}
		
		return service;
	}
	
	@Override
	public UserVo selectUserByIdAndPassword(UserVo userVo) {
		
		
		return dao.selectUserByIdAndPassword(userVo);
	}
}
