<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.prestamosbiblioteca.BDUsuarioMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.MYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Usuario" %>
<%@ page import="com.mycompany.prestamosbiblioteca.BDLibroMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Libro" %>
<%@ page import="com.mycompany.prestamosbiblioteca.BDPrestamoMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Prestamo" %>
<%@ page import="java.util.LinkedList" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agregar Nuevo Prestamo</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Agregar Nuevo Prestamo</h1>

    <form method="post" action="agregarPrestamo.jsp">
        <div class="form-group">
            <label for="libro">Libro:</label>
            <select class="form-control" id="libro" name="libro" required>
                <option value="">Seleccionar Libro</option>
                <% 
                BDLibroMYSQL bdL = new BDLibroMYSQL();
                LinkedList<Libro> librosDisponibles = bdL.obtenerLibrosDisponibles();
                for (Libro libro : librosDisponibles) {
                %>
                <option value="<%= libro.getId() %>"><%= libro.getTitulo() %></option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <select class="form-control" id="usuario" name="usuario" required>
                <option value="">Seleccionar Usuario</option>
                <% 
                BDUsuarioMYSQL bdU = new BDUsuarioMYSQL();
                LinkedList<Usuario> usuarios = bdU.obtenerTodos();
                for (Usuario usuario : usuarios) {
                %>
                <option value="<%= usuario.getId() %>"><%= usuario.getNombre() %></option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="fecha_prestamoAdd">Fecha de Prestamo:</label>
            <input type="text" class="form-control" id="fecha_prestamoAdd" name="fecha_prestamoAdd" required>
        </div>
        <button type="submit" class="btn btn-primary">Agregar</button>
        <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<!-- Bootstrap JS (opcional, solo necesario si se requieren componentes de Bootstrap que utilicen JavaScript) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
