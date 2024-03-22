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
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Biblioteca</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">


    </head>
    <body>
        <div class="container mt-5">
            <h1 class="mb-4">Biblioteca</h1>




            <%
            BDLibroMYSQL bdL = new BDLibroMYSQL();
            LinkedList<Libro> listaL = bdL.obtenerTodos();
            %>
            <div class="container mt-5">
                <h1>Libros</h1>

                <table class="table table-striped">
                    <thead>
                    <td>ID</td><td>TITULO DEL LIBRO</td><td>AUTOR</td><td>EDITORIAL</td><td>DISPONIBILIDAD</td></thead>     
                    <%
                    for(int i=0;i<listaL.size();i++){
                        out.println(listaL.get(i));
                    }
                    %>
                </table>
                <div class="mt-3">
                    <a href="agregarLibroPage.jsp" class="btn btn-primary btn-lg">Agregar un Libro Nuevo</a>
                </div>
                <div class="mt-3">
                    <a href="librosDisponibles.jsp" class="btn btn-primary btn-lg">Ver solo Libros disponibles</a>
                </div>
                <div class="mt-3">
                    <a href="librosPrestados.jsp" class="btn btn-primary btn-lg">Ver solo Libros Prestados</a>
                </div>
            </div>
            <br><br><br>
            <%
        BDPrestamoMYSQL bdP = new BDPrestamoMYSQL();
        LinkedList<Prestamo> listaP = bdP.obtenerTodos();
            %>
            <h1>Prestamos</h1>
            <table class="table table-striped">
                <thead>
                <td>ID</td><td>ID DE LIBRO</td><td>ID DE USUARIO</td><td>FECHA DE PRESTAMO</td><td>FECHA DE DEVOLUCION</td></thead>     
                <%
                for(int i=0;i<listaP.size();i++){
                    out.println(listaP.get(i));
                }
                %>
            </table>
            <div class="mt-3">
                <a href="agregarPrestamoPage.jsp" class="btn btn-primary btn-lg">Agregar un Prestamo Nuevo</a>
            </div>
            <br><br><br>
            <%
        BDUsuarioMYSQL bdU = new BDUsuarioMYSQL();
        LinkedList<Usuario> listaU = bdU.obtenerTodos();
            %>
            <h1>Usuarios</h1>
            <table class="table table-striped">
                <thead>
                <td>ID</td><td>NOMBRE</td><td>CORREO</td><td>HISTORIAL</td></thead>     
                <%
                for(int i=0;i<listaU.size();i++){
                    out.println(listaU.get(i));
                }
                %>
            </table>
            <div class="mt-3">
                <a href="agregarUsuarioPage.jsp" class="btn btn-primary btn-lg">Agregar un Usuario Nuevo</a>
            </div>
        </div>

        <!-- Bootstrap JS (opcional, solo necesario si se requieren componentes de Bootstrap que utilicen JavaScript) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>




    </body>

</html>
