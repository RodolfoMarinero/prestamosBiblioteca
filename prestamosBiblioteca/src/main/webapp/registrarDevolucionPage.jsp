<%@ page import="com.mycompany.prestamosbiblioteca.BDPrestamoMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDePrestamos" %>
<%@ page import="com.mycompany.prestamosbiblioteca.MYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Prestamo" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloPrestamos" %>
<%@ page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar Devolucion</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Registrar Devolución</h1>

    <%
        BDPrestamoMYSQL bdP = new BDPrestamoMYSQL();
        LinkedList<Prestamo> listaP = bdP.obtenerTodos();
        String id = request.getParameter("txtID");
        Prestamo p = null;
        for(Prestamo prestamo : listaP){
            if(id.equals(prestamo.getId()+"")){
                p = prestamo;
                break;
            }
        }
    %>
    
    <form method="post" action="registrarDevolucion.jsp">
        <div class="form-group">
            <label for="txtIdAct">ID:</label>
            <input type="text" class="form-control" id="txtIdAct" name="txtIdAct" value="<%=p.getId()%>" readonly>
        </div>
        <div class="form-group">
            <label for="txtId_libroAct">ID DEL LIBRO:</label>
            <input type="text" class="form-control" id="txtId_libroAct" name="txtId_libroAct" value="<%=p.getId_libro()%>" readonly>
        </div>
        <div class="form-group">
            <label for="txtId_usuarioAct">ID DEL USUARIO:</label>
            <input type="text" class="form-control" id="txtId_usuarioAct" name="txtId_usuarioAct" value="<%=p.getId_usuario()%>" readonly>
        </div>
        <div class="form-group">
            <label for="txtFecha_prestamoAct">FECHA DEL PRÉSTAMO:</label>
            <input type="text" class="form-control" id="txtFecha_prestamoAct" name="txtFecha_prestamoAct" value="<%=p.getFecha_prestamo()%>" readonly>
        </div>
        <div class="form-group">
            <label for="txtFecha_devolucionAct">FECHA DE LA DEVOLUCIÓN:</label>
            <input type="text" class="form-control" id="txtFecha_devolucionAct" name="txtFecha_devolucionAct" value="">
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
        <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<!-- Bootstrap JS (opcional, solo necesario si se requieren componentes de Bootstrap que utilicen JavaScript) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
