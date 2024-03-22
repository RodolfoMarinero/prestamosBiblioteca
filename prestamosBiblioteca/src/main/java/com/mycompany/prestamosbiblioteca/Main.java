/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {
        BDUsuarioMYSQL bd = new BDUsuarioMYSQL();
        LinkedList<Usuario> lista = bd.obtenerTodos();
        System.out.println(lista.size());
        for (int i = 0; i < lista.size(); i++) {
            Usuario r = lista.get(i);
            System.out.println(r);
        }
    }
}
