<%@page import="kr.or.ddit.login.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<c:choose>
			<c:when test="${userVo.userId != null }">
				<li class="active"><a href="/boardMakerSend">게시판 생성</a></li>
				<c:forEach items="${boardList }" var="vo">
						<li class="active"><a href="/boardPageList?pageNumber=1&pageSize=10&boardCode=${vo.boardCode}">${vo.boardName }</a></li>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<li class="active"><a href="#>">게시판 생성</a></li>
			</c:otherwise>
		</c:choose>
		
		
	</ul>
</div>