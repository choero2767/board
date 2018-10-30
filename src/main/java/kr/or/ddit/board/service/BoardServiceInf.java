package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {

	/**
	* Method : selectBoardList
	* 작성자 : pc23
	* 변경이력 :
	* @return List<BoardVO> list 반환
	* Method 설명 : 현재 가지고 있는 게시판 불러오기
	*/
	public List<BoardVo> selectBoardList();
	
	/**
	* Method : selectBoardListMake
	* 작성자 : pc23
	* 변경이력 :
	* @return List<BoardVO> list 반환
	* Method 설명 : 현재 가지고 있는 게시판 불러오기
	*/
	public List<BoardVo> selectBoardListMake();
	
	/**
	* Method : getBoardName
	* 작성자 : pc23
	* 변경이력 :
	* @param boardCode
	* @return
	* Method 설명 : 게시판 이름 가져오기
	*/
	public String getBoardName(Integer boardCode);
	
	
	/**
	* Method : getBoardCode
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 최근 boardCode 얻어오기
	*/
	public Integer getBoardCode();
	
	/**
	* Method : insertBoard
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 insert
	*/
	public int insertBoard(BoardVo boardVo); 
	
	/**
	* Method : updateBoard
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 수정
	*/
	public int updateBoard(BoardVo boardVo); 

}
