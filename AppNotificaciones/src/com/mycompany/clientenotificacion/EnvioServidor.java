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
public class EnvioServidor {

    private ColaEmpresa ColaEmpresa;
    private ColaClientes ColaClientes;
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
    
    
    public ColaEmpresa CargarEmpresa() throws IOException, ClassNotFoundException{
        this.ColaEmpresa= new ColaEmpresa();
       
            ConnetToServer c = new ConnetToServer();
           
                    
                    ColaEmpresa= c.CargarEmpresa();
                
                c.cerrarConeccion();
     
    return ColaEmpresa;
}

public ColaClientes CargarCLientes() throws IOException{
        this.ColaClientes= new ColaClientes();
   
         
        try{
           ConnetToServer c = new ConnetToServer();
           
                    //c.
                    System.out.println("xxxxxxxxxx");
                    ColaClientes= c.CargarListaClientes();
                    System.out.println(ColaClientes.toString());
                
           c.cerrarConeccion();     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existen listas de usuarios en el servidor");
        }    
         
    return ColaClientes;
}
    
 public void NuevaCita() throws IOException{
        
        try{
            ConnetToServer c = new ConnetToServer();
            String aux="MOSTRARCITA";
            
                if(aux.equalsIgnoreCase("MOSTRARCITA")){
                    //c.
                    
                    c.CargarEmpresa();
                }
                c.cerrarConeccion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existe conexion con el servidor");
        }
        

}
}
