<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Create.css">
<meta charset="UTF-8">

<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script src="js/adjustAjaxZip3.js"></script>

<script type="text/javascript">
<!--
	function changeDisabled() {
		if (document.Form1["customertype"][0].checked) {
			document.Form1["familyname"].disabled = false;
			document.Form1["lastname"].disabled = false;
			document.Form1["customerPass1"].disabled = false;
			document.Form1["customerPass2"].disabled = false;
			document.Form1["phone"].disabled = false;
			document.Form1["mailaddress1"].disabled = false;
			document.Form1["mailaddress2"].disabled = false;
			document.Form1["postcode"].disabled = false;
			document.Form1["address"].disabled = false;
			document.Form1["housenumber"].disabled = false;
			document.Form1["creditname"].disabled = false;
			document.Form1["creditnumber"].disabled = false;
			document.Form1["expire1"].disabled = false;
			document.Form1["expire2"].disabled = false;
			document.Form1["securitycode"].disabled = false;
		} else {
			document.Form1["familyname"].disabled = false;
			document.Form1["lastname"].disabled = false;
			document.Form1["customerPass1"].disabled = false;
			document.Form1["customerPass2"].disabled = false;
			document.Form1["phone"].disabled = true;
			document.Form1["mailaddress1"].disabled = false;
			document.Form1["mailaddress2"].disabled = false;
			document.Form1["postcode"].disabled = true;
			document.Form1["address"].disabled = true;
			document.Form1["housenumber"].disabled = true;
			document.Form1["creditname"].disabled = true;
			document.Form1["creditnumber"].disabled = true;
			document.Form1["expire1"].disabled = true;
			document.Form1["expire2"].disabled = true;
			document.Form1["securitycode"].disabled = true;
		}
	}
	window.onload = changeDisabled;
// -->
</script>

<title>Ucycle - [顧客情入力画面</title>
</head>
<body>
		<div class="backimage">


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

	<div align="center">
		<div id="table1">



			<b>【お客様情報入力欄となります】</b><br> <br>
			<s:form name="Form1" action="InsertAction">


				<table class="tabledesign">
					<tbody>
						<tr>
						<tr>
							<th>ご利用方法</th>
							<td><input type="radio" name="customertype" value="1"
								id="radio-other" onClick="changeDisabled()" checked>月額会員様
								<input type="radio" name="customertype" value="2"
								id="radio-other" onClick="changeDisabled()">一般会員様
						</tr>
						<tr>
							<th>お名前</th>
							<td><div class="name">
									姓<input type="text" name="familyname" size="10"
										placeholder="苗字を入力" style="width: 100px;"
										pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,30}" required
										title="名前を入力してください" maxlength="30" /> 名<input type="text"
										name="lastname" size="10" placeholder="名前を入力"
										style="width: 100px;"
										pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,30}" required
										title="名前を入力してください" maxlength="30" />
								</div></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="password" name="customerPass1" size="35"
								placeholder="パスワードを入力" pattern="^[0-9a-zA-Z]+[\w-]+@[\w\.-]+\.\w{2,}$"required
								title="半角英数字でパスワード入力してください" maxlength="8" /></td>
						</tr>
						<tr>
							<th>パスワード確認用</th>
							<td><input type="password" name="customerPass2" size="35"
								placeholder="確認用パスワードを入力" pattern="^[0-9a-zA-Z]+[\w-]+@[\w\.-]+\.\w{2,}$" required
								title="半角英数字でパスワード入力してください" maxlength="8" /></td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td><input type="text" name="phone" size="35"
								placeholder="電話番号を入力" pattern="[0-9]{4,32}" required
								title="半角数字で電話番号入力してください" maxlength="12" /></td>

						</tr>

						<tr>
							<th>メールアドレス</th>
							<td><input type="email" name="mailaddress1" size="25"
								maxlength="50" pattern="^[0-9a-z]+[\w-]+@[\w\.-]+\.\w{2,}$"
								placeholder="例)xxxxxxx@xxxx.co.jp" title="必須項目です。例に従って入力してください。"
								required></td>
						</tr>

						<tr>
							<th>郵便番号</th>
							<td><input type="text" name="postcode" size="35"
								placeholder="郵便番号を入力" onKeyUp="backSpaceClear();"
								onclick="formClear();" required title="住所を入力してください" /></td>
						</tr>
						<tr>
							<th>住所</th>
							<td><input size="25" type="text" name="address" size="35"
								maxlength="100" placeholder="住所を入力してください" title="必須項目です"
								readonly required> <br>
						<tr>
							<th>番地以降</th>
							<td><input type="text" name="housenumber" size="35"
								placeholder="番地を入力" required title="住所を入力してください" /></td>
						</tr>
						<tr>
							<th>お支払い方法</th>
							<td><label></label> <input type=text name="creditname"
								pattern="[9-30]" placeholder="クレジットカード名義人のお名前を入力">


								<p style="display: inline;">
									<br> <input type=text name="creditnumber" pattern="[15-16]"
										placeholder="15～16桁のカード番号を入力" maxlength="16">
								</p> <br> 有効期限<br> <select id="credit" name="expire1"
								onClick="changeDisabled()">
									<option value="">--</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select> 月 / <select id="credit" name="expire2"
								onClick="changeDisabled()">
									<option value="">--</option>
									<option value="1">15</option>
									<option value="2">16</option>
									<option value="3">17</option>
									<option value="4">18</option>
									<option value="5">19</option>
									<option value="6">20</option>
									<option value="7">21</option>
									<option value="8">22</option>
							</select> 年<br> <br> <input type=text name="securitycode"
								 placeholder="4桁のセキュリティコードを入力" maxlength="4">
							</td>
						</tr>
					</tbody>
				</table>
				<p>
				   <input type="submit" value="新規登録"  onclick="return addressClear();"/>
				</p>


			</s:form>

			<p>
				<input type="submit" value="キャンセル"
					onclick="location.href='Main.jsp'" />
			</p>
		</div>
	</div>






	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<footer class="footer">
		<br> &copy; 2015 Ucycle All Rights Reserved.
	</footer>
</body>
</html>