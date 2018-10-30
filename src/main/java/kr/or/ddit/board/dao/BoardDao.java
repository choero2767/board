package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao implements BoardDaoInf{
		
		private static BoardDaoInf dao = null;
		
		private BoardDao(){}
		
		public static BoardDaoInf getInstance() {
			if(dao == null) {
				dao = new BoardDao();
			}
			return dao;
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
			
			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
			
			List<BoardVo> boardList = session.selectList("board.selectBoardList");
			session.close();
			if(boardList != null){
				return boardList;
			}
			
			return null;
		}
		
		/**
		* Method : selectBoardListMake
		* 작성자 : pc23
		* 변경이력 :
		* @return List<BoardVO> list 반환
		* Method 설명 : 현재 가지고 있는 게시판 불러오기
		*/
		@Override
		public List<BoardVo> selectBoardListMake(){

			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
			
			List<BoardVo> boardList = session.selectList("board.selectBoardListMake");
			session.close();
			if(boardList != null){
				return boardList;
			}
			
			return null;
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
			
			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
			
			String boardName = session.selectOne("board.getBoardName", boardCode);
			session.close();
			if(boardName != null){
				return boardName;
			}
			
			return null;
		}
		
		
		/**
		* Method : getBoardCode
		* 작성자 : pc23
		* 변경이력 :
		* @return
		* Method 설명 : 최근 boardCode 얻어오기
		*/
		@Override
		public Integer getBoardCode(){
			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
			
			try {
				Integer getBoardCode = session.selectOne("board.getBoardCode");
				session.close();
				return getBoardCode;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return -1;
		}
		
		/**
		* Method : insertBoard
		* 작성자 : pc23
		* 변경이력 :
		* @return
		* Method 설명 :게시판 insert
		*/
		@Override
		public int insertBoard(BoardVo boardVo){
			
			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
			
			SqlSession session = factory.openSession();
			
			try {
				
				int result = session.insert("board.insertBoard", boardVo);
				session.close();
				session.commit();
				session.close();
				
				return result;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return -1;
		}
		
		/**
		* Method : updateBoard
		* 작성자 : pc23
		* 변경이력 :
		* @return
		* Method 설명 :게시판 수정
		*/
		@Override
		public int updateBoard(BoardVo boardVo){
			
			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();

			SqlSession session = factory.openSession();

			try {

				int result = session.update("board.updateBoard", boardVo);
				session.commit();
				session.close();
				
				return result;

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return -1;
		}

}
