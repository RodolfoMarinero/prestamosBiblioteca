<%@ page import="com.mycompany.prestamosbiblioteca.BDUsuarioMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDeUsuarios" %>
<%@ page import="com.mycompany.prestamosbiblioteca.MYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Usuario" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloUsuarios" %>
<%@ page import="java.util.LinkedList" %>

<%
    BDUsuarioMYSQL bdU = new BDUsuarioMYSQL();
    LinkedList<Usuario> listaU = bdU.obtenerTodos();
    String nombre=request.getParameter("txtNombreAdd");
    String correo=request.getParameter("txtCorreoAdd");
    Usuario u=new Usuario(0,nombre,correo);
    bdU.registrar(u);
%>
<jsp:forward page="index.jsp"/>