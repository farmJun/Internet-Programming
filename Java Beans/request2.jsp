<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ppt 9</title>
</head>
<body>
<%
 	request.setCharacterEncoding("UTF-8");
 %>
 
 <%
 String studentNum=request.getParameter("studentNum");
 String[] majors=request.getParameterValues("major");
 %>
 
 <h2>학생 정보 입력 결과</h2>
 학번 : <%=studentNum %>
 전공 : <%
 	if(majors==null){
 		out.println("전공 없음");
 	}
 	else{
 		for(int i=0;i<majors.length;i++){
 			out.println(majors[i]+" ");
 		}
 	}
 
 
 %> 
 
 
 <h2>요청 정보</h2>
 
 요청 방식 : <%= request.getMethod() %><p>
 요청 URL : <%= request.getRequestURL() %><p>
 요청 URI : <%= request.getRequestURI() %><p>	

 
</body>
</html>