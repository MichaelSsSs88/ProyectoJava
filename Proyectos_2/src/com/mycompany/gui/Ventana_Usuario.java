/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.bll.Cliente;
import com.mycompany.bll.ColaClientes;
import com.mycompany.bll.ColaEmpresa;
import com.mycompany.bll.ColaEstaciones;
import com.mycompany.cliente.EnvioServidor;
import com.mycompany.utilitarios.Archivos;
import com.mycompany.clientenotificacion.EnvioServidorPantalla;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Ventana_Usuario extends javax.swing.JFrame {
    FondoPanel fondo= new FondoPanel();
    private EnvioServidor ConexionCliente;
    private final EnvioServidorPantalla ConexionPantalla;
    private final Archivos Archivos;
    private final ColaEstaciones ColaEstaciones;
    private final ColaEmpresa ColaEmpresa;
    private String Empresa;
    private String Usuario;
    private String UsuarioEstacion;
    private int NumeroEstacion;
    private String [] Tareas;
    private String [] CodigosTareas;
    private String[][] datos;
    private String[] cabeceras = {"Numero de boleta", "Identificación del cliente", "Tipo de transacción", "Estado de la atención"};
    private ColaClientes ColaCliente;
    /**
     * Creates new form Ventana_Usuario
     */
    public Ventana_Usuario(String Empresa, String Usuario, String UsuarioEstacion, int NumeroEstacion, String [] Tareas, String [] TareasCajero) throws IOException, Exception {
        System.out.print(Usuario);
        this.Empresa=Empresa;
        this.Usuario= Usuario;
        this.UsuarioEstacion= UsuarioEstacion;
        this.ConexionPantalla= new EnvioServidorPantalla();
        this.NumeroEstacion= NumeroEstacion;
        this.Tareas=Tareas;
        this.CodigosTareas= TareasCajero;
        this.ColaEmpresa = new ColaEmpresa();
        this.ColaEstaciones = new ColaEstaciones();
        this.Archivos= new Archivos();
        this.ConexionCliente= new EnvioServidor();
        this.ColaCliente= new ColaClientes();
        this.ColaCliente=this.ConexionCliente.CargarCLientes();
        System.out.println(this.ColaCliente.toString());
        //
        this.setContentPane(fondo);
        
        initComponents();
        this.NombreUsuario.setText(this.Usuario);
        this.NombreEmpresa.setText(this.Empresa);
        this.NombreEstacion.setText(this.UsuarioEstacion);
        this.NumEstacion.setText(String.valueOf(this.NumeroEstacion));
        this.pintarTabla();
        this.setLocationRelativeTo(null);
         try {
           // Object boleta= (Object)this.FichaAtencion.setText((String) this.jTable1.getValueAt(0, 0));
           Object boleta="-----";
           if(datos.length>0){
            boleta= this.jTable1.getValueAt(0, 0);
          }
            this.ConexionPantalla.NuevaCita(boleta, this.UsuarioEstacion, String.valueOf(this.NumeroEstacion));
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.jPanel1.setOpaque(false);
    }
    
    private DefaultTableModel modelo = new DefaultTableModel() {
       
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Ventana_Usuario(String SeleccionEmpresa, String puesto, String EstacionColaborador, int NumeroEstacion, String[] TramitesCajero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void redimensionarMatriz() {
        String[][] respaldo = this.datos;

        this.datos = new String[respaldo.length + 1][4];

        for (int f = 0; f < respaldo.length; f++) {
            for (int c = 0; c < respaldo[f].length; c++) {
                this.datos[f][c] = respaldo[f][c];
            }

        }
    }
    /*
     private Object ListaPrueba(){
         
     }*/
    
     private void pintarTabla() throws Exception {
       int largolista= this.ColaCliente.obtenerLargoLista();
       String [][] DatosTemp= new String[largolista][4];
       Cliente ColaClienteTemp= this.ColaCliente.getClientes().siguiente;
       int contar=0;
       String Tramite="";
       while(ColaClienteTemp.siguiente!= null){
           if(ColaClienteTemp.empresa.compareTo(this.Empresa)==0){
               boolean TareaCajero= false;
               
               for(int i= 0; i< this.CodigosTareas.length;i++){
                   if((ColaClienteTemp.ficha.compareTo(this.CodigosTareas[i])==0)&&(ColaClienteTemp.atendido==false)){
                       TareaCajero=true;
                       Tramite= this.Tareas[i];
                   }                  
               }
            if(TareaCajero){
              DatosTemp[contar][0]= ColaClienteTemp.ficha + String.valueOf(ColaClienteTemp.numero);
              DatosTemp[contar][1]= (String) ColaClienteTemp.id ;
              DatosTemp[contar][2]=  Tramite ;
              if(ColaClienteTemp.atendido==false)
              if(contar==0){
              DatosTemp[contar][3]=  "En atención";
              }else{
              DatosTemp[contar][3]=  "En espera";
              }
              contar +=1;
            }
           
           }
           ColaClienteTemp= ColaClienteTemp.siguiente;
       }
       if(ColaClienteTemp.empresa.compareTo(this.Empresa)==0){
               boolean TareaCajero= false;
               
               for(int i= 0; i< this.CodigosTareas.length;i++){
                   if((ColaClienteTemp.ficha.compareTo(this.CodigosTareas[i])==0)&&(ColaClienteTemp.atendido==false)){
                       TareaCajero=true;
                       Tramite= this.Tareas[i];
                   }                  
               }
            if(TareaCajero){
              DatosTemp[contar][0]= ColaClienteTemp.ficha + String.valueOf(ColaClienteTemp.numero);
              DatosTemp[contar][1]= (String) ColaClienteTemp.id ;
              DatosTemp[contar][2]=  Tramite ;
              if(ColaClienteTemp.atendido==false)
              DatosTemp[contar][3]=  "En espera";
            }

           }
         contar= 0;
         for(int i=0; i<DatosTemp.length;i++){
             if(DatosTemp[i][0]!=null){
                 contar +=1;
                 
             }
         }
        //String[][]datos1= new String [contar][4];
        this.datos= new String [contar][4];
        
        for(int i=0; i<DatosTemp.length;i++){
             if((DatosTemp[i][0]!=null)){
               datos[i][0]= new String();
               datos[i][0]= DatosTemp[i][0];
               datos[i][1]= DatosTemp[i][1];
               datos[i][2]= DatosTemp[i][2];
               datos[i][3]= DatosTemp[i][3];
             }
         }
        
        if(datos.length>0){
        this.modelo.setDataVector(datos, cabeceras);
        this.jTable1.setModel(modelo); 
        this.FichaAtencion.setText((String) this.jTable1.getValueAt(0, 0));
        }else{
        this.FichaAtencion.setText("------");
        }
        
       if(datos.length<1){
            JOptionPane.showMessageDialog(null, "No existen clientes por atender");
            this.dispose();
        }
        /*if(datos.length>0){
        this.FichaAtencion.setText((String) this.jTable1.getValueAt(0, 0));
        }*/
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        FichaAtencion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NombreEstacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NumEstacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pantalla de clientes por atender");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de boleta", "Identificación del Cliente", "Tipo de transacción", "Estado de atención"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Estación:");

        NombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/usuario_2.png"))); // NOI18N
        jButton8.setText("Siguiente cliente");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setIconTextGap(-3);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/usuario_3.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Imagenes/usuario_1.png"))); // NOI18N
        jButton8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Atendiendo a:");

        FichaAtencion.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FichaAtencion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FichaAtencion.setText("A1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Numero Estación:");

        NombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Usuario:");

        NombreEstacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Empresa:");

        NumEstacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(NombreEstacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(NumEstacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FichaAtencion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FichaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(NumEstacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.ConexionCliente= new EnvioServidor();
        try {
            if(datos.length>0){
            this.ColaCliente=this.ConexionCliente.ModifiaEstadoCLientes( this.jTable1.getValueAt(0, 0));
            }
            //this.pintarTabla();
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Ventana_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.pintarTabla();
        } catch (Exception ex) {
            Logger.getLogger(Ventana_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           // Object boleta= (Object)this.FichaAtencion.setText((String) this.jTable1.getValueAt(0, 0));
           Object boleta="----";
           if(datos.length>0){
            boleta= this.jTable1.getValueAt(0, 0);
          }
            this.ConexionPantalla.NuevaCita(boleta, this.UsuarioEstacion, String.valueOf(this.NumeroEstacion));
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
  
    
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
    private javax.swing.JLabel FichaAtencion;
    private javax.swing.JLabel NombreEmpresa;
    private javax.swing.JLabel NombreEstacion;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel NumEstacion;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     * @param Empresa the Empresa to set
     */
    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @param Tareas the Tareas to set
     */
    public void setTareas(String[] Tareas) {
        this.Tareas = Tareas;
    }
}
