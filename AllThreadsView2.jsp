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
<title>AllThreadsView2</title>
<!-- 未ログインユーザ用のスレッド一覧を表示するページ
	 未ログインの為スレッド閲覧を選択しても内容の表示のみ可能な
	 PostThreadView3.jspへ遷移する -->

<%

//スレッド一覧表示メソッド実行
//テーブルのthreadtitleカラムをList<String>型で取得
ThreadBean threadBean = new ThreadBean();
List<String> allthreadtitles = threadBean.executeGetAllThreads();

%>

</head>
<body>

<h1><a href= "BeforeTop.html" style="text-decoration: none;">Forum</a></h1>
<h2>スレッド一覧ページ</h2><br><br><br>

<br>
<!--  List<String>型で返ってきたスレッド一覧を拡張forで全て表示 -->
<% for(String threadtitle : allthreadtitles){ %>

<form action="PostThreadView3.jsp" method="post">

<ul>
<li><%= threadtitle%>
<button name="threadtitle" value="<%= threadtitle%>">閲覧</button>
</li>
</ul>

</form>

<%; %>

<% } %>

<p>
<a href="#Forum">ページのトップへ戻る</a><br>
<a href="BeforeTop.html" style="text-align:center">掲示板TOPへ戻る</a><br>
</p>

</body>
</html>