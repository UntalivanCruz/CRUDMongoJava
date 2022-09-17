/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.crudmongodb;


/**
 *
 * @author Developer
 */
public class main {
    static conexionDB connMongo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear la conexion al motor de la BD(Servidor y el puerto)
        connMongo = new conexionDB();
        //Selecciono la BD a utilizar
        connMongo.setBD();

       //Creamos la coleccion de equipos
        equipos formEquipos = new equipos();
        formEquipos.setVisible(true);

       //Creamos la coleccion de jugadores
        jugadores formJugadores = new jugadores();
        formJugadores.setVisible(true);
    }
    
}
