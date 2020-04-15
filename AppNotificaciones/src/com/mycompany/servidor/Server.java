/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import com.mycompany.gui.Ventana_Inicio;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Server {
    private ServerSocket sereversocket;
    public Server(){
        try {
            this.sereversocket= new ServerSocket(2324);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void startToListen() throws IOException, Exception{
            Ventana_Inicio ventana= new Ventana_Inicio();
            ventana.setVisible(true);
            while(true){
                    Socket servicio= new Socket();
                    servicio= this.sereversocket.accept();
                    InputStream leer= servicio.getInputStream();
		    DataInputStream flujoDatosEntrada = new DataInputStream(leer);  //Crea un objeto para recibir mensajes del usuario
		    OutputStream escribir = servicio.getOutputStream(); //Objeto para mandar a escribir en el cliente
		    DataOutputStream flujoDatosSalida = new DataOutputStream(escribir);  //Aqui se escriben las cosasx|
                    ObjectInputStream ObjetoDatosEntrada = new ObjectInputStream(servicio.getInputStream());
	            ObjectOutputStream ObjetosDatosSalida = new ObjectOutputStream(escribir); 
                    
                    new Thread(new ClientWorker(servicio,flujoDatosEntrada,flujoDatosSalida,ObjetoDatosEntrada,ObjetosDatosSalida,ventana.FichaAtencion, ventana.FichaAtencion1, ventana.FichaAtencion2)).start();
       
            }
        }
}
