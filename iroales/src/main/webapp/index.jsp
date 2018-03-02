<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to.fit=no">
<meta name="keywords" content="html5, dwc, altair">
<meta name="author" content="Iván">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="fonts/font-awesome.min.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet" href="css/modal.css">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Inicio</title>
</head>
<body>
	<!-- Header -->

	<div id="header">
		<img src="images/backloggery.gif" alt="The Backloggery">
	</div>
	
	<!-- Aquí empieza el nav -->

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

	<div class="navbar-header">
		<a class="navbar-brand" href="index.jsp"><img
			src="images/Joystick.png" width="70" height="70" alt="Logo"> </a>
	</div>

	<!-- Message Error -->

	<%
		String error = request.getParameter("mensaje");
		if (error != null) {
	%>

	<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-4" id="message">
			<div class="alert alert-warning alert-dismissable fade in" id="error">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<strong>Info!</strong>
				<%=error%>
			</div>
		</div>
	<%
		}
	%>

	<!-- Top Nav -->

	<ul class="nav navbar-right top-nav">
		<li class="btn btn-toolbar"><a data-toggle="modal"
			data-target="#modalSession"><b class="fa fa-sign-in"></b> Iniciar
				sesión</a>
		<li class="btn btn-toolbar"><a data-toggle="modal"
			data-target="#modalRegister"><b class="fa fa-power-off"></b>
				Regístrate</a>
	</ul>

	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li><a data-toggle="modal" data-target="#"><i
					class="fa fa-fw fa-dashboard"></i> Colección de juegos</a></li>
		</ul>
	</div>
	</nav>

	<!-- Modal Registro -->

	<div id="modalRegister" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="container">
				<div class="row main">
					<div class="main-login main-center">
						<form role="form" method="POST" action="RegistrarUsuario">
							<div>
								<button type="button" id="close" data-dismiss="modal"
									class="fa fa-close"></button>
							</div>
							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label">Usuario</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-users fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="login" id="username"
											placeholder="Introduce tu nombre" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label">Contraseña</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
											type="password" class="form-control" name="password"
											id="password" maxlength="9"
											placeholder="Introduce tu contraseña" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label">E-mail</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
											type="email" class="form-control" name="email" id="email"
											placeholder="Introduce tu e-mail" required />
									</div>
								</div>
							</div>

							<div class="form-group ">
								<input type="submit" value="Regístrate" id="button"
									class="btn btn-primary btn-lg btn-block login-button">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal Registro -->

	<div id="modalSession" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="container">
				<div class="row main">
					<div class="main-login main-center">
						<form method="POST" action="LoginUsuario">
							<div>
								<button type="button" id="close" data-dismiss="modal"
									class="fa fa-close"></button>
							</div>
							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label">Usuario</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-users fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="login" id="username"
											placeholder="Introduce tu nombre" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label">Contraseña</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
											type="password" class="form-control" name="password"
											id="password" placeholder="Introduce tu contraseña" required />
									</div>
								</div>
							</div>
							<div class="form-group ">
								<div class="form-group ">
									<input type="submit" value="Inicia sesión" id="button"
										class="btn btn-primary btn-lg btn-block login-button">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>