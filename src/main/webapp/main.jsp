<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/common/lib.jsp"%>
<body>
	<%@ include file="/common/nav.jsp"%>
	<%@ include file="/common/left.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">JSP 게시판 과제</h1>

		<div class="row placeholders">
			<div class="col-xs-6 col-sm-3 placeholder">
				<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
					alt="Generic placeholder thumbnail">
				<h4>Label</h4>
				<span class="text-muted">203호 JSP 게시판 과제</span>
			</div>
		</div>

		<div class="blog-post">
			<h2 class="blog-post-title">JSP</h2>
			<p class="blog-post-meta">2017.10.30, room 203</p>

			<p>jsp를 통한 웹 프로그래밍 학습</p>
			<hr>

			<h3>상세내역</h3>
			<p>JSP과정에서는 다음과 같은 내용을 학습한다.</p>
			<ul>
				<li>servlet 동작원리</li>
				<li>jsp와 servlet의 관계</li>
				<li>jsp 스크립틀릿 요소</li>
				<li>jsp action tag (standard)</li>
				<li>jstl</li>
				<li>db pooling</li>
				<li>페이지 모듈화</li>
			</ul>
		</div>
	</div>
</body>
</html>
