<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ucycle - Withdraw</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Withdraw.css">
</head>
<body>
	<div class="taikai" align="center">
		<header>
			<nav>
				<ul>
					<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
				</ul>
			</nav>
		</header>
		<br> <br>
		<div class="taikai_wrap" align="center">
			<section class="contents">
				<div class="background">
					<div class="contents_inner">
						<p>
							Ucycleをご利用頂き、真にありがとうございます。 <br> Passwordを入力し、退会に進んで下さい。
						</p>
						<font size="2" color="red"><br> <s:property
								value="errormsg" /></font>

						<s:form action="WithdrawCompleteAction" theme="simple">
							<table class="tabledesign">
								<tr>
									<th class="item">E-mail</th>
									<td><s:property value="#session.mailaddress" /> <input
										type="hidden" name="mailaddress"
										value="<s:property value="#session.mailaddress" />"></td>
								</tr>
								<tr>
									<th class="item">Password</th>
									<td><input type="password" size="50" maxlength="8"
										name="password" placeholder="例)yamada123"
										pattern="[0-9a-z]{4,32}" autofocus required></td>
								</tr>
							</table>
							<br>
							<div id="btn">
								<ul>
									<li><input type="submit" value="退会"></li>
									<li><input type="button" value="キャンセル"
										onclick="location.href='GoMypageAction'"></li>
								</ul>
							</div>
						</s:form>
					</div>
				</div>
			</section>
			<br>
		</div>
		<br> <br>
	</div>
	<footer>
		<br> &copy; 2015 Ucycle All Rights Reserved.
	</footer>
</body>
</html>