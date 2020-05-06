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
  <h2>My Page</h2>          
  <table class="table">
    <thead>
      <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
        <td>Phone</td>
        <td>Email</td>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${member.id}</td>
        <td>${member.name}</td>
        <td>${member.age}</td>
        <td>${member.phone}</td>
        <td>${member.email}</td>
        <h1>
        <div>
        <img alt="" src="../resources/memberUpload/${member.memberFileVO.fileName}"></h1>
        <a href="./fileDelete">File Delete</a>
        </div>
        <img alt="" src="">
      </tr>
      
  </table>
  
		  <button class="btn btn-primary" id="up">Update</button>
		  <button class="btn btn-danger" id="del">Delete</button>
</div>

	<script type="text/javascript">
		$("#up").click(function() {
			location.href="./memberUpdate";
		})
	
	
		$("#del").click(function() {
			var result	= confirm("탈퇴 하시겠습니까?");
			if(result){
			location.href="./memberDelete";
			}
		})
	
	</script>

</body>
</html>