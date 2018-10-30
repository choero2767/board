package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.util.model.PageVo;

public class PostService implements PostServiceInf{

	private PostDaoInf dao = null;
	private static PostServiceInf service = null;
	
	private PostService() {
		dao = PostDao.getInstance();
	}
	
	public static PostServiceInf getInstance() {
		if(service == null) {
			service = new PostService();
		}
		
		return service;
	}

	/**
	* Method : nowPostNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 현재 게시물 번호
	*/
	@Override
	public int nowPostNumber() {
		return dao.nowPostNumber();
	}
	
	
	/**
	* Method : inquiryUp
	* 작성자 : pc23
	* 변경이력 :
	* @param boardCode
	* @return
	* Method 설명 : 조회수 증가
	*/
	@Override
	public int inquiryUp(String postCode) {
		return dao.inquiryUp(postCode);
	}

	
	/**
	* Method : selectPostByPage
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 게시물 불러오기
	*/
	@Override
	public List<PostVo> selectPostByPage(String pageNumber, String boardCode) {
		
		PageVo pageVo = new PageVo();
		pageVo.setBoardCode(Integer.parseInt(boardCode));
		pageVo.setPageNumber(Integer.parseInt(pageNumber));
		pageVo.setPageSize(10);
		
		return dao.selectPostByPage(pageVo);
	}
	
	/**
	* Method : selectPostByPage
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 코드를 가지고 게시물 불러오기
	*/
	@Override
	public PostVo selectPostByPostCode(String postCode){
		return dao.selectPostByPostCode(postCode);
	}
	
	
	/**
	* 
	* Method : insertPost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 객체로 정보 넣어주기
	* 
	*/
	public int insertPost(PostVo postVo){
		return dao.insertPost(postVo);
	}
	
	/**
	* Method : updatePost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 객체로 수정하기
	* 
	*/
	@Override
	public int updatePost(PostVo postVo){
		return dao.updatePost(postVo);
	}
	
	/**
	* Method : deletePost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 코드를 이용해서 postavailable = 2 로 바꾸기
	* 
	*/
	@Override
	public int deletePost(String postCode){
		return dao.deletePost(postCode);
	}
	
	/**
	* Method : countPost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 총 현재 게시물 수를 구한다. 
	*/
	@Override
	public int countPost(String boardCode){
		return dao.countPost(boardCode);
	}
	
	
	/**
	* Method : totalPageNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 총 현재 페이지의 토탈 페이지를 구한다. 
	*/
	@Override
	public int totalPageNumber(String boardCode){
		Integer count = countPost(boardCode);
		
		int totalPage = count%10==0 ? count/10 : count/10+1;
				
		return totalPage;
	}

}
