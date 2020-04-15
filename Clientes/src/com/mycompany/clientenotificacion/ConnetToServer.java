/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientenotificacion;

import com.mycompany.bll.ColaClientes;
import com.mycompany.bll.ColaEmpresa;
import com.mycompany.bll.ColaEstaciones;
import com.mycompany.bll.Estacion;

import com.mycompany.utilitarios.Archivos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DELL
 */
public class ConnetToServer implements Serializable  {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectInputStream inObject;
    private ObjectOutputStream outObject;
    ColaEmpresa ColaEmpresa;
    ColaEstaciones ColaEstaciones;
    Archivos Archivos;
    
    
    public ConnetToServer() throws IOException{
            
            this.socket= new Socket("127.0.0.1",2324);
            this.in =new DataInputStream(this.socket.getInputStream());
            //this.out= new DataOutputStream(this.socket.getOutputStream());
            //this.inObject= new ObjectInputStream(this.socket.getInputStream());
            //this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
            
       
    }
    
    public String recibirMensaje(String opcion) throws IOException{
        String fromserver="";
       // this.out.writeUTF(opcion);
        //fromserver= this.in.readUTF();
        return fromserver;
                
    }
    
    public String IngresarEmpresa(ColaEmpresa empresa) throws IOException  {
        String fromserver="";
       // this.AbrirConeccion();
        /*try {
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject("INGRESAREMPRESA");
             this.ColaEmpresa= new ColaEmpresa();
             this.ColaEmpresa= empresa;
             System.out.println("hola");
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject(this.ColaEmpresa);
             this.outObject.flush();
             //this.in =new DataInputStream(this.socket.getInputStream());
             //this.inObject= new ObjectInputStream(this.in);
             this.ColaEmpresa= new ColaEmpresa();
             this.in =new DataInputStream(this.socket.getInputStream());
             this.inObject= new ObjectInputStream(this.in);
             Object c= (ColaEmpresa)this.inObject.readObject();
             ColaEmpresa= (ColaEmpresa) c;
             System.out.print(c.toString());
             this.Archivos= new Archivos();
             this.Archivos.Escribir(c, "Empresa3.txt");
             
             System.out.print("Fin");
             
             
         } catch (Exception ex) {
             Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        return fromserver;
    }
    
    public ColaEmpresa CargarEmpresa() throws IOException, ClassNotFoundException  {
        String fromserver="";
       // this.AbrirConeccion();
        
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject("CARGAREMPRESA");
             this.outObject.flush();
            // this.in =new DataInputStream(this.socket.getInputStream());
             //this.inObject= new ObjectInputStream(this.in);
             this.ColaEmpresa= new ColaEmpresa();
             this.in =new DataInputStream(this.socket.getInputStream());
             this.inObject= new ObjectInputStream(this.in);
             Object c= (ColaEmpresa)this.inObject.readObject();
             ColaEmpresa= (ColaEmpresa) c;
             System.out.print(c.toString());
             
      
        return ColaEmpresa;
    }
    
    
    public void EnviarNuevaCita(Object numeroBoleta,Object Estacion, Object NumeroEstacion) throws IOException, ClassNotFoundException  {
        String fromserver="";
       // this.AbrirConeccion();
        
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject("MOSTRARCITA");
             this.ColaEmpresa= new ColaEmpresa();
             
             System.out.println("hola");
             //Object c= "Lo logre";
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject(numeroBoleta);
             this.outObject.writeObject(Estacion);
             this.outObject.writeObject(NumeroEstacion);
             this.outObject.flush();
             
      
 
    }
    
    public void ActualizaPantallaNotificacion(ColaClientes clientes) throws IOException, ClassNotFoundException  {
        String fromserver="";
       // this.AbrirConeccion();
        
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject("MOSTRARCLIENTES");
             this.ColaEmpresa= new ColaEmpresa();
             
             System.out.println("hola");
             //Object c= "Lo logre";
             this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
             this.outObject.writeObject(clientes);
             this.outObject.flush();
             
      
 
    }
    
    public void cerrarConeccion() throws IOException{
        this.out= new DataOutputStream(this.socket.getOutputStream());
        this.getOut().writeUTF(Options.CLOSE.toString());
    }
    
    public void AbrirConeccion() throws IOException{
        this.out= new DataOutputStream(this.socket.getOutputStream());
        this.getOut().writeUTF(Options.INGRESAREMPRESA.toString());
    }

    /**
     * @return the out
     */
    public DataOutputStream getOut() {
        return out;
    }
    
}
