<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- struts2のタグライブラリを使用する宣言  -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログイン成功画面</title>
	</head>
	<body>
		<!-- ↓勝手に入れた一行  -->
		<s:property value="name"/>さんおめでとう！
		<!-- ↑勝手に入れた一行  -->
		<h1>ログインに成功しました。</h1>
	</body>
</html>