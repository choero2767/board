package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PostDao implements PostDaoInf{

private static PostDaoInf dao = null;
	
	private PostDao() {
	}
	
	public static PostDaoInf getInstance() {
		if(dao == null) {
			dao = new PostDao();
		}
		return dao;
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
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		Integer nowPostCode = session.selectOne("post.nowPostNumber");
		
		if(nowPostCode != null){
			return nowPostCode;
		}
		
		return -1;
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
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		int result = session.update("post.inquiryUp", postCode);
		session.commit();
		session.close();
		
		if(result != -1){
			return result;
		}
		
		return -1;
	}

	/**
	* Method : selectPostByPage
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 게시물 불러오기
	*/
	@Override
	public List<PostVo> selectPostByPage(PageVo pageVo) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		List<PostVo> postList = session.selectList("post.selectPostByPage", pageVo);
		
		if(postList != null){
			return postList;
		}
		
		return null;
	}
	
	
	/**
	* Method : selectPostByPage
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 코드를 가지고 게시물 불러오기
	*/
	@Override
	public PostVo selectPostByPostCode(String postCode) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try{
			PostVo postVo= session.selectOne("post.selectPostByPostCode", postCode);
			
			return postVo;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
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
	
	@Override
	public int insertPost(PostVo postVo){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try{
			System.out.println(postVo);
			int result = session.insert("post.insertPost", postVo);
			
			session.commit();
			session.close();
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return -1;
	}
	
	/**
	* Method : updatePost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 포스트 객체로 수정
	* 
	*/
	@Override
	public int updatePost(PostVo postVo){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try{
			System.out.println(postVo);
			int result = session.insert("post.updatePost", postVo);
			
			session.commit();
			session.close();
			
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return -1;
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
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try{
			System.out.println(postCode);
			int result = session.insert("post.deletePost", postCode);
			
			session.commit();
			session.close();
			
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return -1;
	}
	
	/**
	* Method : countPost
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 총 현재 게시물 수를 구한다
	*/
	@Override
	public Integer countPost(String boardCode){

		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();
		
		try{
			
			Integer count = session.selectOne("post.countPost", boardCode);
			
			return count;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return -1;
	}

}
