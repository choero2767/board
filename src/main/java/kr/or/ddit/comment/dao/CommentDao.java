package kr.or.ddit.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.db.SqlFactoryBuilder;

public class CommentDao implements CommentDaoInf{
private static CommentDaoInf dao = null;
	
	private CommentDao() {
	}
	
	public static CommentDaoInf getInstance() {
		if(dao == null) {
			dao = new CommentDao();
		}
		return dao;
	}
	
	/**
	* Method : selectPostCommentByPostCode
	* 작성자 : pc23
	* 변경이력 :
	* @return List<CommentVO> list 반환
	* Method 설명 : 해당 PostCode에 대한 댓글들을 불러온다.
	*/
	@Override
	public List<CommentVo> selectPostCommentByPostCode(String postCode){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		System.out.println("postCode in dao = "+postCode);
		try {
			
			List<CommentVo> commentList = session.selectList("comment.selectPostCommentByPostCode", postCode);
			
			if(commentList != null){
				return commentList;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	* Method : insertPostComment
	* 작성자 : pc23
	* 변경이력 :
	* @return int 반환
	* Method 설명 : 성공여부를 반환한다. sql 문제시 -1 , 성공할시 1
	*/
	@Override
	public int insertPostComment(CommentVo commentVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		try {

			int result = session.insert("comment.insertPostComment", commentVo);
			session.commit();
			session.close();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	/**
	* Method : nowPostCommentNumber
	* 작성자 : pc23
	* 변경이력 :
	* @return Integer 반환
	* Method 설명 : 현재 CommentCode의 최신 게시물 번호를 반환한다. 
	*/
	@Override
	public Integer nowPostCommentNumber(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();

		SqlSession session = factory.openSession();
		try {

			int result = session.selectOne("comment.nowPostCommentNumber");

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
