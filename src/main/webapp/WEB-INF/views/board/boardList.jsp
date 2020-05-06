<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header_sub.jsp"></c:import>

<div class="container">
  <div class="row">
	<h1>${board} List</h1>      
	 <form action="./${board}List" class="form-inline">
	 	<div class="input-group input-group-sm col-xs-2">
	    	<select class="form-control" id="sel1" name="kind">
			    <option value="bt">Title</option>
			    <option value="bc">Contents</option>
			    <option value="bw">Writer</option>
  			</select>
  		</div>
	    <div class="input-group input-group-sm col-xs-4">
	    
	      <input type="text" class="form-control" placeholder="Search" name="search">
	      <div class="input-group-btn">
	        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
	      </div>
	    </div>
	  </form>
  
  	<table class = "table table-hover">
 	<thead> 
	     <tr>
	        <th>NUM</th>
	        <th>TITLE</th>
	        <th>WRITER</th>
	        <th>REGDATE</th>
	        <th>HIT</th>
	     </tr>
	 </thead>
	 <tbody>
		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.num}</td>
			<td>
			
			<c:catch>	<!-- try/catch와 같은것 -->
			<!-- for(int i=0;i<=0;i++) -->
			<c:forEach begin="1" end="${vo.depth}">
				--
				<!-- &nbsp;&nbsp; -->
			</c:forEach>
			</c:catch>
			<a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
			<td>${vo.writer}</td>
			<td>${vo.regDate}</td>
			<td>${vo.hit}</td>	
		</tr> 
		</c:forEach>
	</tbody>
  </table>
  </div>
  
  <div style="margin: 0 auto;">
  	<ul class="pagination">	
  	
  	<c:if test="${pager.curBlock gt 1}">
		    <li><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
	</c:if>	 
		
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    <li><a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
 	 </c:forEach>
 	 
 	 <c:if test="${pager.curBlock lt pager.totalBlock}">
		    <li><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
	</c:if>
	
	</ul>
	
  </div>
  
  		<a href="./${board}Write" class="btn btn-danger">WRITE</a>
  
  
  <c:catch>
  <c:choose>
  	<c:when test="${board eq 'notice'}">
  		<c:if test="${member.id eq 'admin'}">
  		
  				<a href="./${board}Write" class="btn btn-danger">WRITE</a>
  		
  		</c:if>
  	</c:when>
  	<c:otherwise>
  		<c:if test="${not empty member}">
  		 
  				<a href="./${board}Write" class="btn btn-danger">WRITE</a>
  		
  		</c:if>
  	</c:otherwise>
  
  </c:choose>
  </c:catch>
  
  
  
  <!-- 내가 한 방식 -->
<%--   <c:if test="${not empty member}">
  <div>
  	<c:if test="${member.id eq 'admin' && board eq 'notice'}">
  	<a href="./${board}Write" class="btn btn-danger">WRITE</a>
  	</c:if>
  	<c:if test="${board eq 'qna'}">
  	<a href="./${board}Write" class="btn btn-danger">WRITE</a>
  	</c:if>
  </div>
  </c:if> --%>
  
</div>

</body>
</html>