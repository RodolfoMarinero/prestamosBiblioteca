<%@ page import="com.mycompany.prestamosbiblioteca.BDLibroMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Libro" %>
<%@ page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Libros Disponibles</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos personalizados -->
    <style>
        /* Agrega estilos personalizados aquí si es necesario */
    </style>
</head>
<body>
    <div class="container">
        <h1>Libros Disponibles</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>TITULO DEL LIBRO</th>
                    <th>AUTOR</th>
                    <th>EDITORIAL</th>
                    <th>DISPONIBILIDAD</th>
                </tr>
            </thead>     
            <% 
            BDLibroMYSQL bdL = new BDLibroMYSQL();
            LinkedList<Libro> librosDisponibles = bdL.obtenerLibrosDisponibles();
            for (Libro libro : librosDisponibles) {
                String disponibilidad = libro.isDisponibilidad() ? "Disponible" : "Prestado";
            %>
            <tr>
                <td><%= libro.getId() %></td>
                <td><%= libro.getTitulo() %></td>
                <td><%= libro.getAutor() %></td>
                <td><%= libro.getEditorial() %></td>
                <td><%= disponibilidad %></td>
            </tr>
            <% } %>
        </table>
        <a href="index.jsp" class="btn btn-primary">Volver</a>
    </div>

    <!-- Bootstrap JS (opcional, solo si necesitas funcionalidades de Bootstrap que requieren JavaScript) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Tu propio JavaScript -->
    <script>
        // Agrega tu propio JavaScript aquí si es necesario
    </script>
</body>
</html>

