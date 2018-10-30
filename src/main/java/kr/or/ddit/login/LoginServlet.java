package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.login.service.LoginService;
import kr.or.ddit.login.service.LoginServiceInf;
import kr.or.ddit.login.vo.UserVo;

@WebServlet("/dditLogin")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8"); 
		PrintWriter pw = resp.getWriter();
		
		String[] useridValues = req.getParameterValues("user_id");
		String userpw = req.getParameter("user_pw");
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>loginServlet.java</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		for(int i=0;i<useridValues.length;i++){
			pw.print("		userid : "+useridValues[i] + "<br>");
		}
		pw.println("		userpw : "+userpw);
		pw.println("	</body>");
		pw.println("</html>");
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter pw = resp.getWriter();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.println(userId);
		
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setPassword(password);
		LoginServiceInf loginService = LoginService.getInstance();
		
		UserVo userVo2 = loginService.selectUserByIdAndPassword(userVo);
		System.out.println(userVo2.getName()+"==jhjkkjhkj");
		
		if(userVo != null){
			
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			
			BoardServiceInf boardService = BoardService.getInstance();
			List<BoardVo> boardList =  boardService.selectBoardList();
			
			request.getServletContext().setAttribute("boardList", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
			
//		}else{
//			
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			rd.forward(request, response);
//		}
		
	}

}
