/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.bll.ColaEmpresa;
import com.mycompany.bll.ColaEstaciones;
import com.mycompany.bll.Empresa;
import com.mycompany.bll.Estacion;
import com.mycompany.cliente.EnvioServidor;
import com.mycompany.utilitarios.Utilitarios;
import com.mycompany.utilitarios.Archivos;
import java.awt.Graphics;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class Ventana_Inicio extends javax.swing.JFrame {
    
     FondoPanel fondo= new FondoPanel();
     Utilitarios Utilitarios;
     int contador=1;
     
     ColaEmpresa ColaEmpresa;
     ColaEstaciones ColaEstaciones;
     Archivos Archivos;
     
     private ServerSocket servidor= null;
     private Socket cliente;
     final int Puerto=5000;
     private DataInputStream in;
     private DataOutputStream out;
     
     EnvioServidor ConexionCliente;
     
    /**
     * Creates new form Ventana_Inicio
     */
    public Ventana_Inicio() {
        
         
        this.ColaEmpresa = new ColaEmpresa();
        this.ColaEstaciones = new ColaEstaciones();
        this.Archivos= new Archivos();
        this.ConexionCliente= new EnvioServidor();
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        this.jPanel1.setOpaque(false);
        this.Utilitarios= new Utilitarios();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_2.png"))); // NOI18N
        jButton6.setText("Notificaciones");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setIconTextGap(-3);
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_3.png"))); // NOI18N
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_1.png"))); // NOI18N
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_2.png"))); // NOI18N
        jButton7.setText("Administrar");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setIconTextGap(-3);
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_3.png"))); // NOI18N
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_1.png"))); // NOI18N
        jButton7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_2.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setIconTextGap(-3);
        jButton8.setLabel("Servicios");
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_3.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_1.png"))); // NOI18N
        jButton8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_2.png"))); // NOI18N
        jButton9.setText("Tomar Ficha");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setIconTextGap(-3);
        jButton9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_3.png"))); // NOI18N
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/admin_1.png"))); // NOI18N
        jButton9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jButton6.getAccessibleContext().setAccessibleName("Servicios");
        jButton9.getAccessibleContext().setAccessibleName("Fila de atencion");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" SISTEMA ADMINISTRADOR DE TAREAS EMPRESARIALES");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.ColaEstaciones = new ColaEstaciones();
        String empresa=this.Utilitarios.Entradas("Ingrese el nombre de la empresa: ");
        int Numero_Tramites= this.Utilitarios.Entradas("Ingrese el numero de tramites: ", 1);
        String [] Tramites= new String[Numero_Tramites];
        String [] CodigosTramites= new String[Numero_Tramites];
        while(Numero_Tramites >0){
            Tramites[Tramites.length-Numero_Tramites]= Utilitarios.Entradas("Ingrese el tramite numero " + String.valueOf(Tramites.length - Numero_Tramites +1 +" :") );
            CodigosTramites[Tramites.length-Numero_Tramites]= Utilitarios.Entradas("Ingrese el código del tramite numero " + String.valueOf(Tramites.length - Numero_Tramites +1 +" :") );
            Numero_Tramites -=1;
        }
        int Numero_Estaciones= this.Utilitarios.Entradas("Ingrese el numero de estaciones: ", 1);
        int contador=1;
        while(Numero_Estaciones>= contador){
            String NombreEstacion= this.Utilitarios.Entradas("Ingrese el nombre de la estacion " + contador +":");
            int NumeroEstacion= this.Utilitarios.Entradas("Ingrese el numero de la estacion " + contador +":", 1);
            int NumeroTramitesEstacion= this.Utilitarios.Entradas("Ingrese la cantidad de tramites para la " + NombreEstacion + " " + String.valueOf(NumeroEstacion) +":", 1);
            while(NumeroTramitesEstacion>Tramites.length){
                JOptionPane.showMessageDialog(this, "El numero de tramites no puede ser mayor a la cantidad de tramites existentes en la empresa");
                NumeroTramitesEstacion= this.Utilitarios.Entradas("Ingrese la cantidad de tramites para la" + NombreEstacion + " " + String.valueOf(NumeroEstacion), 1);
            }
            String [] TramitesEstacion= new String[NumeroTramitesEstacion];
            String [] CodigosTramitesEstacion= new String[NumeroTramitesEstacion];
            int contador2=1;
            while(NumeroTramitesEstacion >0){
            TramitesEstacion[TramitesEstacion.length-NumeroTramitesEstacion]= Utilitarios.EntradaCombo("Ingrese el tramite numero " + String.valueOf(contador), Tramites );
            CodigosTramitesEstacion[TramitesEstacion.length-NumeroTramitesEstacion]= Utilitarios.EntradaCombo("Ingrese el código del tramite numero " + String.valueOf(contador), Tramites );
            contador2 +=1;
            NumeroTramitesEstacion -=1;
        }
             String NombreColaborador= this.Utilitarios.Entradas("Ingrese el nombe del encargado de la " + NombreEstacion +" "+ String.valueOf(NumeroEstacion)+":");
            try {
                this.ColaEstaciones.meter(NombreEstacion, NumeroEstacion, TramitesEstacion, CodigosTramitesEstacion, NombreColaborador, 1);
            } catch (Exception ex) {
                Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
           contador +=1;
        }
         try {
             //this.ColaEmpresa.meter(empresa, Tramites, this.ColaEstaciones.getCola(), 1);
             this.ColaEmpresa.meter(empresa, Tramites, CodigosTramites, this.ColaEstaciones.getCola() , 1);
             this.ConexionCliente.ArchivarEmpresa(this.ColaEmpresa);
             
         } catch (Exception ex) {
             Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }
         
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {                                         
            this.ColaEmpresa= ConexionCliente.CargarEmpresa();
            // this.ColaEmpresa= (ColaEmpresa) this.Archivos.leer("Empresa3.txt");
            //this.ColaEstaciones.setCola(this.ColaEmpresa.getCola().Estaciones);
            
            if(this.ColaEmpresa.getCola()!=null){
                Empresa aux;//= new Empresa();
                aux=this.ColaEmpresa.getCola();
                System.out.println(this.ColaEmpresa.toString());
                contador=0;
                while(aux.siguiente!= null){
                    if(aux.Empresa!=null){
                        contador=contador + 1;
                    }
                    
                    aux= aux.siguiente;
                }
                contador= contador +1;
                System.out.println(contador);
                String [] empresa= new String[contador];
                
                aux=this.ColaEmpresa.getCola();
                
                contador=0;
                while(aux.siguiente!= null){
                    if(aux.Empresa!=null){
                        empresa[contador]= (String)aux.Empresa;
                        contador=contador + 1;
                    }
                    
                    aux= aux.siguiente;
                }
                if(aux.Empresa!=null){
                empresa[contador]= aux.Empresa.toString();
                String SeleccionEmpresa= Utilitarios.EntradaCombo("Seleccione la empresa para la que sirve: ", empresa );
                
                aux=this.ColaEmpresa.getCola();
                Estacion Estaciones= new Estacion();
                
                while(aux.siguiente!= null){
                    if(aux.Empresa!=null){
                        String empresaTemp=(String)aux.Empresa;
                        if(empresaTemp.compareTo(SeleccionEmpresa)==0){
                            Estaciones= aux.Estaciones;
                        }
                    }
                    
                    aux= aux.siguiente;
                }
                
                if(aux.Empresa!=null){
                    String empresaTemp=(String)aux.Empresa;
                    if(aux.Empresa.toString().compareTo(SeleccionEmpresa)==0){
                        Estaciones= aux.Estaciones;
                    }
                }
                Estacion auxiliar;
                auxiliar= Estaciones;
                
                int contador=0;
                while(Estaciones.siguiente!= null){
                    if(Estaciones.NombreCajero!=null){
                        contador=contador + 1;
                    }
                    
                    Estaciones= Estaciones.siguiente;
                }
                contador= contador + 1;
                String [] EstacionUsuario= new String[contador];
                
                Estaciones= auxiliar;
                //int contador2=0;
                
                int posicion=0;
                while(Estaciones.siguiente!=null){
                    if(Estaciones.NombreCajero!=null){
                        EstacionUsuario[posicion]= (String)Estaciones.NombreCajero;
                        posicion= posicion + 1;
                    }
                    
                    Estaciones= Estaciones.siguiente;
                }
                if(Estaciones!= null){
                    EstacionUsuario[posicion]= Estaciones.NombreCajero.toString();
                }
                String puesto= Utilitarios.EntradaCombo("Seleccione el usuario: ", EstacionUsuario );
                
                Estaciones= auxiliar;
                String [] TramitesCajero= null;
                String EstacionColaborador="";
                int    NumeroEstacion=0;
                
                while(Estaciones.siguiente!=null){
                    if(Estaciones.NombreCajero!=null){
                        String cajero= (String)Estaciones.NombreCajero;
                        if(cajero.compareTo(puesto)==0){
                            EstacionColaborador= (String) Estaciones.NombreEstacion;
                            NumeroEstacion= Estaciones.NumeroEstacion;
                            TramitesCajero= (String[]) Estaciones.Tramites;
                        }
                    }
                    
                    Estaciones= Estaciones.siguiente;
                }
                if(Estaciones.NombreCajero!=null){
                    String cajero= (String)Estaciones.NombreCajero;
                    if(cajero.compareTo(puesto)==0){
                        EstacionColaborador= (String) Estaciones.NombreEstacion;
                        NumeroEstacion= Estaciones.NumeroEstacion;
                        TramitesCajero= (String[]) Estaciones.Tramites;
                    }
                }
                System.out.println(TramitesCajero[0]);
                Ventana_Usuario ventana_usuario= new Ventana_Usuario(SeleccionEmpresa, puesto,EstacionColaborador, NumeroEstacion ,TramitesCajero);
                ventana_usuario.setVisible(true);
                try {
            
          Runtime.getRuntime().exec("java -jar src/Clientes.jar");
        
      } catch (IOException ex) {
      
          System.out.println(ex);
        
      }
                }
                //aux= new Empresa();
                
                
            }
            
        } catch (IOException ex) {
             Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_jButton8ActionPerformed

   class FondoPanel extends JPanel{
       private Image imagen;
       
       @Override
       public void paint(Graphics g){
           imagen = new ImageIcon(getClass().getResource("/com/mycompany/Imagenes/MenuFondo.png")).getImage();
           g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
           setOpaque(false);
           super.paint(g);
       }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
