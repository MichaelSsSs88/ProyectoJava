/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import com.mycompany.bll.Cliente;
import com.mycompany.bll.ColaClientes;
import com.mycompany.bll.ColaEmpresa;
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
    Archivos Archivos;
    ColaEmpresa ColaEmpresa;
    private ColaClientes ColaClientes;
    
    public ClientWorker(Socket socket,DataInputStream x,DataOutputStream y, ObjectInputStream a,ObjectOutputStream b) throws IOException{
        
        this.socket= socket;
        //
        in= x;
        out= y;
        inObject= a;
        outObject= b;
         
         
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
            case "CARGARCLIENTES":
                this.CargarListaClientes();
                isConnected=false;
                break;
            case "GUARDARCLIENTES":
                this.GuardarClientes();
                isConnected=false;
                break;
            case "MODIFICACLIENTES":
                this.ModificarClientes();
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
    
     private void GuardarClientes() throws IOException, ClassNotFoundException, Exception{
             this.Archivos= new Archivos();
            
        try {
            this.inObject= new ObjectInputStream(this.socket.getInputStream());
            ColaClientes=(ColaClientes) this.inObject.readObject();
            //this.inObject.close();
            this.Archivos.Escribir(ColaClientes, "ListaClientes.txt");
            ColaClientes Lista= (ColaClientes)this.Archivos.leer("ListaClientes.txt");
            //System.out.print(Lista.toString());
            
            //this.outObject= new ObjectOutputStream(this.socket.getOutputStream());
            System.out.print(Lista.toString());
            this.outObject.writeObject(Lista);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.print("Adios");
    
       
        this.chooseOptions(false,"CLOSE");
    }
     
     private void ModificarClientes() throws IOException, ClassNotFoundException, Exception{
             this.Archivos= new Archivos();
            
        try {
            this.inObject= new ObjectInputStream(this.socket.getInputStream());
            Object c=this.inObject.readObject();
            ColaClientes Lista= (ColaClientes)this.Archivos.leer("ListaClientes.txt");
            Cliente Listaclientes= Lista.getClientes().siguiente;
            
            ColaClientes= new ColaClientes();
            while(Listaclientes.siguiente!=null){
                String comparar= Listaclientes.ficha + String.valueOf(Listaclientes.numero);
                
                if(comparar.compareTo(c.toString())==0){
                    Listaclientes.atendido= true;
                    ColaClientes.meter(Listaclientes.id, Listaclientes.empresa, Listaclientes.ficha, Listaclientes.numero, true, Listaclientes.prioridad);
                    //System.out.println(Listaclientes.empresa + " " + Listaclientes.id.toString()+" " + Listaclientes.ficha.toString() + " " + Listaclientes.numero+ " " + Listaclientes.atendido);
                    System.out.println(c.toString());
                }else{
                    //Object Id, String Empresa, String Ficha, int Numero, boolean Atendido, int Prioridad
                    ColaClientes.meter(Listaclientes.id, Listaclientes.empresa, Listaclientes.ficha, Listaclientes.numero, Listaclientes.atendido, Listaclientes.prioridad);
                }
                Listaclientes=Listaclientes.siguiente;
            }
            if(Listaclientes!=null){
              String comparar= Listaclientes.ficha + String.valueOf(Listaclientes.numero);
             
                if(comparar.compareTo(c.toString())==0){
                    Listaclientes.atendido= true;
                    ColaClientes.meter(Listaclientes.id, Listaclientes.empresa, Listaclientes.ficha, Listaclientes.numero, true, Listaclientes.prioridad);
                     System.out.println(Listaclientes.empresa + " " + Listaclientes.id.toString()+ " " + Listaclientes.atendido);
                }else{
                    ColaClientes.meter(Listaclientes.id, Listaclientes.empresa, Listaclientes.ficha, Listaclientes.numero, Listaclientes.atendido, Listaclientes.prioridad);
                    
                }
            }
            System.out.println("*******************************************************************");
            //Lista= new ColaClientes();
            //Lista.setClientes(Listaclientes);
            System.out.print(this.ColaClientes.toString());
            this.Archivos.Escribir(this.ColaClientes, "ListaClientes.txt");
            this.outObject.writeObject(this.ColaClientes);
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
    
    private void CargarListaClientes() throws IOException, ClassNotFoundException, Exception{
            
            this.Archivos= new Archivos();
        try {
            ColaClientes Lista= new ColaClientes();
            Lista= (ColaClientes)this.Archivos.leer("ListaClientes.txt");
            if(Lista!=null){
            System.out.println(Lista.toString());
            }
            this.outObject.writeObject(Lista);
               
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    
       
        this.chooseOptions(false,"CLOSE");
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
    
   
    

