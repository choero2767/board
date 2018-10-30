package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.util.model.PageVo;

public class BoardService implements BoardServiceInf{

	private BoardDaoInf dao = null;
	private static BoardServiceInf service = null;
	
	private BoardService() {
		dao = BoardDao.getInstance();
	}
	
	public static BoardServiceInf getInstance() {
		if(service == null) {
			service = new BoardService();
		}
		
		return service;
	}

	/**
	* Method : selectBoardList
	* 작성자 : pc23
	* 변경이력 :
	* @return List<BoardVO> list 반환
	* Method 설명 : 현재 가지고 있는 게시판 불러오기
	*/
	@Override
	public List<BoardVo> selectBoardList() {
		return dao.selectBoardList();
	}
	
	/**
	* Method : selectBoardListMake
	* 작성자 : pc23
	* 변경이력 :
	* @return List<BoardVO> list 반환
	* Method 설명 : 현재 가지고 있는 게시판 불러오기
	*/
	public List<BoardVo> selectBoardListMake(){
		return dao.selectBoardListMake();
	}
	
	
	/**
	* Method : getBoardName
	* 작성자 : pc23
	* 변경이력 :
	* @param boardCode
	* @return
	* Method 설명 : 게시판 이름 가져오기
	*/
	@Override
	public String getBoardName(Integer boardCode){
		return dao.getBoardName(boardCode);
	}
	
	/**
	* Method : getBoardCode
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 최근 boardcode를 얻어온다
	*/
	@Override
	public Integer getBoardCode(){
		return dao.getBoardCode();
	}
	
	/**
	* Method : insertBoard
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :게시판을 만든다.
	*/
	@Override
	public int insertBoard(BoardVo boardVo){
		return dao.insertBoard(boardVo);
	}
	
	/**
	* Method : updateBoard
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 :게시판을 수정한다.
	*/
	@Override
	public int updateBoard(BoardVo boardVo){
		return dao.updateBoard(boardVo);
	}

}
