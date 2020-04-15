/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appnotificaciones;

import com.mycompany.bll.ColaEmpresa;
import com.mycompany.gui.Ventana_Inicio;
import com.mycompany.servidor.Run;
import com.mycompany.servidor.Server;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana_Inicio ventana= new Ventana_Inicio();
                    new Ventana_Inicio().setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });*/
        try{
        Server server= new Server();
                    server.startToListen();
         System.out.print("kbdasndsakj");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existe conexión con el servidor");
        }
    }
    
}
