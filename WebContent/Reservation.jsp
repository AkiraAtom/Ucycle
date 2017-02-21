<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1"/>
<title>Ucycle - 予約確認画面</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Reservation.css">
</head>
<body>
<header>
	<nav>
		<ul>
			<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
		</ul>
	</nav>
</header>
<br>
<br>
<br>
<br>
<div id="wrapper">

<!-- 予約状況テーブル  -->
<h2><s:property value="#session.familyname"/>様の利用情報</h2>
<table border="1">

<tr>
<th>プラン</th>
<td><s:property value="#session.time_plan"/></td>
</tr>
<tr>
<th>駐輪場</th>
<td><s:property value="#session.port_name"/></td>
</tr>
</table>
<br>
<h3>以上の条件でご予約しますか</h3>


<!-- キャンセルボタン -->
<a href="reseGoMainAction" type ="submit">キャンセル</a>

<!-- 予約ボタン -->
<a href="ReservationAction" type="submit">予約</a>


</div>

<footer>
		<br> &copy; 2015 Ucycle All Rights Reserved.
</footer>
</body>
</html>