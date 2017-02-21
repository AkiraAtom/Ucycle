<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width; initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Edit.css">
<meta charset="UTF-8">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script src="js/adjustAjaxZip3.js"></script>
<title>Ucycle - 顧客情報編集画面</title>
</head>
<body>
	<s:if test="%{#session.customerType==1}">
		<div class="backimage">
			<header>
				<nav>
					<ul>
						<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
					</ul>
				</nav>
			</header>
			<br> <br> <br> <br> <br> <br> <br>
			<div align="center">
				<b>【変更する情報を入力して下さい】</b><br> <br> <span
					style="background-color: black; font-size: 2; text: red;"> <s:property
						value="errorpass" />
				</span> <span style="background-color: black; font-size: 2; text: red;">
					<s:property value="errormail" />
				</span> <span style="background-color: black; font-size: 2; text: red;">
					<br> <s:property value="errormsg" />
				</span>
				<s:form action="UpdataAction">
					<input type="hidden" name="customerType" value="1">
					<table class="tabledesign">
						<tbody>

							<tr>
								<th>姓</th>

								<td><input type="text" name="familyName" placeholder="例)山田"
									value="<s:property value="#session.familyname"/>"
									pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,20}" required
									title="苗字を入力して下さい" maxlength="20" /></td>
							</tr>
							<tr>
								<th>名</th>
								<td><input type="text" name="givenName" placeholder="例)太郎"
									value="<s:property value="#session.givenName"/>"
									pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,20}" required
									title="名前を入力して下さい" maxlength="20" /></td>
							</tr>
							<tr>
								<th>パスワード</th>
								<td><input type="password" name="customerPass1"
									placeholder="例)ya01(4文字以上25文字以下)"
									value="<s:property value="#session.customerPass1"/>"
									pattern="[0-9a-z]{4,25}" required title="半角英数字でパスワードを入力して下さい"
									maxlength="25" class="res" /></td>
							</tr>
							<tr>
								<th>パスワード(確認)</th>
								<td><input type="password" name="customerPass2"
									placeholder="もう一度パスワードを入力"
									value="<s:property value="#session.customerPass1"/>"
									pattern="[0-9a-z]{4,8}" required title="もう一度パスワードを入力して下さい"
									maxlength="8" class="res" /></td>
							</tr>
							<tr>
								<th>電話番号</th>
								<td><input type="text" name="phone"
									placeholder="090123456780(半角で入力)"
									value="<s:property value="#session.phone"/>"
									pattern="[0-9]{4,32}" required title="半角数字で電話番号を入力して下さい"
									maxlength="12" class="res" /></td>
							</tr>
							<tr>
								<th>メールアドレス</th>
								<td><input type="text" name="mailaddress"
									placeholder="例)xxxxxxx@xxxx.co.jp"
									value="<s:property value="#session.mailaddress"/>"
									pattern="^[0-9a-z]+[\w-]+@[\w\.-]+\.\w{2,}$" required
									title="半角英数字でメールアドレスを入力して下さい" maxlength="30" class="res" /></td>
							</tr>
							<tr>
								<th>郵便番号</th>
								<td><input type="text" name="postcode"
									placeholder="1234567(半角で入力)" onKeyUp="backSpaceClear();"
									onclick="formClear();" required title="郵便番号を入力して下さい"
									class="res" value="<s:property value="#session.postcode"/>" /></td>
							</tr>
							<tr>
								<th>住所</th>
								<td><input size="25" type="text" name="address"
									maxlength="100" value="<s:property value="#session.address"/>"
									placeholder="例)東京都○○市" title="住所を入力して下さい" class="res" readonly
									required>
							<tr>
								<th>番地以降</th>
								<td><input type="text" name="housenumber"
									placeholder="例)1丁目10-1　ハイフンも含めて下さい" required
									title="番地以降を入力して下さい" class="res"
									value="<s:property value="#session.housenumber"/>" /></td>
							</tr>
							<tr>
								<th>お支払い方法</th>
								<td><label>クレジットカード名義</label> <input type=text
									name="CreditName" required placeholder="例)ヤマダタロウ"
									maxlength="20" required title="カード名義を入力して下さい" class="res" /> <br>
									<p style="display: inline;">
										カード番号<br> <input type=text name="creditNumber" required
											pattern="[0-9]{15,16}" placeholder="15～16桁のカード番号を入力"
											maxlength="16" class="res">
									</p> <br> 有効期限<br> <select name="expire1"
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
								</select> 月 / <select name="expire2" onClick="changeDisabled()">
										<option value="">--</option>
										<option value="1">15</option>
										<option value="2">16</option>
										<option value="3">17</option>
										<option value="4">18</option>
										<option value="5">19</option>
										<option value="6">20</option>
										<option value="7">21</option>
										<option value="8">22</option>
								</select> 年<br> セキュリティコード<br> <input type=text name="Security"
									required title="セキュリティコードを入力してください" pattern="[0-9]{3,}"
									placeholder="3～4桁のセキュリティコードを入力" maxlength="4" class="res">
								</td>
							</tr>

						</tbody>
					</table>
					<br>
					<p>
						<input type="submit" value="編集" onclick="return addressClear();"
							class="res" />
					</p>

				</s:form>
				<p>
					<input type="submit" value="キャンセル"
						onclick="location.href='Mypage.jsp'" class="res" />
				</p>
			</div>
			<br> <br> <br>
		</div>
		<footer>
			<br> &copy; 2015 Ucycle All Rights Reserved.
		</footer>

	</s:if>

	<s:else>
		<div class="backimage">
			<header>
				<nav>
					<ul>
						<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
					</ul>
				</nav>
			</header>
			<br> <br> <br> <br> <br> <br> <br>
			<div align="center">
				<b>【変更する情報を入力して下さい】</b><br> <br> <span
					style="background-color: black; font-size: 2; text: red;"> <s:property
						value="errorpass2" />
				</span> <span style="background-color: black; font-size: 2; text: red;">
					<s:property value="errormail2" />
				</span> <span style="background-color: black; font-size: 2; text: red;">
					<br> <s:property value="errormsg2" />
				</span>
				<s:form action="UpdataAction">
					<input type="hidden" name="customerType" value="2">
					<table class="tabledesign">
						<tbody>

							<tr>
								<th>姓</th>
								<td><input type="text" name="familyName" placeholder="例)山田"
									value="<s:property value="#session.familyname"/>"
									pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,20}" required
									title="苗字を入力して下さい" maxlength="20" /></td>
							</tr>
							<tr>
								<th>名</th>
								<td><input type="text" name="givenName" placeholder="例)太郎"
									value="<s:property value="#session.givenName"/>"
									pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,20}" required
									title="名前を入力して下さい" maxlength="20" /></td>
							</tr>
							<tr>
								<th>パスワード</th>
								<td><input type="password" name="customerPass1" size="35"
									placeholder="例)ya01(4文字以上25文字以下)"
									value="<s:property value="#session.customerPass1"/>"
									pattern="[0-9a-z]{4,25}" required title="半角英数字でパスワードを入力して下さい"
									maxlength="25" /></td>
							</tr>
							<tr>
								<th>パスワード(確認)</th>
								<td><input type="password" name="customerPass2" size="35"
									placeholder="もう一度パスワードを入力"
									value="<s:property value="#session.customerPass1"/>"
									pattern="[0-9a-z]{4,25}" required title="もう一度パスワードを入力して下さい"
									maxlength="25" /></td>
							</tr>
							<tr>
								<th>メールアドレス</th>
								<td><input type="text" name="mailaddress" size="35"
									placeholder="例)xxxxxxx@xxxx.co.jp"
									value="<s:property value="#session.mailaddress"/>"
									pattern="^[0-9a-z]+[\w-]+@[\w\.-]+\.\w{2,}$" required
									title="半角英数字でメールアドレスを入力して下さい" maxlength="30" /></td>
							</tr>
						</tbody>
					</table>
					<br>
					<p>
						<input type="submit" value="編集" onclick="return addressClear();" />
					</p>

				</s:form>
				<p>
					<input type="submit" value="キャンセル"
						onclick="location.href='Mypage.jsp'" />
				</p>
			</div>

			<br> <br> <br>
			<div align="center">

				<h1>プレミアム会員へアップグレードされる方はこちら</h1>
				<br> <br> <b>【お客様情報を入力して下さい】</b><br> <br> <span
					style="background-color: black; font-size: 2; text: red;"> <s:property
						value="errorpass" />
				</span> <span style="background-color: black; font-size: 2; text: red;">
					<s:property value="errormail" />
				</span> <span style="background-color: black; font-size: 2; text: red;">
					<br> <s:property value="errormsg" />
				</span>
				<s:form action="UpdataAction">
					<input type="hidden" name="customerType" value="1">
					<table class="tabledesign">
						<tbody>

							<tr>
								<th>姓</th>

								<td><input type="text" name="familyName" placeholder="例)山田"
									value="<s:property value="#session.familyname"/>"
									pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,20}" required
									title="苗字を入力して下さい" maxlength="20" /></td>
							</tr>
							<tr>
								<th>名</th>
								<td><input type="text" name="givenName" placeholder="例)太郎"
									value="<s:property value="#session.givenName"/>"
									pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,20}" required
									title="名前を入力して下さい" maxlength="20" /></td>
							</tr>
							<tr>
								<th>パスワード</th>
								<td><input type="password" name="customerPass1" size="35"
									placeholder="例)ya01(4文字以上25文字以下)"
									value="<s:property value="#session.customerPass1"/>"
									pattern="[0-9a-z]{4,8}" required title="半角英数字でパスワードを入力して下さい"
									maxlength="8" /></td>
							</tr>
							<tr>
								<th>パスワード(確認)</th>
								<td><input type="password" name="customerPass2" size="35"
									placeholder="もう一度パスワードを入力"
									value="<s:property value="#session.customerPass1"/>"
									pattern="[0-9a-z]{4,8}" required title="もう一度パスワードを入力して下さい"
									maxlength="8" /></td>
							</tr>
							<tr>
								<th>電話番号</th>
								<td><input type="text" name="phone" size="35"
									placeholder="090123456780(半角で入力)" pattern="[0-9]{4,32}"
									required title="半角数字で電話番号を入力して下さい" maxlength="12" /></td>
							</tr>
							<tr>
								<th>メールアドレス</th>
								<td><input type="text" name="mailaddress" size="35"
									placeholder="例)xxxxxxx@xxxx.co.jp"
									value="<s:property value="#session.mailaddress"/>"
									pattern="^[0-9a-z]+[\w-]+@[\w\.-]+\.\w{2,}$" required
									title="半角英数字でメールアドレスを入力して下さい" maxlength="30" /></td>
							</tr>
							<tr>
								<th>郵便番号</th>
								<td><input type="text" name="postcode" size="35"
									placeholder="1234567(半角で入力)" onKeyUp="backSpaceClear();"
									onclick="formClear();" required title="郵便番号を入力して下さい" /></td>
							</tr>
							<tr>
								<th>住所</th>
								<td><input size="25" type="text" name="address" size="35"
									maxlength="100" placeholder="例)東京都○○市" title="住所を入力して下さい"
									readonly required>
							<tr>
								<th>番地以降</th>
								<td><input type="text" name="housenumber" size="35"
									placeholder="例)1丁目10-1　ハイフンも含めて下さい" required
									title="番地以降を入力して下さい" /></td>
							</tr>
							<tr>
								<th>お支払い方法</th>
								<td><label>クレジットカード名義</label> <input type=text
									name="CreditName" required placeholder="例)ヤマダタロウ"
									maxlength="20" required title="カード名義を入力して下さい" /> <br>
									<p style="display: inline;">
										カード番号<br> <input type=text name="creditNumber" required
											pattern="[0-9]{15,16}" placeholder="15～16桁のカード番号を入力"
											maxlength="16">
									</p> <br> 有効期限<br> <select name="expire1"
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
								</select> 月 / <select name="expire2" onClick="changeDisabled()">
										<option value="">--</option>
										<option value="1">15</option>
										<option value="2">16</option>
										<option value="3">17</option>
										<option value="4">18</option>
										<option value="5">19</option>
										<option value="6">20</option>
										<option value="7">21</option>
										<option value="8">22</option>
								</select> 年<br> セキュリティコード<br> <input type=text name="Security"
									required title="セキュリティコードを入力してください" pattern="[0-9]{3,}"
									placeholder="3～4桁のセキュリティコードを入力" maxlength="4"></td>
							</tr>

						</tbody>
					</table>
					<br>
					<p>
						<input type="submit" value="編集" onclick="return addressClear();" />
					</p>

				</s:form>
				<p>
					<input type="submit" value="キャンセル"
						onclick="location.href='Mypage.jsp'" />
				</p>
			</div>
			<br> <br> <br>
		</div>
		<footer>
			<br> &copy; 2015 Ucycle All Rights Reserved.
		</footer>

	</s:else>
</body>
</html>