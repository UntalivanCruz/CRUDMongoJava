/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmongodb;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.model.ReplaceOptions;
//import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

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
       }catch(MongoException error){
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
        }catch(MongoException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public FindIterable<Document> getEquipos(){
        FindIterable<Document> iterable =null;
        try{
           iterable  = this.Equipos.find();
        }catch(MongoException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
        }
        return iterable;
    }

 public FindIterable<Document> getEquipoInsertado(){
        FindIterable<Document> iterable =null;
        try{
           iterable  = this.Equipos.find();
        }catch(MongoException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser ingresado","Importante!", JOptionPane.ERROR_MESSAGE);
        }
        return iterable;
    }

public boolean deleteEquipos(String id){
        try{
            // delete one document
            Bson filter = eq("_id",new ObjectId(id));
       //     Document doc = this.Equipos.findOneAndDelete(filter);
            DeleteResult result = this.Equipos.deleteOne(filter);
            return result.getDeletedCount()>0 ? true : false;
        }catch(MongoException error){
            JOptionPane.showMessageDialog(null, "Registro no pudo ser eliminado","Importante!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
}

    public boolean actualizarEquipos(Document data,String id){
            try{
                        Bson filter = eq("_id", new ObjectId(id));
                        UpdateResult updateResult = this.Equipos.replaceOne(filter, data);
                    return updateResult.getModifiedCount()>0 ? true : false;
            }catch(MongoException error){
                        JOptionPane.showMessageDialog(null, "Registro no pudo ser actualizado","Importante!", JOptionPane.ERROR_MESSAGE);
                        return false;
            }
    }
}
