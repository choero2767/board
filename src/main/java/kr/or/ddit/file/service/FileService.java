package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

public class FileService implements FileServiceInf{
	
	private FileDaoInf dao = null;
	private static FileServiceInf service = null;
	
	private FileService() {
		dao = FileDao.getInstance();
	}
	
	public static FileServiceInf getInstance() {
		if(service == null) {
			service = new FileService();
		}
		
		return service;
	}
	
	/**
	* Method : nowFileCodeNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :파일 최신 코드를 가져온다
	*/
  	public Integer nowFileCodeNumber(){
  		
  		return dao.nowFileCodeNumber();
  	}
  	
  	/**
	* Method : insertFile
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :파일을 생성한다. 
	*/
  	public int insertFile(FileVo fileVo){
  		return dao.insertFile(fileVo);
  	}
  	
  	
  	/**
	* Method : selectFilebyPostCode
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :포스트 코드에 해당하는 파일들을 가져온다. 
	*/
  	public List<FileVo> selectFilebyPostCode(String postCode){
  		return dao.selectFilebyPostCode(postCode);
  	}
}
