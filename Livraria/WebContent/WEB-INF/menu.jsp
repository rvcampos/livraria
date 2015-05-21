<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<c:if test="${not empty sessionScope.usuario}">
				<p class="navbar-text">
					Olá ${sessionScope.usuario}, <a href="${app_context}logout">LOGOUT</a>
				</p>
			</c:if>
			<c:if test="${empty sessionScope.usuario}">
				<p class="navbar-text">
					<a href="${app_context}login">Clique aqui para fazer Login</a>
					${sessionScope.usuario}
				</p>
			</c:if>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<c:if test="${not empty sessionScope.isAdmin}">
				<ul class="nav navbar-nav">
					<li><a href="#">Usuários</a></li>
					<li><a href="${app_context}categoria">Categorias</a></li>
					<li><a href="#">Editoras</a></li>
					<li><a href="#">Autores</a></li>
					<li><a href="#">Livros</a></li>
				</ul>
			</c:if>
			<ul class="nav navbar-nav navbar-right">
				<li><button type="button" class="btn btn-default btn-lg"
						aria-label="Left Align">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
						Carrinho
					</button></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</div>