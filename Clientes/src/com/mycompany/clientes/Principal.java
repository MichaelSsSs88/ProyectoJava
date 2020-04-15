/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientes;


import com.miycompany.gui.Ventana_Inicio;
import com.miycompany.gui.Ventana_Inicio2;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inicio().setVisible(true);
            }
        });*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventana_Inicio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
