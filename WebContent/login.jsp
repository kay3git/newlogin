<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- struts2のタグライブラリを使用する宣言  -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログイン画面</title>
	</head>
	<body>
<!-- struts2のタグライブラリを使用してフォームを作成  -->
		<s:form action="LoginAction">
			<s:textfield name ="name" />
			<s:password name ="password" />
			<s:submit value ="ログイン" />
		</s:form>
	</body>
</html>