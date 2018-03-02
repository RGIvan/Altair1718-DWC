<%@page import="es.altair.bean.Usuario"%>
<%@page import="es.altair.bean.Juego"%>
<%@page import="es.altair.dao.JuegoDAOImplHibernate"%>
<%@page import="es.altair.dao.UsuarioDAOImplHibernate"%>
<%@page import="java.util.List"%>
<%@page import="es.altair.dao.UsuarioDAO"%>
<%@page import="es.altair.dao.JuegoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to.fit=no">
<meta name="keywords" content="html5, dwc, altair">
<meta name="author" content="Iván">

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
<link rel="stylesheet" href="../css/body.css">
<link rel="stylesheet" href="../css/modal_user.css">
<link rel="stylesheet" href="../css/card.css">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Menú</title>
</head>
<body>
	<%
		if (session.getAttribute("usuLogeado") == null || session.isNew()) {
			response.sendRedirect("../index.jsp?mensaje=No te has logeado.");
		} else {
			UsuarioDAO uDAO = new UsuarioDAOImplHibernate();
			List<Usuario> usu = uDAO.listarUsuarios();
	%>

	<!-- Aquí empieza el nav -->

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href=""><img src="../images/Joystick.png"
			width="70" height="70" alt="Logo"> </a>
	</div>

	<!-- Message Error --> <%
 	String error = request.getParameter("mensaje");
 		if (error != null) {
 %>

	<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-6" id="message">
		<div class="alert alert-warning alert-dismissable fade in" id="error">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">x</button>
			<strong>Info!</strong>
			<%=error%>
		</div>
	</div>
	<%
		}
	%> <!-- Top Nav -->

	<ul class="nav navbar-right top-nav">
		<li class="btn btn-toolbar"><a data-toggle="modal"
			data-target="#modalEditarUsuario"><b class="fa fa-user-circle"></b>
				Bienvenido, <%=((Usuario) session.getAttribute("usuLogeado")).getLogin()%></a>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <b class="fa fa-sort-desc"></b></a>
			<ul class="dropdown-menu">
				<li><a href="../CerrarSesion">Cerrar sesión</a></li>
			</ul></li>
	</ul>

	<!-- Side Nav -->

	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li><a href="inicioAdmin.jsp"><i
					class="fa fa fa-backward"> </i> Menú Admin</a></li>
		</ul>
	</div>
	</nav>

	<!-- Cartas -->

	<div class="container-fluid">
		<div class="row" id="row">
			<%
				for (Usuario u : usu) {
			%>
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-4" id="col">
				<div class="card">
					<div class="card-block">
						<div class="image-flip"
							ontouchstart="this.classList.toggle('hover');">
							<div class="mainflip">
								<div class="frontside">
									<div class="card" style="width: 20rem;">
										<div class="card-body">
											<h4 class="card-title"><%=u.getLogin()%></h4>
										</div>
									</div>
								</div>
								<div class="backside">
									<div class="card" style="width: 20rem;">
										<div class="card-body">
											<h4 class="card-title">E-mail</h4>
											<p class="card-text"><%=u.getEmail()%></p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>

	<!-- Modal editar Usuario -->

	<div id="modalEditarUsuario" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="container">
				<div class="row main">
					<div class="main-login main-center">
						<form role="form" method="POST" action="../EditarUsuario"
							enctype="multipart/form-data">
							<div>
								<button type="button" id="close" data-dismiss="modal"
									class="fa fa-close"></button>
							</div>

							<div class="form-group">
								<label for="contraseña" class="cols-sm-2 control-label">Contraseña</label>
								<div class="cols-sm-10">
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-edit"
												aria-hidden="true"></i></span> <input type="password"
												class="form-control" name="password" id="password"
												placeholder="Introduce tu contraseña" required />
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label">E-mail</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="email" id="email"
											placeholder="Introduce tu e-mail" required />
									</div>
								</div>
							</div>

							<div class="form-group ">
								<input type="submit" value="Editar" id="button"
									class="btn btn-primary btn-lg btn-block login-button">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%
		}
	%>

	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>