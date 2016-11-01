<%@page import="com.movieb.web.dao.mybatis.MyBatisReviewDao"%>
<%@page import="com.movieb.web.entities.Review"%>
<%@page import="com.movieb.web.dao.ReviewDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%    

/*    String _code = request.getParameter("code");

	
	NoticeDao noticeDao= new MybatisNoticeDao();
	Notice notice = noticeDao.get(_code);  
   
   pageContext.setAttribute("n", notice);//--->${n.컬럼}  or   ${n["컬럼"]}
 */
   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>
		<a href="">리뷰상세</a>
	</h1>
	<ul>
		<li><a href="../index.jsp">home</a>
		<li>
		<li><a href="review">리뷰</a>
		<li>
	</ul>
	<table border=1>
		<tbody>

			<tr>
				<td>제목</td>
				<td colspan="3">${n.title}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3">
				<fmt:formatDate pattern="yy.MM.dd hh:mm" value="${n.regDate}"/>
				</td>

			</tr>
				<tr>
				<td>영화제목</td>
				<td colspan="3">${n.movie_title}</td>

			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.writer}</td>
				<td>조회수</td>
				<td>${n.hit}</td>
			</tr>
		
			<tr>
				<td colspan="4">${n.content}</td>

			</tr>

		</tbody>
	</table>
	<div>		
		<c:if test="${empty prev}">이전글이 없습니다.</c:if>
		<c:if test="${!empty prev}"><a href="review-detail?code=${prev.code}">이전글 : ${prev.title}</a></c:if>
	</div>
	<div>
		<c:if test="${empty next}">다음글이 없습니다.</c:if>
		<c:if test="${!empty next}"><a href="review-detail?code=${next.code}">다음글 : ${next.title}</a></c:if>
	</div>
	
	<div>
	
		<ul>
			<li><a href="review=${param.p}">목록</a></li>
			<li><a href="review-edit?code=${n.code}">수정</a></li>
			<li><a href="review-del?code=${n.code}">삭제</a></li>
		</ul>
	</div>
</body>
</html>