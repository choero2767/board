package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet(urlPatterns={"/boardPageList", "/boardDetail"})
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		
		//요청 uri로 로직 분기
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet => " +uri);
		
		//게시판 조회
		if(uri.equals("/boardPageList")){
			boardPageList(request, response);
		}else if(uri.equals("/boardDetail")){
			boardDetail(request, response);
		}
	}
	
	private void boardPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//사용자가 아이디가 파라미터로 넘어옴 

		String boardCode = request.getParameter("boardCode");
		String pageNumber = request.getParameter("pageNumber");
		String postRefer = request.getParameter("postRefer");
		
		//게시물에 대한 서비스 호출
		PostServiceInf postService = PostService.getInstance();
		List<PostVo> postList = postService.selectPostByPage(pageNumber, boardCode);
		
		//페이지 구하기
		Integer totalPage = postService.totalPageNumber(boardCode);
		request.setAttribute("totalPage", totalPage);
		
		//게시물 뽑아오기
		request.setAttribute("postList", postList);
		request.setAttribute("boardCode", boardCode);
		request.setAttribute("pageNumber", pageNumber);
		
		
		BoardServiceInf boardService = BoardService.getInstance();
		String boardName = boardService.getBoardName(Integer.parseInt(boardCode));
		
		//게시판 이름 받아오기
		request.setAttribute("boardName", boardName);
		
		//글쓰기에 필요한 보더코드
		request.setAttribute("boardCode", boardCode);
		request.setAttribute("postRefer", postRefer);
		
		//사용자 상세 화면으로 위임 
		RequestDispatcher rd = request.getRequestDispatcher("/board/board.jsp");
		rd.forward(request, response);
	}
	
	private void boardDetail(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		//게시물 코드가 파라미터로 넘어옴 
		String postCode = request.getParameter("postCode");
		
	}

}
