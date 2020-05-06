<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
</head>

<body>
<c:import url="../template/header_sub.jsp"></c:import>

	<div class="container">
		<h1>${fn:toUpperCase(board)} Update Form</h1>
	
		<form action="./${board}Update" id="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${vo.num}">
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="text" value="${vo.title}" class="form-control" id="title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="writer">Writer:</label>
		    <input type="text" disabled="disabled" value="${vo.writer}" class="form-control" id="writer" name="writer">
		  </div>
		 <div class="form-group" >
		    <label for="contents">Contents:</label>
		    <textarea rows="20" cols="" class="form-control" id="contents" name="contents">${vo.contents}</textarea>
		  </div> 
		  
		  <input type="button" id="add" class="btn btn-info" value="AddFile" >
		  
		  <div id="file">
		  
		  </div>
		  
		  <div class="form-group">
		     <label for="files">Files:</label>
		     <c:forEach items="${vo.boardFileVOs}" var="fileVO">
		     	<p>${fileVO.oriName}<i class="glyphicon glyphicon-remove remove fileDelete" id="${fileVO.fileNum}" title="${fileVO.board}"></i></p>
		     </c:forEach>
		  </div>

		  <input type="submit" id="btn" class="btn btn-default" value="Write">
		</form>
		
		
		
	</div>

	
 	<script type="text/javascript" src="../resources/js/boardForm.js">
		
		
		
	</script> 

	<script type="text/javascript" >
		
		$("#contents").summernote('code', '${vo.contents}');
		
		/* 파일갯수 가져오기 */
		/* 1. 컨트롤러에서 사이즈 받아오기 */
		var size = ${size};
		/* 2. EL로 VOs에서 직접 사이즈 가져오기 */
		/* getter가 없는 메서드들은 뒤에 소괄호()를 붙여줘야함. */
		size = ${vo.boardFileVOs.size()};
		/* 3. fn함수 중에 length 이용 */
		size = ${fn:length(vo.boardFileVOs)};
		
		var result = result+size;
		
		
		
		$(".fileDelete").click(function() {
			
			var check = confirm("정말 지우시겠습니까?");
			alert(check);
			
 			/* var fileNum = $(".fileDelete").attr("id"); */
 
			  if(check){
				
				var s = $(this);
			
				$.post("../boardFile/fileDelete", {fileNum:$(this).attr("id"), board:$(this).attr("title")}, function(data) {
					
					if(data.trim()>0){
						alert("File Delete Success");
						s.parent().remove();
						result--;
					}else{
						alert("File Delete Fail");
					}
				
			});
		}   
	});
		
	</script>
	


</body>
</html>