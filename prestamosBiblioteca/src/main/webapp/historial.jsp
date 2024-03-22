<%@ page import="com.mycompany.prestamosbiblioteca.BDPrestamoMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Prestamo" %>
<%@ page import="com.mycompany.prestamosbiblioteca.BDUsuarioMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Usuario" %>
<%@ page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Historial de Prestamos</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos personalizados -->
    <style>
        /* Agrega estilos personalizados aquí si es necesario */
    </style>
</head>
<body>
    <div class="container">
        <%
        BDUsuarioMYSQL bdU = new BDUsuarioMYSQL();
        LinkedList<Usuario> listaU = bdU.obtenerTodos();
        String id = request.getParameter("txtID");
        Usuario u = null;
        for(Usuario usuario : listaU){
            if(id.equals(usuario.getId()+"")){
                u = usuario;
                break;
            }
        }
        %>
        <h1>Historial de Prestamos de: <%= u.getNombre() %></h1>

        <%
        BDPrestamoMYSQL bdP = new BDPrestamoMYSQL();
        LinkedList<Prestamo> listaP = bdP.obtenerParaHistorial(u.getId());
        
        %>
        <table class="table table-striped">
                <thead>
                <td>ID</td><td>ID DE LIBRO</td><td>ID DE USUARIO</td><td>FECHA DE PRESTAMO</td><td>FECHA DE DEVOLUCION</td></thead>     
                <%
                for(int i=0;i<listaP.size();i++){
                    out.println(listaP.get(i));
                }
                %>
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

