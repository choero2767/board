<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 입니다.</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-left">
				<c:choose>
					<c:when test="${boardList!=null}">
						<c:forEach items="${boardList}" var="board">
							<c:choose>
								<c:when test="${userVo.right == 1}">
									<li><a href="boardPageList?boardCode=${board.boardCode}&pageNumber=1">${board.boardName}</a></li>
								</c:when>
								<c:when test="${userVo.right == 3}">
									<li><a href="boardPageList?boardCode=${board.boardCode}&pageNumber=1">${board.boardName}</a></li>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				<c:if test="${userVo.right == 3}">
					<li><a href="/boardMakerSend">게시판 생성</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"
				role="button" aria-haspopup="true" aria-expanded="false">
				접속하기
				<span class="caret"></span>
				<ul class="dropdown-menu">
					<li class="active"><a href="login.jsp">로그인</a></li>
				</ul>
				</a>
			</li>			
		</ul>
		</div>
	</div>
</nav>


