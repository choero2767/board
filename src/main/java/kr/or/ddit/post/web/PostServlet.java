package kr.or.ddit.post.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.comment.service.CommentService;
import kr.or.ddit.comment.service.CommentServiceInf;
import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.login.vo.UserVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.util.model.PageVo;

@WebServlet("/postFree")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("클릭확인 doGet");
		//요청 uri로 로직 분기
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet => " +uri);
		
		//게시판 조회
		if(uri.equals("/postDetail")){
			postDetail(request, response);
		}else if(uri.equals("/postSend")){
			
			postSend(request, response);
			
		}else if(uri.equals("/postCommentInsert")){
			
			//post 메서드 방식으로 들어가있으니까 doPost로 전환해준다. 
			doPost(request, response);
		}else if(uri.equals("/postAnswerSend")){
			
			postAnswerSend(request, response);
		}else if(uri.equals("/postUpdateSend")){
			
			postUpdateSend(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		postCommentInsert(request, response);
	}



	private void postCommentInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String postCode = request.getParameter("postCode");
		String commentCon =  request.getParameter("commentCon");
		UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
		
		if(userVo == null){
			//세션에 아이디가 없는경우
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter script = response.getWriter();
			
			script.println("<script>");
			script.println("alert('먼저 로그인을 해주세요.');");
			script.println("location.href = 'login.jsp';");
			script.println("</script>");
		}
		
		//댓글 객체에 정보 집어 넣어주기
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentCon(commentCon);
		commentVo.setPostCode(Integer.parseInt(postCode));
		commentVo.setUserId(userVo.getUserId());
		
		CommentServiceInf commentService = CommentService.getInstance();
		int insertResult = commentService.insertPostComment(commentVo);
		
		
		if(insertResult == -1){
			//db에서 문제가 발생할 경우
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter script = response.getWriter();
			
			script.println("<script>");
			script.println("alert('댓글 달기에 실패하였습니다.');");
			script.println("location.href = 'main.jsp';");
			script.println("</script>");
			
		}
		
		//다시 게시물 조회 메서드를 통해 게시물로 돌아간다. 
		postDetail(request, response);
		
	}
	
	
	
	private void postDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시물 코드가 파라미터로 넘어옴 
		String postCode = request.getParameter("postCode");
		
		//게시물 코드로 게시물 객체를 받아온다.(postVO)
		PostServiceInf postSerivce = PostService.getInstance();
		
		PostVo postVo = postSerivce.selectPostByPostCode(postCode);
		System.out.println(postVo);
		if(postVo == null){
			//게시물이 없는경우
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter script = response.getWriter();
			
			script.println("<script>");
			script.println("alert('존재하는 게시물이 없습니다.');");
			script.println("location.href = 'main.jsp';");
			script.println("</script>");
			
			
		}else{
			//댓글에 대한 리스트
			CommentServiceInf commentService = CommentService.getInstance();
			List<CommentVo> commentList = commentService.selectPostCommentByPostCode(postCode);
			int result = postSerivce.inquiryUp(postCode);
			
			System.out.println(commentList);
			request.setAttribute("commentList", commentList);
			
			FileServiceInf fileService = FileService.getInstance();
			List<FileVo> fileList =  fileService.selectFilebyPostCode(postCode);
			System.out.println("fileList = "+fileList);
			request.setAttribute("fileList", fileList);
			
			
			//포스트 자체 정보에 대한 postVo
			request.setAttribute("postVo", postVo);
			RequestDispatcher rd = request.getRequestDispatcher("/postDetail.jsp");
			rd.forward(request, response);
			
		}

	}
	
	
	private void postSend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardCode = request.getParameter("boardCode");
		String postRefer = request.getParameter("postRefer");
		
		request.setAttribute("boardCode", boardCode);
		request.setAttribute("postRefer", postRefer);
		
		RequestDispatcher rd = request.getRequestDispatcher("/postWrite.jsp");
		rd.forward(request, response);
	}
	
	
	private void postAnswerSend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postRefer = request.getParameter("postRefer");
		
		//답글을 달기 위해 board code를 받아오기 
		PostServiceInf postService = PostService.getInstance();
		PostVo postVo =  postService.selectPostByPostCode(postRefer);
		
		request.setAttribute("boardCode", postVo.getBoardCode());
		request.setAttribute("postRefer", postRefer);
		
		RequestDispatcher rd = request.getRequestDispatcher("/postWrite.jsp");
		rd.forward(request, response);
	}
	
	
	private void postUpdateSend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postCode = request.getParameter("postCode");
		
		PostServiceInf postService = PostService.getInstance();
		PostVo postVo =  postService.selectPostByPostCode(postCode);
		
		request.setAttribute("postVo", postVo);
		request.setAttribute("postCode", postCode);
		
		RequestDispatcher rd = request.getRequestDispatcher("/postUpdateWrite.jsp");
		rd.forward(request, response);
	}

}
