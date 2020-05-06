<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<script type="text/javascript">

	$(function() {
		
//---------------------------check All---------------------------//
	
		$("#result").on("click", "#checkAll", function() {
			$(".check").prop("checked", $(this).prop("checked"));
		});

//----------------------------check--------------------------------//

		$("#result").on("click", ".check", function() {
			var result = true;
			$(".check").each(function() {
				if(!$(this).prop("checked")){
					result = false;
				}
			});
			
			$("#checkAll").prop("checked", result);
			
		})

	
//--------------------------------------------------------------------//

//-----------------------------Delete--------------------------------//

		$("#result").on("click", "#del", function() {
		
			var ids = [];//빈 배열 생성
			$(".check").each(function() {
				if($(this).prop("checked")){
					//var id = $(this).attr("title");
					//alert($("#"+id).text());
					
					ids.push($(this).attr("id"));
					
				}
			});
			
			console.log(ids);
			//foreach 끝
			$.ajax({
				type:"get",
				traditional:true,
				url:"./memberDeletes",
				data: {
					ids:ids
				},
				success:function(data){
					$.get("./memberLists", function(data) {
						$("#result").html(data.trim());
					});
				}
				
			});
			
		
		});	

		
//----------------------------------------------------------------------//
		
		
		
		
		
	});
	
</script>



</head>
<body>
<c:import url="../template/header_sub.jsp"></c:import>

<div class="container">
  <div class="row">
	<h1>Member List</h1>      
	 <form class="form-inline" action="./memberList">
	 	<div class="input-group input-group-sm col-xs-2">
	    	<select class="form-control" id="sel1" name="kind">
			    <option value="mi">ID</option>
			    <option value="mn">Name</option>
			    <option value="mp">Phone</option>
			    <option value="me">Email</option>
  			</select>
  		</div>
	    <div class="input-group" style="margin: 0 auto;">
	      <input type="text" class="form-control" placeholder="Search" name="search">
	      <div class="input-group-btn">
	        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
	      </div>
	    </div>
	  </form>
  
  <div id = "result">
  	<table class = "table table-hover">
 	<thead> 
	     <tr>
	        <th>ID</th>
	        <th>NAME</th>
	        <th>AGE</th>
	        <th>PHONE</th>
	        <th>EMAIL</th>
	        <td> <input type="checkbox" id="checkAll"><button class="btn btn-danger" id="del">Delete</button></td>
	     </tr>
	 </thead>
	 <tbody>
		<c:forEach items="${list}" var="vo" varStatus="i">
		<tr>
			<td id ="id${i.index}">${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.age}</td>
			<td>${vo.phone}</td>
			<td>${vo.email}</td>	
			<td><input type="checkbox" name="del" title="id${i.index}" id="${vo.id}" class="check"></td>
		</tr> 
		</c:forEach>
	</tbody>
  </table>

  
	<div>
			<ul class="pagination">
			<c:if test="${pager.curBlock gt 1}">
			<li><a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock lt pager.totalBlock}">
			<li><a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
			</c:if>
			</ul>
	</div>
	
  </div>



  </div>
</div>

</body>
</html>