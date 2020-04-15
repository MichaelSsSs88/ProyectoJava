/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientenotificacion;

import com.mycompany.bll.ColaClientes;
import com.mycompany.bll.ColaEmpresa;
import com.mycompany.bll.Estacion;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class EnvioServidorPantalla {

    private ColaEmpresa ColaEmpresa;
    public void SiguienteCita(){
      /*  try {
            // TODO code application logic here
            ConnetToServer c = new ConnetToServer();
            Scanner sc= new Scanner(System.in);
            String aux="";
            while(!aux.equalsIgnoreCase("CLOSE")){
                System.out.print("Escriba su opcion: ");
                aux= sc.nextLine();
                if(aux.equalsIgnoreCase("MESSAGE")){
                    System.out.print("Mensaje del servidor: " + c.recibirMensaje(Options.MESSAGE.toString()));
                }
                else if(aux.equalsIgnoreCase("CONTADOR")){
                    System.out.print("Mensaje del servidor: " + c.recibirMensaje(Options.CONTADOR.toString()));
                }
                else if(aux.equalsIgnoreCase("INGRESAREMPRESA")){
                    
                }
            }
            sc.close();
            c.cerrarConeccion();
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void ArchivarEmpresa(ColaEmpresa Empresa) throws IOException{
        try{
            ConnetToServer c = new ConnetToServer();
            String aux="INGRESAREMPRESA";
            
                if(aux.equalsIgnoreCase("INGRESAREMPRESA")){
                    //c.
                    
                    c.IngresarEmpresa(Empresa);
                }
                c.cerrarConeccion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existe conexion con el servidor");
        }    
    
}
    
    
    public ColaEmpresa CargarEmpresa() throws IOException{
        this.ColaEmpresa= new ColaEmpresa();
        try{
            ConnetToServer c = new ConnetToServer();
            String aux="CARGAREMPRESA";
            
                if(aux.equalsIgnoreCase("CARGAREMPRESA")){
                    //c.
                    
                    ColaEmpresa= c.CargarEmpresa();
                }
                c.cerrarConeccion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existe conexion con el servidor");
        }    
    return ColaEmpresa;
}
    
public void NuevaCita(Object boletaCita, Object Estacion, Object NumeroEstacion) throws IOException{
        
        try{
            ConnetToServer c = new ConnetToServer();
            String aux="MOSTRARCITA";
            
                if(aux.equalsIgnoreCase("MOSTRARCITA")){
                    //c.
                    
                    c.EnviarNuevaCita(boletaCita, Estacion,NumeroEstacion);
                }
                c.cerrarConeccion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existe conexion con el servidor");
        }    
   
}

public void ActualizaPantallaNotificacion(ColaClientes cliente) throws IOException, ClassNotFoundException{
    ConnetToServer c = new ConnetToServer();
    c.ActualizaPantallaNotificacion(cliente);
    c.cerrarConeccion();
}
}
