/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miycompany.gui;

import com.mycompany.bll.ColaEmpresa;
import com.mycompany.bll.ColaClientes;
import com.mycompany.bll.Empresa;
import com.mycompany.bll.Estacion;
import com.mycompany.bll.Cliente;
import com.mycompany.bll.ColaEstaciones;
import com.mycompany.cliente.EnvioServidor;
import com.mycompany.utilitarios.Utilitarios;
import java.awt.Graphics;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Ventana_Inicio extends javax.swing.JFrame {
     FondoPanel fondo= new FondoPanel();
     final String host= "127.0.0.1";
     final int puerto=5000;
     Socket cliente;
     private DataInputStream in;
     private DataOutputStream out;
     EnvioServidor ConexionCliente;
     private final ColaEmpresa ColaEmpresa;
     private Utilitarios Utilitarios;
     private Object [] Tramites;
     private Object [] CodigosTramites;
     
     private ColaClientes oColaClientes;
     private ColaEstaciones ColaEstaciones;
     private String empresa;
     private int numeroFicha = 0;
     private String ficha;
     private boolean atendido;
     private String id = "";
     private String SeleccionEmpresa;
     
     
    /**
     * Creates new form Ventana_Inicio
     */
    public Ventana_Inicio() throws IOException {
             
             this.ConexionCliente= new EnvioServidor();
             this.ColaEstaciones = new ColaEstaciones();
             //this.oColaClientes= new ColaClientes();
             this.oColaClientes= this.ConexionCliente.CargarCLientes();
             /*if(this.oColaClientes!=null){
             System.out.println(this.oColaClientes.toString());
             }*/
             if(this.oColaClientes==null){
                 System.out.println("No hay lista");
             }else{
                 
             }
             this.ConexionCliente= new EnvioServidor();
             this.Utilitarios= new Utilitarios();
             this.Tramites= new String[1];
             this.CodigosTramites = new String[1];
            // this.ColaEmpresa= new ColaEmpresa();
            
             this.ColaEmpresa= ConexionCliente.CargarEmpresa();
             //System.out.println(this.ColaEmpresa.toString());
             int contador=0;
            if(this.ColaEmpresa.getCola().toString()!=null){
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
                SeleccionEmpresa= Utilitarios.EntradaCombo("Seleccione la empresa para la que sirve: ", empresa );
                
                //aux= new Empresa();
                aux=this.ColaEmpresa.getCola();
                //Object [] Tramites;
                
                while(aux.siguiente!= null){
                    if(aux.Empresa!=null){
                        String empresaTemp=(String)aux.Empresa;
                        if(empresaTemp.compareTo(SeleccionEmpresa)==0){
                            //this.CodigosTramites= new String[aux.CodigosTramites.length];
                            Tramites= aux.Tramites;
                            CodigosTramites= aux.CodigosTramites;
                            System.out.println("******************************");
                            System.out.println(CodigosTramites[0]);
                        }
                    }
                    
                    aux= aux.siguiente;
                }
                
                if(aux.Empresa!=null){
                    String empresaTemp=(String)aux.Empresa;
                    if(aux.Empresa.toString().compareTo(SeleccionEmpresa)==0){
                        Tramites= aux.Tramites;
                        CodigosTramites= aux.CodigosTramites;
                        System.out.println("******************************");
                        System.out.println(CodigosTramites[0]);
                    }
                }
                this.setContentPane(fondo);
             initComponents();
             for(int i=0; i< Tramites.length; i++){
                 this.ComboTransaccion.addItem((String) Tramites[i]);
             }
             this.setLocationRelativeTo(null);
             this.jPanel1.setOpaque(false);
            }
                 }
                
            
             
             
             
          
            
        
    }
    
    private String obtenerValor (String pValor) {
        return this.id += pValor;
    }
    
    private String borrarValor() throws Exception {
        String textoAux = this.id;
        this.id = "";
        try {
            for (int i = 0; i < (textoAux.length() - 1); i++) {
                this.id += textoAux.charAt(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay ningun valor para borrar.");
        }
        return this.id;
    }
    
    private String tomarFicha(int Index) throws Exception {
        this.ficha = String.valueOf(CodigosTramites[Index]);
        this.numeroFicha = this.oColaClientes.buscarNumeroFicha(this.ficha);
        String strFicha = "Número de ficha\n" + this.ficha + this.numeroFicha + "\nPor favor espere\nsu turno a\nser atendido.";
        return strFicha;
    }
    
    private void crearArreglo(){
        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboTransaccion = new javax.swing.JComboBox<>();
        LeerCedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ComboCliente = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Digite el número de cédula:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Seleccione el tipo de transacción:");

        ComboTransaccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ComboTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        LeerCedula.setEditable(false);
        LeerCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Seleccione el tipo de cliente:");

        ComboCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ComboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Discapacidad", "Adulto Mayor", "Mujer Embarazada" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("0");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/cliente_2.png"))); // NOI18N
        jButton11.setText("Borrar");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setIconTextGap(-3);
        jButton11.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/cliente_3.png"))); // NOI18N
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/cliente_1.png"))); // NOI18N
        jButton11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/ficha_2.png"))); // NOI18N
        jButton12.setText("Tomar Ficha");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setIconTextGap(-3);
        jButton12.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/ficha_3.png"))); // NOI18N
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/ficha_1.png"))); // NOI18N
        jButton12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LeerCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton11)
                        .addGap(160, 160, 160)
                        .addComponent(jButton12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LeerCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema solicitud de fichas para servicio al cliente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("1"));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("2"));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("3"));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("4"));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("5"));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("6"));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("7"));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("8"));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("9"));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.LeerCedula.setText(this.obtenerValor("0"));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            this.LeerCedula.setText(this.borrarValor());
        } catch (Exception ex) {
            Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
         try {
             // TODO add your handling code here:
             this.oColaClientes= this.ConexionCliente.CargarCLientes();
             //System.out.println(this.oColaClientes.toString());
         } catch (IOException ex) {
             Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }
        if(this.oColaClientes==null){
                 this.oColaClientes= new ColaClientes();
        }
        
        try {
            JOptionPane.showMessageDialog(null, this.tomarFicha(this.ComboTransaccion.getSelectedIndex()));
            this.oColaClientes.meter(this.LeerCedula.getText(), this.SeleccionEmpresa, (String) this.CodigosTramites[this.ComboTransaccion.getSelectedIndex()], this.numeroFicha, false, this.ComboCliente.getSelectedIndex());
            //JOptionPane.showMessageDialog(null, this.tomarFicha(this.ComboTransaccion.getSelectedIndex(), this.LeerCedula.getText()));
            this.oColaClientes.toString();
            //this.ConexionCliente= new EnvioServidor();
            this.ConexionCliente.guardaCLientes(oColaClientes);
            System.out.println(this.oColaClientes.toString());
        } catch (Exception ex) {
            Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed
 public void actualiza(){
    //try {  
            String mensaje/*= in.readUTF()*/;
           // while(true){
            // cliente= new Socket(host, puerto);
             //in= new DataInputStream(cliente.getInputStream()); 
             //mensaje= in.readUTF(); 
             
             //this.jLabel2.setText(mensaje);
             //cliente.close();
             //in.close();
             
             //}
             //}
         //} catch (IOException ex) {
           //  Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
         //}
    
}
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
    private javax.swing.JComboBox<String> ComboCliente;
    private javax.swing.JComboBox<String> ComboTransaccion;
    private javax.swing.JTextField LeerCedula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
