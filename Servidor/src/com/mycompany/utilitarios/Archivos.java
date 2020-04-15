/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utilitarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Archivos implements Serializable {
    
    public void Escribir(Object Lista, String nombre) throws FileNotFoundException, IOException{
        FileOutputStream out= new FileOutputStream(nombre);
        ObjectOutputStream salida= new ObjectOutputStream(out);
        salida.writeObject(Lista);
        salida.flush();
        
    }
    public Object leer(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream in;
        try{
            in= new ObjectInputStream(new FileInputStream(nombre));
        }catch(Exception e){
            return null;
        }
        return in.readObject();
    }
    
}
