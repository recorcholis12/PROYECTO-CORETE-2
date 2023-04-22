<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Styles/styles.css"></link>
<title>formulario ingreso universidad el bosque</title>
<script language="JavaScript">
	function printValue(form) {
		if (form.career.value == "Biología") {
			alert("El precio de la carrera escogida es: 7.448.000$!");
			return;
		}
		if (form.career.value == "Estadística") {
			alert("El precio de la carrera escogida es: 5.961.000$!");
			return;
		}
		if (form.career.value == "Matemáticas") {
			alert("El precio de la carrera escogida es: 5.228.000$!");
			return;
		}
		if (form.career.value == "Química Farmacéutica") {
			alert("El precio de la carrera escogida es: 7.903.000$!");
			return;
		}
		if (form.career.value == "Derecho") {
			alert("El precio de la carrera escogida es: 8.125.000$!");
			return;
		}
		if (form.career.value == "Arquitectura") {
			alert("El precio de la carrera escogida es: 8.958.000$!");
			return;
		}
		if (form.career.value == "Arte Dramático") {
			alert("El precio de la carrera escogida es: 7.137.000$!");
			return;
		}
		if (form.career.value == "Ingeniería de Sistemas") {
			alert("El precio de la carrera escogida es: 6.605.000$!");
			return;
		}
		if (form.career.value == "Medicina") {
			alert("El precio de la carrera escogida es: 27.195.000$!");
			return;
		}
		if (form.career.value == "Ingeniería Industrial") {
			alert("El precio de la carrera escogida es: 7.300.000$!");
			return;
		}
		if (form.career.value == "Bioingeniería") {
			alert("El precio de la carrera escogida es: 7.494.000$!");
			return;
		}
		if (form.career.value == "Ingeniería Ambiental") {
			alert("El precio de la carrera escogida es: 6.954.000$!");
			return;
		}
		if (form.career.value == "Odontología") {
			alert("El precio de la carrera escogida es: 11.788.000$!");
			return;
		}
		if (form.career.value == "Filosofía") {
			alert("El precio de la carrera escogida es: 3.796.000$!");
			return;
		} else {
			alert("No has elegido ninguna carrera!!");
			return;
		}
	}

	function printNew(form) {
		alert("Nombre completo: " + form.name.value);
		alert("Fecha de nacimiento: " + form.dob.value);

		let hoy = new Date();
		let fechaNacimiento = new Date(form.dob.value);
		let edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
		let diferenciaMeses = hoy.getMonth() - fechaNacimiento.getMonth();
		if (diferenciaMeses < 0
				|| (diferenciaMeses === 0 && hoy.getDate() < fechaNacimiento
						.getDate())) {
			edad--;
		}
		alert("Edad:" + edad);
		alert("Colegio donde se graduó: " + form.college.value);
		alert("Carrera: " + form.career.value);
		alert("Estrato: " + form.status.value);
	}
</script>

</head>
<body>

	<nav class="navbar navbar-expand-custom navbar-mainbg">
		<button class="navbar-toggler" type="button"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fas fa-bars text-white"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<div class="hori-selector">
					<div class="left"></div>
					<div class="right"></div>
	</nav>


	<div id="container">
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEHU9QPB6IfrWJDfYLMpdl4dyBzAQy2wudxA&usqp=CAU"
			alt="Texto alternativo de la imagen" width="200" height="150">
		<h1>&bull; Universidad El Bosque &bull;</h1>
		<div class="underline"></div>
		<form action="http://localhost:8080/prueba/Servlet" method="POST"
			id="contact_form">
			<div class="name">
				<label for="name"></label> <input type="text"
					placeholder="NOMBRE COMPLETO" name="name" id="name_input" required>
			</div>
			<div>
				<label for=""></label> <input type="date"
					placeholder="FECHA DE NACIMIENTO" name="nacimiento" id="" required>
			</div>
			<div class="telephone">
				<label for="name"></label> <input type="text"
					placeholder="COLEGIO DONDE SE GRADUO" name="colegio"
					id="telephone_input" required>
			</div>
			<div class="subject">
				<label for="subject"></label> <select name="career"
					id="subject_input" required>
					<option values="" disabled hidden selected>CARRERA QUE
						DESEA INGRESAR</option>
					<option values="Biología">Biología</option>
					<option values="Estadística">Estadística</option>
					<option values="Matemáticas">Matemáticas</option>
					<option values="Química Farmacéutica">Química Farmacéutica</option>
					<option values="Derecho">Derecho</option>
					<option values="Arquitectura">Arquitectura</option>
					<option values="Arte Dramático">Arte Dramático</option>
					<option values="Ingeniería de Sistemas">Ingeniería de Sistemas</option>
					<option values="Medicina">Medicina</option>
					<option values="Ingeniería Industrial">Ingeniería Industrial</option>
					<option values="Bioingeniería">Bioingeniería</option>
					<option values="Ingeniería Ambiental">Ingeniería Ambiental</option>
					<option values="Odontología">Odontología</option>
					<option values="Filosofía">Filosofía</option>
				</select>
			</div>
			<div class="imagen">
				<label for="name"></label> Suba una foto de usted: <input
					accept="image/*" type="file" multiple>
			</div>
			<div class="subject">
				<label for="subject"></label> <select placeholder="Subject line"
					name="subject" id="subject_input" required>
					<option disabled hidden selected>ESTRATO</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
				</select>
			</div>
			<div>
				<legend class="legendd">¿ES HOMOLOGADO?</legend>
				<div>
					<input class="inputt" type="radio" id="contactChoice1"
						name="contact" value="si" checked /> <label class="labell"
						for="contactChoice1">SI</label> <input class="inputt" type="radio"
						id="contactChoice1" name="contact" value="no" checked /> <label
						class="labell" for="contactChoice1">NO</label>
				</div>
				<BR></BR>
			</div>
			<div class="submit">
				<input type="submit" value="ENVIAR" id="form_button" />
			</div>
			<div>
				<input id="form_button" type="button" align="center"
					value="Mostrar costo de la carrera elegida"
					onClick="printValue(this.form)">
		</form>
	</div>
	
	<div>
		<button class="admin">
			<a href="admin.jsp">Administrador</a>
		</button>
	</div>

</body>

</html>