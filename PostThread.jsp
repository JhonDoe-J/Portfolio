<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="ThreadStyle.css" rel="stylesheet" media="all">
<title>PostThread</title>

<%
request.setCharacterEncoding( "UTF-8" );
String threadtitle = request.getParameter("threadtitle");
//"threadtitle"をkeyとして選択されているスレッド名を取得

String yuuzaamei = (String)session.getAttribute("yuuzaamei");

%>

</head>
<body>

<h1>Forum</h1>
<h2>スレッドへの投稿ページ</h2>

<h3>
<%= yuuzaamei %>でログイン中
<button onclick="location.href='LogoutServletController'">ログアウト</button>
</h3><br><br><br>

スレッド名：<%= threadtitle %>
<br>
<br>

<!-- 入力された内容を現在のスレッド名と共にスレッド作成サーブレットに渡す -->
<form action="CreateThreadServletController" method="post">
<p>
ユーザ名を入力してください（最大20文字）
<br>
<input type="text" name="username" size=20 maxlength=20 placeholder="名無し" value="<%= yuuzaamei %>"/>
<br>
<br>

投稿内容を入力してください（最大500文字）<br>
<textarea rows="10" cols="50" name="texts" wrap="hard" required></textarea>
<br>
<br>

<button name="threadtitle" value="<%= threadtitle%>">投稿</button>
<br>
<br>
</p>

</form>

<a href="Top.jsp" style="text-align:center">掲示板TOPへ戻る</a><br>
<a href= "AllThreadsView.jsp" style="text-align:center">スレッド一覧</a>

</body>
</html>