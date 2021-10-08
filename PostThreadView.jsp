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
<title>PostThreadView</title>
<!-- スレッドへの投稿後該当スレッドの内容を表示するページ -->

<%
request.setCharacterEncoding( "UTF-8" );//日本語文字化け防止

//受け取ったthreadBeanに格納されている値でスレッド内容取得メソッドを実行
ThreadBean threadBean = (ThreadBean)request.getAttribute("threadBean");
threadBean.executeGetThread(threadBean.getThread());
List<Thread> threads = threadBean.getThreads();
String yuuzaamei = (String)session.getAttribute("yuuzaamei");

//スレッド毎の投稿内容に通し番号を付けるための変数
int i = 1;

%>

</head>
<body>

<h1><a href="Top.html" id="Forum" style="text-decoration: none;">Forum</a></h1>
<h2>スレッド表示ページ</h2><br>

<h3>
<%= yuuzaamei %>でログイン中
<button onclick="location.href='LogoutServletController'">ログアウト</button>
</h3><br><br>

<p>スレッド名：<%= threadBean.getThread().getThreadtitle() %></p>
<div style="text-align:left">
<br>
<br>

<!-- List<Thread>型変数の中身を拡張forで走査→表示 -->
<% for(Thread thread:threads){ %>

<table class="viewTable" border="1">
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

<!--当該スレッドへの投稿ボタン、ボタン押下で当該スレッド名を投稿ページへ値渡し  -->
<form action="PostThread.jsp" method="post">

<button name="threadtitle" value="<%= threadBean.getThread().getThreadtitle() %>">投稿</button>

</form>

<p>
<a href="#Forum">ページのトップへ戻る</a><br>
<a href="Top.jsp" style="text-align:center">掲示板TOPへ戻る</a><br>
<a href= "AllThreadsView.jsp" style="text-align:center">スレッド一覧</a>
</p>

</div>


</body>
</html>