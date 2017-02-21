<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ucycle - Cycle</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link href="css/Cycle.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.tab.js"></script>
<link rel="SHORTCUT ICON" href="img/bono.ico">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li class="project_title"><a href="Index.jsp">Ucycle</a></li>
			</ul>
		</nav>
	</header>
	<section>
		<br> <br> <br>
		<div class="lineup">
			<h1>プラン選択</h1>
			<p>プランを選択してください。</p>
		</div>
		<br> <br>
		<div class="ba">
			<p>City cycle</p>
		</div>
		<div id="detail">
			<div id="tab1" class="tabbox">
				<table>
					<tr>
						<td><img src="img/mama.jpeg" class="imgstyle"></td>
						<td>利用駐輪場<br> <s:property value="#session.port_name" /><br>
							<s:property value="#session.port_time" /></td>
						<td><s:form action="CycleAction" theme="simple">
								<input type="radio" name="plan" value="プランA" checked
									id="radio01" />
								<label for="radio01" class="radio">プランA：午前(6時～12時)<br>一般会員様：200円
								</label>
								<br>
								<input type="radio" name="plan" value="プランB" checked
									id="radio02" />
								<label for="radio02" class="radio">プランB：午後(12時～22時)<br>一般会員様：200円
								</label>
								<br>
								<input type="radio" name="plan" value="プランC" checked
									id="radio03" />
								<label for="radio03" class="radio">プランC：１日(6時～22時)<br>一般会員様：400円
								</label>
								<br>
								<input type="submit" value="確定" class="button btn_submit" />
							</s:form></td>
					</tr>
				</table>
			</div>
		</div>
	</section>
	<div class="plan">
		<form action="PortAction">
			<input type="submit" class="btn btn-default" value="戻る" />
		</form>
	</div>
	<footer>
		<br>&copy; 2015 Ucycle All Rights Reserved.
	</footer>
</body>
</html>