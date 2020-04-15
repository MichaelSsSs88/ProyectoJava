/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import com.mycompany.bll.ColaEmpresa;
import com.mycompany.clientenotificacion.EnvioServidor;
import com.mycompany.gui.Ventana_Inicio;
import com.mycompany.utilitarios.Archivos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static javax.xml.ws.Service.Mode.MESSAGE;
import jdk.nashorn.internal.runtime.options.OptionTemplate;
import jdk.nashorn.internal.runtime.options.Options;


/**
 *
 * @author DELL
 */
public class ClientWorker implements Runnable, Serializable {
    
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectInputStream inObject;
    private ObjectOutputStream outObject;
    public JLabel puestoFila;
    public JLabel puestoEstacion;
    public JLabel NumeroEstacion;
    Archivos Archivos;
    ColaEmpresa ColaEmpresa;
    
    public ClientWorker(Socket socket,DataInputStream x,DataOutputStream y, ObjectInputStream a,ObjectOutputStream b, JLabel posicion,JLabel caja,JLabel numero) throws IOException{
        
        this.socket= socket;
        //
        in= x;
        out= y;
        inObject= a;
        outObject= b;
        this.puestoFila=posicion;
        this.puestoEstacion= caja;
        this.NumeroEstacion= numero;
         
         //this.inObject= new ObjectInputStream(new getInputStream(this.socket.getInputStream()));
        //this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
        
    }
    
    private boolean chooseOptions(boolean isConnected, String aux) throws IOException, ClassNotFoundException, Exception{
        //in= new DataInputStream(this.socket.getInputStream());
        //in.close();
       // aux= in.readUTF();
      if(aux!="CLOSE"){
       if(this.inObject==null){
            this.inObject= new ObjectInputStream(this.socket.getInputStream());   
       }
      
       ObjectInputStream captura= this.inObject;
       Object entrada= this.inObject.readObject();
       
       //captura.close();
       //this.inObject.close();
       aux= (String) entrada;}
       
        switch(aux){
            case "MESSAGE":
                this.messagge("Ingreso");
                break;
            case "CONTADOR":
               // this.messagge("Contador");
                break;
            case "INGRESAREMPRESA":
                this.IngresarEmpresa();
                isConnected=false;
                break;
            case "CARGAREMPRESA":
                this.CargarEmpresa();
                isConnected=false;
                break;
            case "MOSTRARCITA":
                EnviarNuevaCita();
                isConnected=false;
                break;
            case "MOSTRARCLIENTES":
                 this.ActualizaPantallaNotificacion();
                 isConnected=false;
                 break;
            case "CLOSE":
                isConnected=false;
                break;          
        }
        
        return isConnected;
    }
    
    private void messagge(String mensaje) throws IOException{
        this.out.writeUTF(mensaje);
        
    }
    
    private void IngresarEmpresa() throws IOException, ClassNotFoundException, Exception{
      
            this.Archivos= new Archivos();
        try {
            this.inObject= new ObjectInputStream(this.socket.getInputStream());
            ColaEmpresa=(ColaEmpresa) this.inObject.readObject();
            //this.inObject.close();
            this.Archivos.Escribir(ColaEmpresa, "Empresa2.txt");
            ColaEmpresa Lista= (ColaEmpresa)this.Archivos.leer("Empresa2.txt");
            System.out.print(Lista.toString());
            
            //this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
            this.outObject.writeObject(Lista);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.print("Adios");
    
       
        this.chooseOptions(false,"CLOSE");
    }
    
    private void CargarEmpresa() throws IOException, ClassNotFoundException, Exception{
      
            this.Archivos= new Archivos();
        try {
            ColaEmpresa Lista= (ColaEmpresa)this.Archivos.leer("Empresa2.txt");
            System.out.print(Lista.toString());
            //this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
            this.outObject.writeObject(Lista);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.print("AdiosCargar");
    
       
        this.chooseOptions(false,"CLOSE");
    }
    
 private void EnviarNuevaCita()throws IOException, ClassNotFoundException, Exception{
      
            this.Archivos= new Archivos();
        
            this.inObject= new ObjectInputStream(this.socket.getInputStream());
            Object c= this.inObject.readObject();
            Object d= this.inObject.readObject();
            Object e= this.inObject.readObject();


            Ventana_Inicio.pruebita=c;
            System.out.println((String) c);
            System.out.println((String) d);
            System.out.println((String) e);
            EnvioServidor CargarDatos= new EnvioServidor();
            Ventana_Inicio.pintarTabla(CargarDatos.CargarCLientes());
            this.puestoFila.setText((String)c);
            this.puestoEstacion.setText((String)d);
            this.NumeroEstacion.setText((String)e);
 }
 
 private void ActualizaPantallaNotificacion()throws IOException, ClassNotFoundException, Exception{
      
            this.Archivos= new Archivos();
        
            this.inObject= new ObjectInputStream(this.socket.getInputStream());
            Object c= this.inObject.readObject();
            EnvioServidor CargarDatos= new EnvioServidor();
            Ventana_Inicio.pintarTabla(CargarDatos.CargarCLientes());
            this.puestoFila.setText((String)c);
            this.puestoEstacion.setText((""));
            this.NumeroEstacion.setText((""));
 }
    
    

    @Override
    public void run() {
        boolean isConected= true;
        while(isConected){
            try {
                isConected= this.chooseOptions(isConected,"INGRESAREMPRESA");
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
   
    

