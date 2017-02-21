<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ucycle</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Main_Port.css">
<link rel="SHORTCUT ICON" href="img/favicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="js/map.js"></script>
<title>Ucycle</title>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?key=AIzaSyC5Q8ujl7gNN5ck35_Dyx4zPsRcXBjRKDE&sensor=false"></script>
</head>
<body onload="initialize()">
	<header>
		<nav>
			<ul>
				<li class="project_title"><a href="GoMainAction">Ucycle</a></li>
				<s:if test="%{#session.familyname==null}">
					<li class="menu_link"><a href="GoLoginAction">ログイン</a></li>
				</s:if>
				<s:else>
					<li class="menu_link"><a href="GoMypageAction">マイページ</a></li>
				</s:else>
			</ul>
		</nav>
	</header>
	<div class="all">
		<div class="top"></div>
		<div class="about">
			<div class="about_desc">
				<h3>行き先は自由</h3>
				<p>あなたの毎日の移動手段は何ですか？ 当サイトでは自転車のレンタルサービスを提供しております。
					通勤路が歩くには遠いし電車を使うほどではないとういう方にはもちろん、 お昼休みに少し遠くのお店でランチをされたいという方や、
					運動不足が気になっている方にもオススメです。 乗り換えも渋滞もない自転車で、 あなたが行きたいところへ自由に行きましょう。</p>
				<hr>
				<h3>都内主要箇所に駐輪場をご用意</h3>
				<p>あなたが都内のどこにいても、GPSを使って最寄りの駐輪場を見つけることができます。
					また、ご返却の場所も自由にお探し頂けます。あなたのご都合のよろしい場所で返却頂いて構いません。</p>
				<hr>
				<h3>プレミアム会員へのグレードアップ</h3>
				<p>当サービスには、一回毎のご利用となる一般会員と、月額制のプレミアム会員の二つをご用意しております。
					もしあなたが私たちの提供するサービスを気に入って頂ければ、プレミアム会員へグレードアップすることをオススメ致します。
					プレミアム会員へグレードアップして頂ければ、さらに快適な生活を送れることお約束致します。</p>
			</div>
			<div class="about_contents"></div>
		</div>
		<div class="map">
			<div class="accessmap">
				<div id="map_canvas"></div>
			</div>
			<div class="yoko1">
				<div class="yoko">
					<p>【駐輪場選択】</p>
					<div class="container">
						<s:form id="gpsFrom" name="GPS" action="PortAction" method="post">
							<input type="hidden" name="lat" value="" id="gpsFrom_lat" />
							<input type="hidden" name="lon" value="" id="gpsFrom_lon" />
							<input type="hidden" name="address" value="" id="gpsFrom_address" />
							<input type="hidden" name="lat2" value="" id="gpsFrom_lat2" />
							<input type="hidden" name="lon2" value="" id="gpsFrom_lon2" />
							<input type="hidden" name="duration" value=""
								id="gpsFrom_duration" />
							<input type="hidden" name="distance" value=""
								id="gpsFrom_distance" />
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
						</s:form>
					</div>
				</div>
			</div>
			<div class="now" onclick="dia()">現在地取得</div>
		</div>
		<hr>
		<div class="sns">
			<div class="sns_twitter">
				<!-- ソーシャルプラグインここから -->
				<div align="center">
					<a class="twitter-timeline" href="https://twitter.com/Ucycle04"
						data-widget-id="604166972557795328">@Ucycle04さんのツイート</a>
					<script>
						!function(d, s, id) {
							var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
									.test(d.location) ? 'http' : 'https';
							if (!d.getElementById(id)) {
								js = d.createElement(s);
								js.id = id;
								js.src = p
										+ "://platform.twitter.com/widgets.js";
								fjs.parentNode.insertBefore(js, fjs);
							}
						}(document, "script", "twitter-wjs");
					</script>
				</div>
			</div>
			<!-- facebook埋め込み -->
			<div class="sns_fb">
				<div align="center" class="col-md-6 col-xs-12">
					<div class="fb-page" data-href="https://www.facebook.com/Ucycle"
						data-width="70%" data-height="450" data-hide-cover="false"
						data-show-facepile="true" data-show-posts="true">
						<div class="fb-xfbml-parse-ignore">
							<blockquote cite="https://www.facebook.com/Ucycle">
								<a href="https://www.facebook.com/Ucycle">Stardusts</a>
							</blockquote>
						</div>
					</div>
					<div id="fb-root"></div>
					<script>
						(function(d, s, id) {
							var js, fjs = d.getElementsByTagName(s)[0];
							if (d.getElementById(id))
								return;
							js = d.createElement(s);
							js.id = id;
							js.src = "//connect.facebook.net/ja_JP/sdk.js#xfbml=1&version=v2.3";
							fjs.parentNode.insertBefore(js, fjs);
						}(document, 'script', 'facebook-jssdk'));
					</script>
				</div>
			</div>
		</div>
		<hr>
	</div>
	<footer>
		<br> &copy; 2015 Ucycle All Rights Reserved.
	</footer>
</body>
</html>