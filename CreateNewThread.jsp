<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link href="ThreadStyle.css" rel="stylesheet" media="all">
<title>CreateNewThread</title>
<!-- ユーザの入力情報を取得し、スレッド作成サーブレットに渡す -->

<% String yuuzaamei = (String)session.getAttribute("yuuzaamei"); %>

</head>
<body>

<h1><a href="Top.html" style="text-decoration: none;">Forum</a></h1>
<h2>新規スレッド作成ページ</h2><br><br><br>

<h3>
<%= yuuzaamei %>でログイン中
<button onclick="location.href='LogoutServletController'">ログアウト</button>
</h3><br><br>

<form action="CreateThreadServletController" method="post">

<p>スレッド名を入力してください（最大40文字）<br>
<input type="text" name="threadtitle" size=40 maxlength=40 required/><br><br>

ユーザ名を入力してください（最大20文字）<br>
<input type="text" name="username" size=20 maxlength=20 placeholder="名無し" value="<%= yuuzaamei %>"/><br><br>

投稿内容を入力してください（最大500文字）<br>
<textarea rows="10" cols="50" name="texts" required></textarea><br><br>

<input type="submit" value="スレッド作成"><br><br>
</p>
</form>

<a href="Top.jsp" style="text-align:center">掲示板TOPへ戻る</a><br>
<a href= "AllThreadsView.jsp" style="text-align:center">スレッド一覧</a>

</body>
</html>