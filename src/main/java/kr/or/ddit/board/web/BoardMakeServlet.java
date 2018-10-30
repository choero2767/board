package kr.or.ddit.board.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.login.vo.UserVo;

@WebServlet(urlPatterns={"/boardInsert", "/boardUpdate","/boardMakerSend"})
public class BoardMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 uri로 로직 분기
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet => " +uri);

		//게시판 조회
		if(uri.equals("/boardInsert")){
			boardInsert(request, response);
		}else if(uri.equals("/boardUpdate")){
			boardUpdate(request, response);
		}else if(uri.equals("/boardMakerSend")){
			doGet(request, response);
		}
	}
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boardMakerSend(request, response);
	}



	private void boardInsert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
		
		
		//게시판 생성을 위한 boardService 받아오기
		BoardServiceInf boardService = BoardService.getInstance();
		
		String boardName = request.getParameter("boardName");
		//게시판 코드를 위한 service 이용
		int boardCode = boardService.getBoardCode()+1;
		String userId = userVo.getUserId();
		
		//게시판 생성을 위한 게시판 객체 생성 
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardCode(boardCode);
		boardVo.setBoardName(boardName);
		boardVo.setUserId(userId);
		
		int result = boardService.insertBoard(boardVo);
		
		System.out.println(result);
		

		List<BoardVo> boardList =  boardService.selectBoardList();
		
		request.getServletContext().setAttribute("boardList", boardList);
		
		response.sendRedirect("main.jsp");
		
		
	}
	
	private void boardMakerSend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BoardServiceInf boardService = BoardService.getInstance();
		List<BoardVo> boardListMake =  boardService.selectBoardListMake();
		request.setAttribute("boardListForBoardMaker", boardListMake);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/boardFree.jsp");
		rd.forward(request, response);
		
	}
	
	
	private void boardUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
		
		//로그인이 안되있을 경우
				if(userVo == null){
					response.setContentType("text/html; charset=utf-8");
					PrintWriter script = response.getWriter();

					script.println("<script>");
					script.println("alert('먼저 로그인을 해주세요.');");
					script.println("location.href = 'login.jsp';");
					script.println("</script>");
				}


				//권한이 없는 아이디 일 경우
				if(userVo.getRight() != 3){
					response.setContentType("text/html; charset=utf-8");
					PrintWriter script = response.getWriter();

					script.println("<script>");
					script.println("alert('해당 권한이 없는 아이디 입니다..');");
					script.println("location.href = 'main.jsp';");
					script.println("</script>");
				}
				
				String boardCode = request.getParameter("boardCode");
				String boardName = request.getParameter("boardName");
				String boardAvailable = request.getParameter("boardAvailable");
				
				BoardVo boardVo = new BoardVo();
				boardVo.setBoardCode(Integer.parseInt(boardCode));
				boardVo.setBoardName(boardName);
				boardVo.setBoardAvailable(Integer.parseInt(boardAvailable));
				
				BoardServiceInf boardService = BoardService.getInstance();
				
				int result = boardService.updateBoard(boardVo);
				
				if(result == -1){
					response.setContentType("text/html; charset=utf-8");
					PrintWriter script = response.getWriter();
					
					script.println("<script>");
					script.println("alert('DB에서 오류가 발생하였습니다');");
					script.println("location.href = 'main.jsp';");
					script.println("</script>");
					
				}else{
					
					List<BoardVo> boardList =  boardService.selectBoardList();
					
					request.getServletContext().setAttribute("boardList", boardList);
					
					response.setContentType("text/html; charset=utf-8");
					PrintWriter script = response.getWriter();
					
					script.println("<script>");
					script.println("alert('정상적으로 게시판 수정이 완료 되었습니다.');");
					script.println("location.href = 'main.jsp';");
					script.println("</script>");
				}
				
			}

}
