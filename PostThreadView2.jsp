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
<title>PostThreadView2</title>
<!-- スレッド一覧からスレッド内容を表示する際のページ
	 受け取る情報がスレッド名のみのため、PostThreadViewとは別に作成-->

<%
request.setCharacterEncoding( "UTF-8" );
String threadtitle = request.getParameter("threadtitle");

Thread th = new Thread();
th.setThreadtitle(threadtitle);

ThreadBean threadBean = new ThreadBean();
threadBean.setThread(th);

threadBean.executeGetThread(threadBean.getThread());

List<Thread> threads = threadBean.getThreads();

String yuuzaamei = (String)session.getAttribute("yuuzaamei");

int i = 1;

%>

</head>

<body>

<h1><a href="Top.html" id="Forum" style="text-decoration: none;">Forum</a></h1>
<h2>スレッド表示ページ</h2><br><br>

<h3>
<%= yuuzaamei %>でログイン中
<button onclick="location.href='LogoutServletController'">ログアウト</button>
</h3><br><br>

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

<form action="PostThread.jsp" method="post">

<button name="threadtitle" value="<%= threadBean.getThread().getThreadtitle() %>">投稿</button>

<br>

</form>

<br>
<p>
<a href="#Forum">ページのトップへ戻る</a><br>
<a href="Top.jsp" style="text-align:center">掲示板TOPへ戻る</a><br>
<a href= "AllThreadsView.jsp" style="text-align:center">スレッド一覧</a>
</p>
</div>


</body>
</html>