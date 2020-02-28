<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<title>パスワード再設定画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="main">
		<div id="top">
			<h1>パスワード再設定画面</h1>
		</div>
		<s:if
			test="loginUserIdErrorMessageList!=null && loginUserIdErrorMessageList.size() > 0">
			<div class="error">
				<div class="error_message">
					<s:iterator value="loginUserIdErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="loginPasswordErrorMessageList!=null && loginPasswordErrorMessageList.size() > 0">
			<div class="error">
				<div class="error_message">
					<s:iterator value="loginPasswordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="newPasswordErrorMessageList!=null && newPasswordErrorMessageList.size() > 0">
			<div class="error">
				<div class="error_message">
					<s:iterator value="newPasswordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="newConfirmPasswordErrorMessageList!=null && newConfirmPasswordErrorMessageList.size() > 0">
			<div class="error">
				<div class="error_message">
					<s:iterator value="newConfirmPasswordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="newPasswordMatchesList!=null && !newPasswordMatchesList.isEmpty()">
			<div class="error">
				<div class="error_message">
					<s:property value="newPasswordMatchesList" />
					<br>
				</div>
			</div>
		</s:if>
		<s:if
			test="newUserAndPasswordExistenseErrorMessageList!=null && !newUserAndPasswordExistenseErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error_message">
					<s:property value="newUserAndPasswordExistenseErrorMessageList" />
					<br>
				</div>
			</div>
		</s:if>
		<span><s:property value="errorMessage" /> </span>
		<s:form action="ResetPasswordConfirmAction">
			<table class="table">
				<tr>
					<th><label>ユーザーID</label></th>
					<td><s:textfield placeholder="ユーザーID" name="loginUserId"
							value="%{#session.loginUserId}" class="txt" /></td>
				</tr>
				<tr>
					<th><label>現在のパスワード</label></th>
					<td><s:password placeholder="現在のパスワード" name="loginPassword"
							value="" class="txt" /></td>
				</tr>
				<tr>
					<th><label>新しいパスワード</label></th>
					<td><s:password placeholder="新しいパスワード" name="newPassword"
							value="" class="txt" /></td>
				</tr>
				<tr>
					<th><label>新しいパスワード(再確認)</label></th>
					<td><s:password placeholder="新しいパスワード(再確認用)"
							name="newConfirmPassword" value="" class="txt" /></td>
				</tr>
			</table>
			<div class="submit_btn_box2">
				<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>
</body>
</html>