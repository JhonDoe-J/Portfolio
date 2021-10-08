<%@page import="mypack.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="ThreadStyle.css" rel="stylesheet" media="all">
<title>LoggedinView</title>

<%
request.setCharacterEncoding( "UTF-8" );
UserBean userBean = (UserBean)request.getAttribute("userBean");

%>

</head>
<body>

<h1><a href="Top.html" id="Forum" style="text-decoration: none;">Forum</a></h1>
<h2>ログイン完了ページ</h2>

<h3>
<%= userBean.getUser().getYuuzaamei() %>でログイン中
<button onclick="location.href='LogoutServletController'">ログアウト</button>
</h3><br><br>

<p>ユーザ名：<%= userBean.getUser().getYuuzaamei() %>でログインしました</p><br><br>

<a href="Top.jsp" style="text-align:center">掲示板TOPへ戻る</a><br><br>
<a href= "CreateNewThread.jsp" style="text-align:center">新規スレッド作成</a><br><br>
<a href= "AllThreadsView.jsp" style="text-align:center">スレッド一覧</a><br><br>

</body>
</html>