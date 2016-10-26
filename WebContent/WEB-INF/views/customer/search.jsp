<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오늘 뭐 보지?</title>

	
	<table >
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="n" items="${list}">
				<tr>
					<td>${n.code}</td>
					<td><a href="notice-detail?code=${n.code}">${n.title}</a></td>
					<td>${n.writer}</td>
					<td><fmt:formatDate pattern="yyy-MM-dd" value="${n.regDate}"/></td>
					<td>${n.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${empty param.page}">
		<c:set var="_page" value="1"/>
	</c:if>
		
	<c:if test="${not empty param.page}">
		<c:set var="_page" value="${param.page}"/>
	</c:if>
		
 		<c:set var="start" value="${_page-(_page-1)%5}"/>
 		<c:set var="end" value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}"/>
	
	<div>
		<c:if test="${start+i <= end}">
			${_page}/${end} pages
		</c:if>
	</div>
	
	<div>
		<a href="notice-reg">글쓰기</a>
	</div>
	
	<div>
		<div><a href="notice?page=${(_page==1)?1:start-1}&type=${param.type}&query=${param.query}">이전</a></div>
		<ul>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${start+i <= end}">
					<c:if test="${_page==i+start}">
						<li><a href="notice?page=${i+start}&type=${param.type}&query=${param.query}" class=strong >${i+start}</a></li>
					</c:if>
					<c:if test="${_page!=i+start}">
						<li><a href="notice?page=${i+start}&type=${param.type}&query=${param.query}" >${i+start}</a></li>
					</c:if>
				</c:if>
			</c:forEach>
		</ul>
		<div><a href="notice?page=${start+5}&type=${param.type}&query=${param.query}">다음</a></div>
	</div>
</body>
</html>--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오늘 뭐 보지?</title>
</head>
<body>


	<h1><a href="/main">Movieb</a></h1>
	
	<h1>영화검색 메뉴</h1>
	<form action="movie" method="get">
		<fieldset>
			<select name="type">
				<option value="none">분류선택</option>
					
					<c:if test="${param.type=='TITLE'}">
						<option value="title" selected="selected">제목</option>
					</c:if>
					<c:if test="${param.type!='TITLE'}">
						<option value="title">제목</option>
					</c:if>
			</select>
			<legend>영화 검색</legend>
			<label>검색어</label>
			<input name="query" value="${param.query}"/>
			<button type="submit">검색</button>
		</fieldset>
	</form>
<!-- 영화검색  -->

<!-- 사용자계정 -->
	<h1>사용자계정 메뉴</h1>
	<div>
		<ul>
			<li><a href="">회원가입</a></li>
			<li><a href="">로그인</a></li>
			<li><a href="">마이페이지</a></li>
		</ul>
	</div>
<!-- 사용자계정 -->

<!---------------- //header ------------------>

<!---------------- body-aside ------------------>

	<form>
	<div>
		<ul>
			<li>
				<h1>장르별 영화</h1>
					<ul>
						<li><input type="checkbox" name="" value=""/>SF</li>
						<li><input type="checkbox" name="" value=""/>공포</li>
						<li><input type="checkbox" name="" value=""/>드라마</li>
						<li><input type="checkbox" name="" value=""/>로멘틱</li>
						<li><input type="checkbox" name="" value=""/>코미디</li>
						<li><input type="checkbox" name="" value=""/>가족</li>
						<li><input type="checkbox" name="" value=""/>다큐멘터리</li>
						<li><input type="checkbox" name="" value=""/>맬로</li>
						<li><input type="checkbox" name="" value=""/>범죄</li>
						<li><input type="checkbox" name="" value=""/>애니메이션</li>
						<li><input type="checkbox" name="" value=""/>액션</li>
						<li><input type="checkbox" name="" value=""/>전쟁</li>
						<li><input type="checkbox" name="" value=""/>판타지</li>
					</ul>
			</li>
			
			<li>
				<h1>개봉 연도별 영화</h1>
					<ul>
						<li><input type="checkbox" name="" value=""/>2016</li>
						<li><input type="checkbox" name="" value=""/>2015</li>
						<li><input type="checkbox" name="" value=""/>2014</li>
						<li><input type="checkbox" name="" value=""/>2013</li>
						<li><input type="checkbox" name="" value=""/>2012</li>
						<li><input type="checkbox" name="" value=""/>2011</li>
						<li><input type="checkbox" name="" value=""/>2010</li>
						<li><input type="checkbox" name="" value=""/>2009</li>
						<li><input type="checkbox" name="" value=""/>2008</li>
						<li><input type="checkbox" name="" value=""/>2007</li>
						<li><input type="checkbox" name="" value=""/>2006</li>
						<li><input type="checkbox" name="" value=""/>2005</li>
						<li><input type="checkbox" name="" value=""/>2004</li>
						<li><input type="checkbox" name="" value=""/>2003</li>
					</ul>
			</li>

			<li>
				<h1>국가별 영화</h1>
					<ul>
						<li><input type="checkbox" name="" value=""/>한국</li>
						<li><input type="checkbox" name="" value=""/>미국</li>
						<li><input type="checkbox" name="" value=""/>영국</li>
						<li><input type="checkbox" name="" value=""/>중국</li>
						<li><input type="checkbox" name="" value=""/>일본</li>
						<li><input type="checkbox" name="" value=""/>대만</li>
						<li><input type="checkbox" name="" value=""/>카자흐스탄</li>
					</ul>
			</li>
	
			<li>
				<h1>연령등급별 영화</h1>
					<ul>
						<li><input type="checkbox" name="" value=""/>청소년 관람불가</li>
						<li><input type="checkbox" name="" value=""/>15세 이상</li>
						<li><input type="checkbox" name="" value=""/>12세 이상</li>
						<li><input type="checkbox" name="" value=""/>7세 이상</li>
						<li><input type="checkbox" name="" value=""/>전체 이용가</li>			
					</ul>
			</li>
		</ul>
		
		<div>
			<h1>상영시간별 영화</h1>
			<dl>
				<dt></dt>
				<dd><input type="text" name="" value=""/></dd>
			</dl>
			<div>
				<button type="submit" class="btn_search">검색하기</button>
			</div>
		</div>	
	</div>
	</form>

<!---------------- //body-aside ------------------>	

<!---------------- body-main ------------------>	
	<h1>검색결과 항목선택</h1>
	<table border="1">
		<tbody>
			<tr>
				<th>결과</th>
				<td>--선택 컬럼을 넣자--<a href="">선택취소</a></td>
			</tr>
		</tbody>
	</table>
	
<!-- 검색 결과 바 -->
	<h1>검색결과 정렬</h1>
		<div>
			<p>당신이 원하는 영화가 <strong>1,153</strong>개 있습니다.</p>
				<div>
					<select>
						<option value="">상영시간순 정렬</option>
						<option value="">가나다순 정렬</option>
						<option value="">정확도순 정렬</option>
					</select>
				</div>
		</div>
	
	<h1>검색결과 </h1>
		<ul>
			<li><a href=""><img src="" alt=""/></a>
			<li><a href=""><img src="" alt=""/></a>
		</ul>
<!-- 검색 결과 바 -->	

	<h1>페이징</h1>
	<c:if test="${empty param.page}">
		<c:set var="_page" value="1"/>
	</c:if>
		
	<c:if test="${not empty param.page}">
		<c:set var="_page" value="${param.page}"/>
	</c:if>
		
 		<c:set var="start" value="${_page-(_page-1)%5}"/>
 		<c:set var="end" value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}"/>
	
	<div>
		<c:if test="${start+i <= end}">
			${_page}/${end} pages
		</c:if>
	</div>
	
	
	<div>
		<div><a href="notice?page=${(_page==1)?1:start-1}&type=${param.type}&query=${param.query}">이전</a></div>
		<ul>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${start+i <= end}">
					<c:if test="${_page==i+start}">
						<li><a href="notice?page=${i+start}&type=${param.type}&query=${param.query}" class=strong >${i+start}</a></li>
					</c:if>
					<c:if test="${_page!=i+start}">
						<li><a href="notice?page=${i+start}&type=${param.type}&query=${param.query}" >${i+start}</a></li>
					</c:if>
				</c:if>
			</c:forEach>
		</ul>
		<div><a href="notice?page=${start+5}&type=${param.type}&query=${param.query}">다음</a></div>
	</div>
					
<!---------------- //body-main ------------------>	

<!---------------- footer ------------------>	

<!---------------- footer ------------------>	
</body>
</html>
