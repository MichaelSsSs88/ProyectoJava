/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.bll.ColaEmpresa;
import com.mycompany.bll.ColaEstaciones;
import com.mycompany.gui.Ventana_Inicio;
import com.mycompany.gui.Ventana_Inicio2;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Object;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Proyectos_2 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inicio2().setVisible(true);
            }
        });
         /*ColaEstaciones estaciones= new ColaEstaciones();
         ColaEmpresa empresa= new ColaEmpresa();
         
         
        try {
            String [] Tramites= {"Marchamos", "Dolares"};
            estaciones.meter("Caja", 1, Tramites,"Pedro", 0);
            Tramites= new String[3];
            Tramites[0]= "Dolares";
            Tramites[1]= "Prestamo";
            Tramites[2]= "Luz";
            estaciones.meter("Caja", 2, Tramites,"Marlon", 0);
            Tramites= new String[3];
            Tramites[0]= "Euros";
            Tramites[1]= "Prestamo";
            Tramites[2]= "Menudo";
            estaciones.meter("Plataforma", 3, Tramites,"Rocio", 1);
            Tramites= new String[3];
            Tramites[0]= "Timbres";
            Tramites[1]= "Impuestos";
            Tramites[2]= "Menudo";
            estaciones.meter("Plataforma", 4, Tramites,"Elena", 1);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Proyectos_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        String [] Tramites= {"Marchamos", "Dolares","Menudo","Impuestos","Timbres"};
        
        try {
            empresa.meter("Banco Central", Tramites , estaciones.getCola(), 0);
            System.out.print(empresa.toString());
        } catch (Exception ex) {
            Logger.getLogger(Proyectos_2.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    */
    }
    
}
