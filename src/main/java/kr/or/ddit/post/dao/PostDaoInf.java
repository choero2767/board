package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.util.model.PageVo;

public interface PostDaoInf {

	/**
	* Method : nowPostNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 현재 게시물 번호를 알수 있다.
	*/
	public int nowPostNumber();
	 
	
	/**
	* Method : inquiryUp
	* 작성자 : pc23
	* 변경이력 :
	* @param boardCode
	* @return
	* Method 설명 : 조회수 증가
	*/
	public int inquiryUp(String postCode);
	
	
	/**
	* Method : selectPostByPage
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 게시물 불러오기
	*/
	public List<PostVo> selectPostByPage(PageVo pageVo);
	
	/**
	* Method : selectPostByPage
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 코드를 가지고 게시물 불러오기
	*/
	public PostVo selectPostByPostCode(String postCode);
	
	
	/**
	* Method : insertPost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 객체로 정보 넣어주기
	* 
	*/
	public int insertPost(PostVo postVo);
	
	/**
	* Method : updatePost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 객체로 수정하기
	* 
	*/
	public int updatePost(PostVo postVo);
	
	/**
	* Method : deletePost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 코드를 이용해서 postavailable = 2 로 바꾸기
	* 
	*/
	public int deletePost(String postCode);
	
	
	/**
	* Method : countPost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 총 현재 게시물 수를 구한다. 
	*/
	public Integer countPost(String boardCode);
}
