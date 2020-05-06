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
  <h2>Join form</h2>
  <form action="./memberJoin" method="post" enctype="multipart/form-data">
  
     <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
    </div>
  
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pw">
    </div>
    
    
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    
    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age" name="age">
    </div>
    
     <div class="form-group">
      <label for="num">Number:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
     <div class="form-group">
      <label for="Avatar">Avatar:</label>
      <input type="file" class="form-control" id="avatar" placeholder="Enter Avatar" name="avatar">
    </div>
    
    
    <button type="submit" class="btn btn-default">Submit</button>
    
  </form>
</div>

	<script type="text/javascript">
	
		$("#id").﻿blur(function() {
			var id = $(this).val();
			
			$.ajax({
				type: "post",	//method 형식 
				url : "./memberIdCheck",//URL 주소
				data: {
					id:id
				},	//parameter
				success : function(data){
					alert("가능한 아이디입니다");
				},
				error	: function() {
					alert("중복된 아이디입니다");
					
				}
				
			});

			
/* 			$.post("./memberIdCheck", {id:id}, function(data) {
				if(data=0){
					alert("중복입니다");
				}else{
					alert("가입가능한 아이디입니다");
				}
			}) */
		});
	
	
	</script>


</body>
</html>