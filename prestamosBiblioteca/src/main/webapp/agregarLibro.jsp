<%@ page import="com.mycompany.prestamosbiblioteca.BDLibroMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDeLibros" %>
<%@ page import="com.mycompany.prestamosbiblioteca.MYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Libro" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloLibros" %>
<%@ page import="java.util.LinkedList" %>

<%
    try{
        BDLibroMYSQL bdL = new BDLibroMYSQL();
        LinkedList<Libro> lista = bdL.obtenerTodos();
        String titulo=request.getParameter("txtTituloAdd");
        String autor=request.getParameter("txtAutorAdd");
        String editorial=request.getParameter("txtEditorialAdd");
        Libro l=new Libro(0,titulo,autor,editorial,true);
        bdL.registrar(l);
        %>
        <jsp:forward page="index.jsp"/>
        <%
    }catch(Exception e){
        out.print(e);
    }
%>
