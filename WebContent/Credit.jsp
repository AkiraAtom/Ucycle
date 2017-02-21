<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ucycle - クレジット情報入力画面</title>
<link href="css/Credit.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/card.js"></script>
<!-- 
<script src="js/jquery.card.js"></script>
-->
<script>
    $('form').card({
        container: $('.card-wrapper')
    })
</script>
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
<div class="container">
    <div class="card-wrapper"></div>
    <div class="form-container active">
        <s:form action="GoReservationAction" name="Form1">
            <input placeholder="Card number" type="text" name="number" required autofocus>
            <input placeholder="Full name" type="text" name="name" pattern="[a-zA-Z| ]{1,23}" required title="必須項目です。半角全角英字で入力してください">
            <input placeholder="月/年" type="text" name="expiry" pattern="\d{2}/\d{2}" required title="必須項目です。半角数字で入力してください">
            <input placeholder="セキュリティーコード" type="text" name="cvc" min="3" required title="必須項目です。半角数字で入力してください">
    
    		<button type ="submit" style="position: absolute; left: 51%; top: 60%">次へ</button>
		</s:form>
    
    </div>
</div>
<div align="center">
		
		
	
	<s:form action="GoCycleAction">
		<button type ="submit" style="position: absolute; left: 46%; top: 60%">戻る</button>
	</s:form>
</div>


	<script>
        new Card({
            form: document.querySelector('form'),
            container: '.card-wrapper'
        });
    </script>
<footer>
		<br> &copy; 2015 Ucycle All Rights Reserved.
</footer>  
</body>
</html>