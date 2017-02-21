<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="content-style-type" content="text/css" charset="UTF-8" />
<link rel="stylesheet" type="css/text" href="css/Admin.css">
<title>管理画面</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var topBtn = $('#page-top');
		topBtn.hide();
		//スクロールが100に達したらボタン表示
		$(window).scroll(function() {
			if ($(this).scrollTop() > 100) {
				topBtn.fadeIn();
			} else {
				topBtn.fadeOut();
			}
		});
		//スクロールしてトップ
		topBtn.click(function() {
			$('body,html').animate({
				scrollTop : 0
			}, 500);
			return false;
		});
	});

	// 数値のみを入力可能にする
	function numOnly() {
		m = String.fromCharCode(event.keyCode);
		if ("0123456789\b\r".indexOf(m, 0) < 0)
			return false;
		return true;
	}
</script>
</head>
<body>
	<div class="centerdesign">

		<h1  align="center">管理画面</h1>
	</div>
	<div align="center">
	<p class="caution">数字入力は半角のみ</p>
	<p class="caution">商品ID欄には商品IDのみ記入可能</p>
	<p class="caution">値の確認は下の商品一覧情報取得から行ってください</p>
	<p class="caution">テンキー入力不可</p>
	<br>
		<font size="2" color="red"> <s:property value="errormsg" /></font>


	<h2>駐輪場情報編集</h2>
	<s:form action="UpdatePortAction">
		<table>
			<tbody>

				<tr>
					<th align="right">駐輪場ID：</th>
					<td><input type="text" name="portId" maxlength="20"
						required> <s:fielderror>
							<s:param value="%{'portId'}" />
						</s:fielderror></td>
				</tr>

				<tr><td>【自転車の在庫数】</td>
				</tr>
				<tr>
					<th align="right">電動自転車：</th><td align="right"><input type="text" name="stock" maxlength="20"
						onkeyDown="return numOnly()" pattern="[0-9]{1,10}"
						title="10桁以内で入力してください" required> <s:fielderror>
							<s:param value="%{'stock1'}" />
						</s:fielderror></td>
				</tr>
				<tr>
					<th align="right">シティサイクル：</th><td align="right"><input type="text" name="stock" maxlength="20"
						onkeyDown="return numOnly()" pattern="[0-9]{1,10}"
						title="10桁以内で入力してください" required> <s:fielderror>
							<s:param value="%{'stock2'}" />
						</s:fielderror></td>
				</tr>
				<tr>
					<th align="right">マウンテンバイク：</th><td align="right"><input type="text" name="stock" maxlength="20"
						onkeyDown="return numOnly()" pattern="[0-9]{1,10}"
						title="10桁以内で入力してください" required> <s:fielderror>
							<s:param value="%{'stock3'}" />
						</s:fielderror></td>
				</tr>
				<tr>
					<th align="right">チャイルドシート付き自転車：</th><td align="right"><input type="text" name="stock" maxlength="20"
						onkeyDown="return numOnly()" pattern="[0-9]{1,10}"
						title="10桁以内で入力してください" required> <s:fielderror>
							<s:param value="%{'stock4'}" />
						</s:fielderror></td>
				</tr>
				<tr>
					<th align="right">許容量：</th><td align="right"><input type="text" name="unitPrice" maxlength="20"
						onkeyDown="return numOnly()" pattern="[0-9]{1,10}"
						title="10桁以内で入力してください" required> <s:fielderror>
							<s:param value="%{'capacity'}" />
						</s:fielderror></td>
							</tr>
			</tbody>
		</table>

					<input type="submit" value="編集">

	</s:form>
	<h2>顧客情報削除</h2>
	<s:form action="DeleteCustomerAction">
		<table>
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td>顧客ID：<input type="text" name="CustomerId" maxlength="20"
						onkeyDown="return numOnly()" pattern="[0-9a-z]{1,10}"
						title="半角数字で入力してください" required> <s:fielderror>
							<s:param value="%{'CustomerId'}" />
						</s:fielderror></td>
					<td><input type="submit" value="削除"></td>
				</tr>
			</tbody>
		</table>
	</s:form>

	<br>
	<s:form action="AdminPortAllAction">
			<input type="submit" value="駐車場情報一覧取得">
		<table
			style="border: 1px solid #CCC; border-collapse: collapse; width: 80%;">
			<tr>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 1px; width: 20%;"
					align="center">駐車場ID</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">駐車場名</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">住所</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">電動自転車</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">シティサイクル</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">マウンテンバイク</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">チャイルドシート付き自転車</td>
				<td
					style="height: 3em; border: 1px solid #CCC; background-color: #FFCC99; font-weight: bold; padding: 5px;"
					align="center">許容スペース</td>
			</tr>
			<s:iterator value="PortList" status="PortList">
				<tr>
					<td style="padding: 1px; background-color: #FFFFFF; font-weight: normal; border: 1px solid #CCC; border-collapse: collapse; width: 20%;">
						<s:property value="goodsId" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="goodsName" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="unitPrice" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="unitPrice" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="unitPrice" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="unitPrice" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="unitPrice" /></td>
					<td style="padding: 5px; border: 1px solid #CCC;"><s:property
							value="unitPrice" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
	<br>
	<p id="page-top">
		<a href="#wrap">PAGE TOP</a>
	</p>
</body>
</html>