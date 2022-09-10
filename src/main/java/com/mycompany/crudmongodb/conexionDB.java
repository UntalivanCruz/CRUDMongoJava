/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmongodb;

import com.mongodb.MongoClientException;

import com.mongodb.DBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.BasicBSONObject;
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

    MongoDatabase dataBaseSelect;

//Catalogo de Colecciones
    MongoCollection<Document> Equipos;
//constructor
    public conexionDB(){
       try{
           this.conn = MongoClients.create("mongodb://"+servidor+":"+ puerto.toString());
           System.out.println("Conexion exitosa");
       }catch(MongoClientException error){
           System.out.println("Error en conexion: " + error.toString());
       }
    }

   public void setBD(){
       dataBaseSelect = conn.getDatabase("dbLigaNacional");
       System.out.println("DB Selecionada: " + dataBaseSelect.toString());
       this.Equipos = this.dataBaseSelect.getCollection("equipos");
    }

    public boolean setEquipos(Document newEquipo){
       try{
            this.Equipos.insertOne(newEquipo);
            JOptionPane.showMessageDialog(null, "Registro creado con exito!","Importante!",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch(MongoClientException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public FindIterable<Document> getEquipos(){
        FindIterable<Document> iterable =null;
        try{
           iterable  = this.Equipos.find();
        }catch(MongoClientException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
        }
        return iterable;
    }

 public FindIterable<Document> getEquipoInsertado(){
        FindIterable<Document> iterable =null;
        try{
           iterable  = this.Equipos.find();
        }catch(MongoClientException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
        }
        return iterable;
    }
}
