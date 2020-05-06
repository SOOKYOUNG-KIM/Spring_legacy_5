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
	<h1>Member Update</h1>
  <form class="form-horizontal" action="./memberUpdate" method="post">
   <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="pwd">PassWord:</label>
      <input type="password" class="form-control" id="pw" name="pw" value="${member.pw}">
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" value="${member.name}">
    </div>
    
     <div class="form-group">
      <label for="num">Age:</label>
      <input type="text" class="form-control" id="age" name="age" value="${member.age}">
    </div>
    
    <div class="form-group">
      <label for="num">Phone:</label>
      <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}">
    </div>

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" name="email" value="${member.email}">
    </div>
    
    <h1>${member.memberFileVO.oriName}</h1>
    
    <div class="form-group">
      <label for="avatar">Avatar:</label>
      <input type="file" class="form-control" id="avatar" name="avatar">
       
        
    </div>
    
    
   
        <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>