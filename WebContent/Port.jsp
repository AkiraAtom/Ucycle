<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Port.css">
<link rel="SHORTCUT ICON" href="img/favicon.ico">
<script type="text/javascript" src="js/map.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<title>Ucycle - 駐輪場選択画面</title>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?"></script>
</head>
<s:if test="%{status == 0}">
	<div align="center">

		<font color=red> <b>自転車の在庫がありません 他の駐輪場を選択してください</b>
		</font>
	</div>
</s:if>
<body onload="initialize()">
	<header>
		<nav>
			<ul>
				<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
			</ul>
		</nav>
	</header>
	<nav>
		<br>
		<h1>駐輪場選択</h1>

		<div class="map">
			<div class="accessmap">
				<div id="map_canvas"></div>
			</div>
			<div class="yoko1">
				<div class="yoko">

					<div class="to"></div>
					<p>【駐輪場選択】</p>
					<div class="container">
						<s:form id="gpsFrom" name="GPS" action="PortAction" method="post">

							<input type="hidden" name="lat" value="" id="gpsFrom_lat" />
							<input type="hidden" name="lon" value="" id="gpsFrom_lon" />
							<input type="hidden" name="address" value="" id="gpsFrom_address" />
							<!-- ここから -->
							<input type="hidden" name="lat2" value="" id="gpsFrom_lat2" />
							<input type="hidden" name="lon2" value="" id="gpsFrom_lon2" />
							<input type="hidden" name="duration" value=""
								id="gpsFrom_duration" />
							<input type="hidden" name="distance" value=""
								id="gpsFrom_distance" />
							<!-- ここまでこのまま！ -->
							<div align="center">

								<span class="glyphicon glyphicon-circle-arrow-right"
									aria-hidden="true"></span> <select name="shopAddress"
									id="address" class="selectpicker" onchange="search2()"
									size="12">
									<option value="有楽町駅前店" selected>有楽町駅前店</option>
									<option value="東京都中央区日本橋兜町8-11">日本橋兜町店</option>
									<option value="東京都港区芝浦5-34-7田町センタービル">田町センタービル店</option>
									<option value="東京都新宿区1-13-8朝日新宿ビル">西新宿1丁目店（本店）</option>
									<option value="東京都文京区本郷2-40-18">本郷三丁目店</option>
									<option value="東京都台東区上野5-20-6">御徒町南口店</option>
									<option value="東京都墨田区両国3-26-5">両国東口店</option>
									<option value="東京都江東区東陽4-5-18 メトロハイツ東陽">東陽町店</option>
									<option value="東京都品川区上大崎2-14-5">目黒東口店</option>
									<option value="東京都目黒区自由が丘2-1">自由ヶ丘店</option>
									<option value="東京都大田区蒲田5-11-10">蒲田東口店</option>
									<option value="東京都世田谷区三軒茶屋2-14-13">三軒茶屋2丁目店</option>
									<option value="東京都渋谷区渋谷1-14-15">渋谷1丁目店</option>
									<option value="東京都中野区鷺宮3-19-5">鷺ノ宮店</option>
									<option value="東京都杉並区荻窪5-29-7">荻窪南口店</option>
									<option value="東京都豊島区西池袋1-11-1 ルミネ池袋店B1F">ルミネ池袋店</option>
									<option value="東京都北区赤羽1-1-1 ビーンズ赤羽">ビーンズ赤羽店</option>
									<option value="東京都荒川区西日暮里2-19-7 東忠ビル1F">日暮里駅前店</option>
									<option value="東京都板橋区上板橋2-36-8">上板橋南口店</option>
									<option value="東京都練馬区東大泉1-31-3 太田ビル1F">大泉学園駅前店</option>
									<option value="東京都足立区千住3-92">北千住西口店</option>
									<option value="東京都葛飾区青戸3-39-11">京成青砥店</option>
									<option value="東京都江戸川区南小岩6-31-2">小岩ポポ店</option>
								</select>

							</div>


							<p>【予約日】</p>


							<select name="port_time">
								<option id="date"></option>
								<option id="date1"></option>
								<option id="date2"></option>
							</select>


							<input type="submit" name="send" value="次のページ" class="ba">
						</s:form>
					</div>
				</div>
			</div>
			<div class="now" onclick="dia()">現在地取得</div>

			<div class="mai">

				<form name="Form1" method="post" action="GoMypageAction">
					<input type="submit" name="send" value="マイページ" class="ma">
				</form>
			</div>
			<s:if test="%{#session.status == 0}">
				<div class="null">
					<p>
						<font color=red> <b>自転車の在庫がありません<br>他の駐輪場を選択してください
						</b>
						</font>
					</p>
				</div>
			</s:if>
		</div>

	</nav>

	<footer>
		<br> &copy; 2015 Ucycle All Rights Reserved.
	</footer>
</body>
</html>