<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Ucycle - Mypage</title>
<meta charset="UTF-8" name="viewport" content="width=device-width; initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Mypage.css">
</head>

<!-- SNSでログインの場合 -->
<s:if test="%{#session.customerType==3}">
<body>
<div class="mypage">
	<header>
		<nav>
			<ul>
				<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
			</ul>
		</nav>
	</header>s

  <br><br>


  <div align = "center">
<br><br><br>
	<h2>Mypage</h2>
<br>
	<h2>ようこそ！<s:property value="#session.familyname"/>様</h2>

<div id="wrapper">

<!-- 予約状況テーブル  -->
<br><br>
<h3>＜ご予約状況＞</h3>
<br><br>

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



<!-- キャンセルボタン -->
<a href="GoMypageAction" type ="submit">すべてキャンセル</a>


</div>
  <br><br><br>
<input class="button" type="button"
		onclick="location.href='GoPortAction'" value="駐輪場選択はこちら">
  <br><br><br>

<input class="button" type="button"
		onclick="location.href='LogoutAction'" value="ログアウト">
  <br><br><br>

</div>
 <br><br> <br><br>
</div>
</body>
</s:if>

<!-- SNS以外でログインの場合 -->
<s:else>
<body>
<div class="mypage">
	<header>
		<nav>
			<ul>
				<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
			</ul>
		</nav>
	</header>

  <br><br>


  <div align = "center">
<br><br><br>
	<h2>Mypage</h2>
<br>
	<h2>ようこそ！<s:property value="#session.familyname"/>様</h2>

<div id="wrapper">

<!-- 予約状況テーブル  -->
<br><br>
<h3>＜ご予約状況＞</h3>
<br><br>

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



<!-- キャンセルボタン -->
<a href="GoMypageAction" type ="submit">すべてキャンセル</a>



</div>
  <br><br><br>


<div align="center">
<input class="button " type="button"
		onclick="location.href='GoEditAction'" value="登録情報編集">


<input class="button" type="button"
		onclick="location.href='GoHistoryAction'" value=" ご利用履歴 ">


<input class="button" type="button"
		onclick="location.href='GoPortAction'" value="駐輪場選択はこちら">
</div>
  <br><br><br>


　<input class="button" type="button"
		onclick="location.href='LogoutAction'" value="ログアウト">
<br><br><br><br>

<input class="button" type="button"
		onclick="location.href='GoWithdrawAction'" value=" 退会の方はこちら">
</div>
</div>
 <br><br><br><br>
</s:else>

<footer>
<br> &copy; 2015 Ucycle All Rights Reserved.
</footer>
</body>
</html>