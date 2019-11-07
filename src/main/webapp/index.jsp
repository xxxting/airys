<%@ page language="java" contentType="text/html; charset=utf-8"
		import="util.Pager,java.util.List,entity.Account" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>列出账号</title>
<style type="text/css">
	div{
/* 	 width:500px;
	height:500px;  */
	/* border:1px solid black; */
		margin:auto;
	}
	table{
		 border:1px solid black; 
		 border-collapse:collapse;
	}
	th,td{
	 border:1px solid black; 
	}
	ul{
	width:165px;
	height:30px;
		margin:auto;
	}
	ul li{
		float:left;
		margin:0 5px;
	}
</style>

</head>
<body>
<%--  <%@指令名字  perperty=value2%> jsp指令 
		<%@ page%>  导包 
${acts} List<Account> acts = requset.getAttribute("acts");		
${act.id} act.getId()
引入标签库的步骤
	1. pom.xml 中引入相应的jstl.jar   jsp
	2. 在jsp页面中利用标签指令引入相应的标签
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	3. 使用相应的标签
	<c:foreach></c:foreach>
--%>
	<div>
		<h3 align="center">账号信息</h3>
		<table align="center">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>金额</th>
			</tr>
			<c:forEach items="${acts.data}" var="act">
				<tr>
						<td>${act.id}</td>				
						<td>${act.name}</td>				
						<td>${act.balance}</td>				
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>