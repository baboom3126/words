<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
	<head>
	
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
			<script src='../js/jquery.min.js'></script>
	    	<script src='../js/usernew.js'></script>
	
    	<link rel="stylesheet" href="../materialize/materialize.min.css">
    	<script src="../materialize/materialize.min.js"></script>
    	
    	<title>使用者列表</title>
	</head>
	<body>
		<div class='container'>
			<form id="newUserForm" action="javascript:newuser()">
				<input type = "text" id="userId">
				<input type = "text" id="userName">
				<input type = "submit" class="button">
			</form>
      </div>
	</body>
</html>
