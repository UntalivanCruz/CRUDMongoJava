/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmongodb;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.DB;
import java.util.List;
/**
 *
 * @author Developer
 */
public class conexionDB {
    MongoClient conn;
    String servidor="localhost";
    Integer puerto=27017;

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

      DB dataBaseSelect = conn.getDB("dbLigaNacional");
       System.out.println("DB Selecionada: " + dataBaseSelect.toString());
    }
}
