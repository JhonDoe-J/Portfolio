<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Exception exception = (Exception)request.getAttribute("exception");
%>
<html>
<head>
<meta charset="UTF-8">
<title>ErrorPage</title>
</head>
<body>
■エラー<br>
<%= exception %>
<% exception.printStackTrace(); %>
<br><br>

<a href="BeforeTop.html" style="text-align:center">掲示板TOPへ戻る</a><br>
<a href= "AllThreadsView2.jsp" style="text-align:center">スレッド一覧</a>

</body>
</html>
