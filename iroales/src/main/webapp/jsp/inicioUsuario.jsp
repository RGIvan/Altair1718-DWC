<%@page import="es.altair.bean.Usuario"%>
<%@page import="es.altair.bean.Juego"%>
<%@page import="es.altair.dao.JuegoDAOImplHibernate"%>
<%@page import="java.util.List"%>
<%@page import="es.altair.dao.JuegoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to.fit=no">
<meta name="keywords" content="html5, dwc, altair">
<meta name="author" content="Iv�n">

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
<link rel="stylesheet" href="../css/body.css">
<link rel="stylesheet" href="../css/modal_user.css">
<link rel="stylesheet" href="../css/card.css">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Men�</title>
</head>
<body>

	<%
		if (session.getAttribute("usuLogeado") == null || session.isNew()) {
			response.sendRedirect("../index.jsp?mensaje=No te has logeado.");
		} else {
			JuegoDAO jDAO = new JuegoDAOImplHibernate();
			List<Juego> juego = jDAO.listar((Usuario) session.getAttribute("usuLogeado"));
	%>

	<!-- Aqu� empieza el nav -->

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
			data-target="#"><b class="fa fa-user-circle"></b> Bienvenido, <%=((Usuario) session.getAttribute("usuLogeado")).getLogin()%></a>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <b class="fa fa-sort-desc"></b></a>
			<ul class="dropdown-menu">
				<li><a href="../CerrarSesion">Cerrar sesi�n</a></li>
			</ul></li>
	</ul>

	<!-- Side Nav -->

	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li><a href="#" data-toggle="collapse"><i
					class="fa fa-fw fa-dashboard"></i> Colecci�n de juegos</a></li>
			<li><a data-toggle="modal" data-target="#modalCrear"><i
					class="fa fa fa-plus-square"></i> Crear juego</a></li>
		</ul>
	</div>
	</nav>

	<!-- Cartas -->

	<div class="container-fluid">
		<div class="row" id="row">
			<%
				for (Juego j : juego) {
			%>
			<div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-2" id="col">
				<div class="card">
					<div class="card-block">
						<div class="image-flip"
							ontouchstart="this.classList.toggle('hover');">
							<div class="mainflip">
								<div class="frontside">
									<div class="card" style="width: 20rem;">
										<img class="card-img-top img- fluid"
											src="image.jsp?imag=<%=j.getIdJuego()%>" alt="card image"
											width="200" height="150">
										<div class="card-body">
											<h4 class="card-title"><%=j.getTitulo()%></h4>
										</div>
									</div>
								</div>
								<div class="backside">
									<div class="card" style="width: 20rem;">
										<div class="card-body">
											<h4 class="card-title">Estado</h4>
											<p class="card-text">
												<font color="#ffe6cc">Completado</font>
											</p>
											<h4 class="card-title">Consola</h4>
											<p class="card-text"><%=j.getConsola()%></p>
											<h4 class="card-title">A�o</h4>
											<p class="card-text"><%=j.getAno()%></p>
											<h4 class="card-title">Categor�a</h4>
											<p class="card-text"><%=j.getGenero()%></p>
											<h4 class="card-title">Compa��a</h4>
											<p class="card-text"><%=j.getCompania()%></p>
											<h4 class="card-title">UUID</h4>
											<p class="card-text"><%=j.getUuid()%></p>
											<a data-toggle="modal" data-target="#modalEditarJuego"
												class="btn btn-success">Editar</a> <a data-toggle="modal"
												data-target="#modalBorrarJuego" class="btn btn-danger">Eliminar</a>
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

	<!-- Modal crear Juego -->

	<div id="modalCrear" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="container">
				<div class="row main">
					<div class="main-login main-center">
						<form role="form" method="POST" action="../AnadirJuego"
							enctype="multipart/form-data">
							<div>
								<button type="button" id="close" data-dismiss="modal"
									class="fa fa-close"></button>
							</div>
							<div class="form-group">
								<label for="titulo" class="cols-sm-2 control-label">T�tulo</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="titulo" id="titulo"
											placeholder="Introduce el t�tulo" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="consola" class="cols-sm-2 control-label">Consola</label>
								<div class="cols-sm-10">
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-edit"
												aria-hidden="true"></i></span> <input type="text"
												class="form-control" name="consola" id="consola"
												placeholder="Introduce la consola" required />
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="genero" class="cols-sm-2 control-label">Categor�a</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="genero" id="genero"
											placeholder="Introduce el g�nero" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="a�o" class="cols-sm-2 control-label">A�o</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="number"
											class="form-control" name="ano" id="a�o"
											placeholder="Introduce el a�o" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="categoria" class="cols-sm-2 control-label">Estado</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <select class="form-control">
											<option>Completado</option>
											<option>En proceso</option>
											<option>No completado</option>
											<option>Finalizado</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="compa�ia" class="cols-sm-2 control-label">Compa��a</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="compania" id="compania"
											placeholder="Introduce la compa��a" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="uuid" class="cols-sm-2 control-label">UUID</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="number"
											class="form-control" name="uuid" id="uuid"
											placeholder="Introduce un UUID" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="portada" class="cols-sm-2 control-label">Portada</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-image"
											aria-hidden="true"></i></span> <input type="file"
											class="form-control" id="portada" name="portada">
									</div>
								</div>
							</div>

							<div class="form-group ">
								<input type="submit" value="Crear" id="button"
									class="btn btn-primary btn-lg btn-block login-button">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal editar Juego -->

	<div id="modalEditarJuego" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="container">
				<div class="row main">
					<div class="main-login main-center">
						<form role="form" method="POST" action="../EditarJuego"
							enctype="multipart/form-data">
							<div>
								<button type="button" id="close" data-dismiss="modal"
									class="fa fa-close"></button>
							</div>
							<div class="form-group">
								<label for="titulo" class="cols-sm-2 control-label">T�tulo</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="titulo" id="titulo"
											placeholder="Introduce el t�tulo" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="consola" class="cols-sm-2 control-label">Consola</label>
								<div class="cols-sm-10">
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-edit"
												aria-hidden="true"></i></span> <input type="text"
												class="form-control" name="consola" id="consola"
												placeholder="Introduce la consola" required />
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="genero" class="cols-sm-2 control-label">Categor�a</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="genero" id="genero"
											placeholder="Introduce el g�nero" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="a�o" class="cols-sm-2 control-label">A�o</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="number"
											class="form-control" name="ano" id="a�o"
											placeholder="Introduce el a�o" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="categoria" class="cols-sm-2 control-label">Estado</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <select class="form-control">
											<option>Completado</option>
											<option>En proceso</option>
											<option>No completado</option>
											<option>Finalizado</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="compa�ia" class="cols-sm-2 control-label">Compa��a</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="text"
											class="form-control" name="compania" id="compania"
											placeholder="Introduce la compa��a" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="uuid" class="cols-sm-2 control-label">UUID</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-edit"
											aria-hidden="true"></i></span> <input type="number"
											class="form-control" name="uuid" id="uuid"
											placeholder="Introduce UUID" required />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="portada" class="cols-sm-2 control-label">Portada</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-image"
											aria-hidden="true"></i></span> <input type="file"
											class="form-control" id="portada" name="portada">
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

	<!-- Modal Borrar Juego -->

	<%
		for (Juego j : juego) {
	%>

	<div class="modal fade" id="modalBorrarJuego<%=j.getIdJuego()%>"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Borrar Juego</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					�Desea borrar el juego
					<%=j.getTitulo()%>?
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">No</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='../BorrarJuego?uuid=<%=j.getUuid()%>'">S�</button>
				</div>
			</div>
		</div>
	</div>

	<%
		}
	%>

	<%
		}
	%>

	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>