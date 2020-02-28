<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<title>パスワード再設定確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="main">
		<div id="top">
			<h1>パスワード再設定確認画面</h1>
		</div>
		<table class="table">
			<tr>
				<th><label>ユーザーID</label></th>
				<td><s:property value="loginUserId" /></td>
			</tr>
			<tr>
				<th><label>新しいパスワード</label></th>
				<td><s:property value="tmpNewPassword" /></td>
			</tr>
		</table>
		<s:form action="ResetPasswordCompleteAction">
			<div class="submit_btn_box2">
				<s:submit value="パスワード再設定" class="submit_btn" />
			</div>
		</s:form>
		<s:form action="resetPassword.jsp">
			<div class="submit_btn_box2">
				<s:submit value="戻る" class="submit_btn" />
			</div>
		</s:form>
	</div>
</body>
</html>