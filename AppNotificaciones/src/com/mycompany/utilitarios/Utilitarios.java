/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utilitarios;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Utilitarios {
     public String Entradas(String mensaje){
        String Entrada= "";
        while(Entrada.compareTo("")==0){
            Entrada=JOptionPane.showInputDialog( mensaje);
            if(Entrada==null){
                JOptionPane.showMessageDialog(null, "Por favor ingresar el dato solicitado");
                Entrada="";
            }
            
        }
        
        return Entrada;
    }
     
     public String EntradaCombo(String mensaje,String [] Lista){
        String Entrada= "";
        Object seleccion;
        while(Entrada.compareTo("")==0){
            seleccion=JOptionPane.showInputDialog(null, mensaje, "Tramites", JOptionPane.QUESTION_MESSAGE, null, Lista, null);
            //Entrada= seleccion.toString();
            if(seleccion==null){
                JOptionPane.showMessageDialog(null, "Por favor ingresar el dato solicitado");
                Entrada="";
            }
            else{
                Entrada= seleccion.toString();
            }
        }
        
        
        return Entrada;
    }
     
      public int Entradas(String mensaje, int menor){
        String Entrada= "";
        int retorno=menor-1;
        while(Entrada.compareTo("")==0){
            Entrada=JOptionPane.showInputDialog( mensaje);
            if(Entrada==null){
                JOptionPane.showMessageDialog(null, "Por favor ingresar el dato solicitado");
                Entrada="";
            }
            else{
                try{
                    retorno= Integer.parseInt(Entrada);
                    if(retorno < menor){
                        Entrada="";
                    }
                }catch(Exception e){
                    Entrada="";
                    JOptionPane.showMessageDialog(null, "El dato solicitado es un numero mayor a " + menor);
                }
                
            }
            
            
        }
        
        return retorno;
    }
    
}
