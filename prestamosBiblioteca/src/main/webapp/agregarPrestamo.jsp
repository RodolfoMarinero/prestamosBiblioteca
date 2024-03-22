<%@ page import="com.mycompany.prestamosbiblioteca.BDLibroMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.BDUsuarioMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.BDPrestamoMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDeLibros" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDeUsuarios" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDePrestamos" %>
<%@ page import="com.mycompany.prestamosbiblioteca.MYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Libro" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Usuario" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Prestamo" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloLibros" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloUsuarios" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloPrestamos" %>
<%@ page import="java.util.LinkedList" %>


<%
    BDPrestamoMYSQL bdP = new BDPrestamoMYSQL();
    int id_libro=Integer.parseInt(request.getParameter("libro"));
    out.println(id_libro);
    int id_usuario=Integer.parseInt(request.getParameter("usuario"));
    String fecha_prestamo = request.getParameter("fecha_prestamoAdd");
    Prestamo p=new Prestamo(0,id_libro,id_usuario,fecha_prestamo,"xxx");
    bdP.registrar(p);
    BDLibroMYSQL bdL = new BDLibroMYSQL();
    LinkedList<Libro> listaL = bdL.obtenerTodos();
    int x=listaL.size();
    Libro l=null;
    for(int i=0;i<x;i++){
        if(id_libro==listaL.get(i).getId()){
            l=listaL.get(i);
            i=x;
        }
    }
    System.out.println("ID:" + l.getId()); 
   l.setDisponibilidad(false);
    //Libro ln=new Libro(l.getId(),l.getTitulo(),l.getAutor(),l.getEditorial(),false);
    bdL.actualizar(l);
%>
<jsp:forward page="index.jsp"/>