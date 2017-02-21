<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ucycle - 予約完了画面</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/ReservationComplete.css">
</head>
<body>
<body>
	<header>
		<nav>
			<ul>
				<li class="project_title"><a href="Main.jsp">Ucycle</a></li>
			</ul>
		</nav>
	</header>
	<section class="contents">
	<div class="background">
    <div class="contents_inner">
      <p>
	ご予約ありがとうございます。
	<br>
	<br>
	当ページをスクリーンショットで保存いただくか、
	<br>
	下記の自転車IDを控えて駐輪場にお越しくださいませ。
	</p>
	<table class="tabledesign">
	<tr>
	<th>自転車ID</th>
	</tr>
	<tr>
	<td>
	<s:property value="#session.cycleId"/>
	</td>
	</tr>
	</table>
	<br>
	<br>
	<br>
	<input type="submit" value="トップへ" onclick="location.href='GoMainAction'" />
    </div>
    </div>
	</section>
	
</body>
<footer>
		<br> &copy; 2015 Ucycle All Rights Reserved.
	</footer>
</html>