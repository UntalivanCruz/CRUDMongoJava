/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.crudmongodb;
import com.mongodb.DBObject;

/**
 *
 * @author Developer
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        conexionDB conn1 = new conexionDB();
        conn1.mostrarBD();
        equipos formEquipos = new equipos();
        DBObject registros= formEquipos.getForm();
        conn1.setEquipos(registros);
    }
    
}
