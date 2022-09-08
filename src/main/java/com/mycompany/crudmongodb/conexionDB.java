/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmongodb;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
//Prueba de insertar un objeto a la Coleccion Equipos
//import com.mongodb.BasicDBObject;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Developer
 */
public class conexionDB {
    MongoClient conn;
    String servidor="localhost";
    Integer puerto=27017;

    DB dataBaseSelect;

//Catalogo de Colecciones
    DBCollection Equipos;
//constructor
    public conexionDB(){
       try{
           conn = new MongoClient(servidor,puerto);
           System.out.println("Conexion exitosa");
       }catch(MongoClientException error){
           System.out.println("Error en conexion: " + error.toString());
       }
    }

   public void mostrarBD(){
      //Informativo
        List<String> listDB = conn.getDatabaseNames();
        System.out.println("Bases de datos disponibles: " + listDB);

       dataBaseSelect = conn.getDB("dbLigaNacional");
       System.out.println("DB Selecionada: " + dataBaseSelect.toString());
       
    }

    public boolean setEquipos(DBObject newEquipo){
        Equipos = dataBaseSelect.getCollection("equipos");
       try{
            Equipos.insert(newEquipo);
            JOptionPane.showMessageDialog(null, "Registro creado con exito!","Importante!",JOptionPane.INFORMATION_MESSAGE);
        }catch(MongoClientException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
        }

//Prueba de insertar un objeto a la Coleccion Equipos
 /*      Equipos.insert(new BasicDBObject("nombre","Marathon")
            .append("sede","SPS")
            .append("fundacion","1960")
        );*/
        return true;
    }
}
