<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="css/text" href="css/LoginAdmin.css">
<title>管理者ログイン画面</title>
</head>
<body>
<br>
					<br><br>
					<br><br>
					<br>
	<div align="center">
		<strong>管理者ログイン画面</strong> <br> <br>
		<div class="form">
			<div align="center">
				<s:form action="LoginAdminAction">
			管理者ID：<input type="text" name="name" class="name" autofocus required>
					<br>
					<br>
			password：<input type="password" name="password" class="password"
						required>
					<s:submit value="ログイン" class="button" />
				</s:form>
				<br>
					<br>
				<input type="button" onclick="location.href='ItemAllAction'"
					value="戻る">
			</div>
		</div>
		</div>
</body>
</html>