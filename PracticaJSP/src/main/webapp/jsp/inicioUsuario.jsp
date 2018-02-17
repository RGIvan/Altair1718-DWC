<%@page import="es.altair.bean.Usuario"%>
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
<link rel="stylesheet" href="../css/modal.css">
<link rel="stylesheet" href="../css/card.css">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Menú</title>
</head>
<body>

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
		<div class="row justify-content-center">
			<div class="alert alert-warning alert-dismissable fade in" id="error">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<strong>Info!</strong>
				<%=error%>
			</div>
		</div>
	</div>
	<%
		}
	%> <!-- Top Nav -->

	<ul class="nav navbar-right top-nav">
		<li class="btn btn-toolbar"><a data-toggle="modal"
			data-target="#"><b class="fa fa-user-circle"></b> Bienvenido, <%=((Usuario) session.getAttribute("usuLogeado")).getNombre()%></a>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <b class="fa fa-sort-desc"></b></a>
			<ul class="dropdown-menu">
				<li><a href="../CerrarSesion">Cerrar sesión</a></li>
			</ul></li>

	</ul>

	<!-- Side Nav -->

	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li><a href="#" data-toggle="collapse"><i
					class="fa fa-fw fa-dashboard"></i> Colección de juegos</a></li>
			<li><a href="#"><i class="fa fa fa-plus-square"></i> Crear
					juego</a></li>
		</ul>
	</div>
	</nav>

	<ul class="alphabet">
		<li>A</li>
		<li>B</li>
		<li>C</li>
		<li>D</li>
		<li>E</li>
		<li>F</li>
		<li>G</li>
		<li>H</li>
		<li>I</li>
		<li>J</li>
		<li>K</li>
		<li>L</li>
		<li>M</li>
		<li>N</li>
		<li>O</li>
		<li>P</li>
		<li>Q</li>
		<li>R</li>
		<li>S</li>
		<li>T</li>
		<li>U</li>
		<li>V</li>
		<li>W</li>
		<li>X</li>
		<li>Y</li>
		<li>Z</li>
	</ul>

	<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-6">
		<div class="row justify-content-center">
			<div class="image-flip"
				ontouchstart="this.classList.toggle('hover');">
				<div class="mainflip">
					<div class="frontside">
						<div class="card" style="width: 20rem;">
							<img class="card-img-top img- fluid"
								src="https://vignette.wikia.nocookie.net/es.megaman/images/d/de/Caratula_Japones%C3%A1_%28Nintendo_DS%29.jpg/revision/latest?cb=20150716153829"
								alt="card image">
							<div class="card-body">
								<h4 class="card-title">Mega Man</h4>
							</div>
						</div>
					</div>
					<div class="backside">
						<div class="card" style="width: 20rem;">
							<div class="card-body">
								<h4 class="card-title">Consola</h4>
								<p class="card-text">SNES</p>
								<h4 class="card-title">Año</h4>
								<p class="card-text">1993</p>
								<h4 class="card-title">Categoría</h4>
								<p class="card-text">RPG</p>
								<h4 class="card-title">Desarrolladora</h4>
								<p class="card-text">Capcom</p>
							</div>
							<a href="#" class="btn btn-success">Añadir</a> <a href="#"
								class="btn btn-danger">Eliminar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>


</html>