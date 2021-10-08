<%@page import="mypack.ThreadBean"%>
<%@page import="mypack.Thread"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="ThreadStyle.css" rel="stylesheet" media="all">
<title>PostThreadView3</title>
<!-- 未ログインがスレッド一覧（閲覧のみ）からスレッド内容を表示する際のページ -->

<%
request.setCharacterEncoding( "UTF-8" );
String threadtitle = request.getParameter("threadtitle"); //getAttributeで動作せず

Thread th = new Thread();
th.setThreadtitle(threadtitle);

ThreadBean threadBean = new ThreadBean();
threadBean.setThread(th);

threadBean.executeGetThread(threadBean.getThread());

List<Thread> threads = threadBean.getThreads();

int i = 1;

%>

</head>

<body>

<h1><a href="BeforeTop.html" id="Forum" style="text-decoration: none;">Forum</a></h1>
<h2>スレッド表示ページ</h2><br><br>
<p>スレッド名：<%= threadBean.getThread().getThreadtitle() %></p>


<div style="text-align:left">
<br>
<br>

<% for(Thread thread:threads){ %>

<table border="1">
	<tr>
		<th><% out.print(i); %> : <%= thread.getUsername() %></th>
		<td style="text-align:right"><%= thread.getPosteddate() %></td>
	</tr>

	<tr>
		<th>投稿内容:</th>
		<td width="600" height="100" style="white-space:pre-wrap;"><%= thread.getTexts() %></td>
	</tr>
</table>

<% i++; %>

<br>

<% } %>

<br>

<br>
<p>
<a href="#Forum">ページのトップへ戻る</a><br>
<a href="BeforeTop.html" style="text-align:center">掲示板TOPへ戻る</a><br>
<a href= "AllThreadsView2.jsp" style="text-align:center">スレッド一覧（閲覧のみ）</a><br><br>

現在未ログインのため閲覧のみ可能です<br>
新規アカウント作成は<a href= "CreateNewAccount.html" style="text-align:center">こちら</a><br>
ログインは<a href= "Login.html" style="text-align:center">こちら</a>

</p>
</div>


</body>
</html>