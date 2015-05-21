<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
<jsp:include page="header.jsp" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container" style="padding-top: 60px;">
		<form method="post" action="login" name="form_login">
			<table>
				<tr>
					<td>Usuário</td>
					<td><input type="text" name="usuario" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="password" name="senha" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" class="btn"
						id="btnLogin" data-loading-text="Logando..."
						onclick="$('#btnLogin').button('loading');" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>