package kr.or.ddit.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

public class FileDao implements FileDaoInf{
private static FileDaoInf dao = null;
	
	private FileDao() {
	}
	
	public static FileDaoInf getInstance() {
		if(dao == null) {
			dao = new FileDao();
		}
		return dao;
	}
	
	
	/**
	* Method : nowFileCodeNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :파일 최신 코드를 가져온다.
	*/
	@Override
  	public Integer nowFileCodeNumber(){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try {
			Integer nowFileCode = session.selectOne("file.nowFileCodeNumber");
			
			return nowFileCode;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
  	}
  	
  	/**
	* Method : insertFile
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :파일을 생성한다. 
	*/
	@Override
  	public int insertFile(FileVo fileVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try {
			int result = session.insert("fileSQL.insertFile", fileVo);
			
			session.commit();
			session.close();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
  	
  	
  	/**
	* Method : selectFilebyPostCode
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :포스트 코드에 해당하는 파일들을 가져온다. 
	*/
	@Override
  	public List<FileVo> selectFilebyPostCode(String postCode){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try {
			
			List<FileVo> fileList = session.selectList("file.selectFilebyPostCode", postCode);
			
			return fileList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
