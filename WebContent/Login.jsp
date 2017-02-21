<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>Ucycle ログイン画面</title>
	<link rel="SHORTCUT ICON" href="img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/Style.css">
	<link rel="stylesheet" type="text/css" href="css/Login.css">
	<script src="js/loginValidation.js"></script>

</head>

<body>

<header>
	<nav>
		<ul>
			<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
		</ul>
	</nav>
</header>

<main>

<aside class="left">
	<h4>ログイン</h4>
	<div class="form">
		<form action="LoginAction.action" method="post" name="myForm" onSubmit="validateForm()">
			<p id="emailValidation"></p>
			<input type="text" name="mailaddress" size="40" class="textField"
			pattern="^[0-9a-zA-Z]+[\w-]+@[\w\.-]+\.\w{2,}$" title="半角英数30文字以内でメールアドレスを入力してください"
			placeholder="メールアドレス:　　　30文字以内で入力" maxlength="30"/>
            <p id="passwordValidation"></p>
			<input type="password" name="password" size="40" class="textField"
			pattern="^[0-9A-Za-z]+$" title="半角英数字8文字以内でパスワードを入力してください"
			placeholder="パスワード:　　　8文字以内で入力"  maxlength="8"/>


			<input type="submit" value="ログイン"  class="submit_button" />

		</form>
	</div>
    <div class="link_wrap">
	    <ul>
		    <li><a href="GoUserPolicyAction" class="button_link">新規登録</a></li>
		    <li><a href="GoMainAction" class="button_link">メイン画面へ</a></li>
	    </ul>
    </div>

</aside>

<aside class="right">
	<h4>SNSアカウントでログイン</h4>
	<div class="social_login">

			<a href="GoTwitterAction"><img src="img/twitter_button.png" class="rws"/></a>
			<a href="GoogleOAuth"><img src="img/google_button.png"/></a>
			<a href="SignInServlet"><img src="img/facebook_button.png"/></a>

	</div>

</aside>


</main>

<footer class="footer">
	<p>&copy; 2015 Ucycle All Rights Reserved.</p>
</footer>

</body>
</html>