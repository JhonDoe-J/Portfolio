<%@page import="java.util.List"%>
<%@page import="mypack.ThreadBean"%>
<%@page import="mypack.Thread"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="ThreadStyle.css" rel="stylesheet" media="all">
<title>AllThreadsView</title>
<!-- スレッド一覧表示ページ  -->

<%

//スレッド一覧表示メソッド実行
//テーブルのthreadtitleカラムをList<String>型で取得
ThreadBean threadBean = new ThreadBean();
List<String> allthreadtitles = threadBean.executeGetAllThreads();
String yuuzaamei = (String)session.getAttribute("yuuzaamei");

%>

</head>
<body>

<h1><a href="Top.jsp" id="Forum" style="text-decoration: none;">Forum</a></h1>
<h2>スレッド一覧ページ</h2><br>

<h3>
<%= yuuzaamei %>でログイン中
<button onclick="location.href='LogoutServletController'">ログアウト</button>
</h3><br><br>

<div>
<br>
<!--  List<String>型で返ってきたスレッド一覧を拡張forで全て表示 -->
<% for(String threadtitle : allthreadtitles){ %>

<form action="PostThreadView2.jsp" method="post">

<p>
<%= threadtitle%>
<button name="threadtitle" value="<%= threadtitle%>">閲覧</button>
</p>

</form>

<%; %>
<br>

<% } %>

<p>
<a href="#Forum">ページのトップへ戻る</a><br>
<a href="javascript:history.back()">前の画面に戻る</a><br>
<a href="Top.jsp" style="text-align:center">掲示板TOPへ戻る</a><br>
</p>

</div>

</body>
</html>