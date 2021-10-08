<%@page import="mypack.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="ThreadStyle.css" rel="stylesheet" media="all">

<title>ログイン済みユーザTOP</title>
<!-- ログイン済みユーザトップページ -->

<%
request.setCharacterEncoding( "UTF-8" );
//UserBean userBean = (UserBean)request.getAttribute("userBean");
String yuuzaamei = (String)session.getAttribute("yuuzaamei");

%>

</head>
<body>

<h1>Forum</h1>
<h2>ログイン済みユーザトップページ</h2>

<h3>
<%= yuuzaamei %>でログイン中
<button onclick="location.href='LogoutServletController.java'">ログアウト</button>
</h3><br><br>

<br><br><br>

<a href= "CreateNewThread.jsp" style="text-align:center">新規スレッド作成</a><br><br>
<a href= "AllThreadsView.jsp" style="text-align:center">スレッド一覧</a>


</body>
</html>