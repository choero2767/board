package kr.or.ddit.comment.service;

import java.util.List;

import kr.or.ddit.comment.model.CommentVo;

public interface CommentServiceInf {
	
	
	/**
	* Method : selectPostCommentByPostCode
	* 작성자 : pc23
	* 변경이력 :
	* @return List<CommentVO> list 반환
	* Method 설명 : 해당 PostCode에 대한 댓글들을 불러옴
	*/
	public List<CommentVo> selectPostCommentByPostCode(String postCode);
	
	/**
	* Method : insertPostComment
	* 작성자 : pc23
	* 변경이력 :
	* @return int 반환
	* Method 설명 : 성공여부를 반환(성공 1, 실패 -1)
	*/
	public int insertPostComment(CommentVo commentVo);
	
	/**
	* Method : nowPostCommentNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return Integer 반환
	* Method 설명 : 현재 CommentCode의 최신 게시물 번호를 반환
	*/
	public Integer nowPostCommentNumber();
}
