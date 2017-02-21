<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ucycle - 利用履歴画面</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/History.css">
</head>
<body>
<header>
		<nav>
			<ul>
				<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
			</ul>
		</nav>
</header>
<body>
<br>
<h1 class="rireki">利用履歴</h1>
<br><br>
<s:property value="#session.customerId" />
<s:property value="#session.portId" />
<s:property value="#session.cycleId" />


<table border="1">
<tr>
<th>利用日時</th><th>駐輪場</th><th>自転車</th><th>プラン</th><th>金額</th>
</tr>

<tr>
<td><s:property value="#session.reservationDate" /></td>
<td><s:property value="#session.portId" /></td>
<td><s:property value="#session.cycleId" /></td>
<td><s:property value="#session.plan" /></td>


</tr>
<tr>
<td><s:property value="#session.reservationDate" /></td><td><s:property value="#session.plan" /></td><td>○○円</td>
</tr>
<tr>
<td><s:property value="#session.reservationDate" /></td><td><s:property value="#session.plan" /></td><td>○○円</td>
</tr>
</table>
<br>
<table border="1">
<tr>
<th>合計</th><td>○○円</td>
</tr>
</table>
<br>
<div class="pay">
今月の請求額
<br>
<br><br>
<h1 class="kane">20,000,000,000</h1>円
<br>
</div>
<br><br><br><br><br><br><br>
<div class="button">
<input class="button" type="submit" value="マイページへ"/>
</div>
<br><br><br><br>
<footer>
		<br>&copy; 2015 Ucycle All Rights Reserved.
</footer>
</body>
</html>