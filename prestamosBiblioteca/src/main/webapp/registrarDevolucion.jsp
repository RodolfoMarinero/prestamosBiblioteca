<%@ page import="com.mycompany.prestamosbiblioteca.BDPrestamoMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDePrestamos" %>
<%@ page import="com.mycompany.prestamosbiblioteca.BDLibroMYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ListaDeLibros" %>
<%@ page import="com.mycompany.prestamosbiblioteca.MYSQL" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Prestamo" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloPrestamos" %>
<%@ page import="com.mycompany.prestamosbiblioteca.Libro" %>
<%@ page import="com.mycompany.prestamosbiblioteca.ModeloLibros" %>
<%@ page import="java.util.LinkedList" %>

<%
    BDPrestamoMYSQL bdP = new BDPrestamoMYSQL();
    int id=Integer.parseInt(request.getParameter("txtIdAct"));
    int id_libro=Integer.parseInt(request.getParameter("txtId_libroAct"));
    int id_usuario=Integer.parseInt(request.getParameter("txtId_usuarioAct"));
    String fecha_prestamo=request.getParameter("txtFecha_prestamoAct");
    String fecha_devolucion=request.getParameter("txtFecha_devolucionAct");
    Prestamo p=new Prestamo(id,id_libro,id_usuario,fecha_prestamo,fecha_devolucion);
    bdP.actualizar(p);
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
    l.setDisponibilidad(true);
    //Libro ln=new Libro(l.getId(),l.getTitulo(),l.getAutor(),l.getEditorial(),true);
    bdL.actualizar(l);
%>
<jsp:forward page="index.jsp"/>