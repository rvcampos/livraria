<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
<jsp:include page="../header.jsp" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="../menu.jsp" />


		<div class="center-container" style="padding-top: 60px;">
			<table class="table">
				<tr>
					<th></th>
					<th></th>
					<th>Nome</th>
				</tr>
				<c:forEach var="categoria" items="${categorias}">
					<tr>
						<td><form action="detalha" method="post"
								id="formCategoria${categoria.id}">
								<input type="hidden" value="${categoria.id}" name="id_categoria" />
								<a onclick="$('#formCategoria${categoria.id}').submit();"><i
									class="glyphicon glyphicon-pencil"></i></a>
							</form></td>
						<td><form action="delete" method="post"
								id="formCategoriaDelete${categoria.id}">
								<input type="hidden" value=${categoria.id } name="id_categoria" />
								<a
									onclick="if (confirm('Deseja remover a categoria selecionada?'))$('#formCategoriaDelete${categoria.id}').submit();"><i
									class="glyphicon glyphicon-remove"></i></a>
							</form></td>
						<td>${categoria.nome}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>