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
import com.mycompany.bll.Empresa;
import com.mycompany.clientenotificacion.EnvioServidor;
import com.mycompany.utilitarios.Archivos;
import com.mycompany.utilitarios.Utilitarios;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Ventana_Inicio extends javax.swing.JFrame {
    FondoPanel fondo= new FondoPanel();
    public static Object pruebita;
    private static EnvioServidor ConexionCliente;
    private final Archivos Archivos;
    private final ColaEstaciones ColaEstaciones;
    private static ColaEmpresa ColaEmpresa;
    private static String Empresa;
    private String Usuario;
    private String UsuarioEstacion;
    private int NumeroEstacion;
    private String [] Tareas;
    private static String[][] datos = new String[0][4];
    private static String[] cabeceras = {"Numero de boleta", "Identificación del cliente", "Tipo de transacción", "Estado de la atención"};
    private ColaClientes ColaClientes;
    /**
     * Creates new form Ventana_Usuario
     */
    public Ventana_Inicio() throws IOException, Exception {
        //ColaEmpresa= new ColaEmpresa();
        ConexionCliente= new EnvioServidor();
        System.out.println("dcsdfsdfffffffffffffffffffffffffffffffffffff");
        ColaEmpresa= ConexionCliente.CargarEmpresa();
        System.out.println("dcsdfsdfffffffffffffffffffffffffffffffffffff");
            // this.ColaEmpresa= (ColaEmpresa) this.Archivos.leer("Empresa3.txt");
            //this.ColaEstaciones.setCola(this.ColaEmpresa.getCola().Estaciones);
            
            if(ColaEmpresa.getCola()!=null){
                Empresa aux;//= new Empresa();
                aux=ColaEmpresa.getCola();
                System.out.println(ColaEmpresa.toString());
                int contador=0;
                while(aux.siguiente!= null){
                    if(aux.Empresa!=null){
                        contador=contador + 1;
                    }
                    
                    aux= aux.siguiente;
                }
                contador= contador +1;
                System.out.println(contador);
                String [] empresa= new String[contador];
                
                aux=ColaEmpresa.getCola();
                
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
                Utilitarios Utilitarios = new Utilitarios();
                Empresa= Utilitarios.EntradaCombo("Seleccione la empresa para la que sirve: ", empresa );
                }
            }
        
        this.Usuario= Usuario;
        this.UsuarioEstacion= UsuarioEstacion;
        this.NumeroEstacion= NumeroEstacion;
        this.Tareas=Tareas;
        //this.ColaEmpresa = new ColaEmpresa();
        this.ColaEstaciones = new ColaEstaciones();
        this.Archivos= new Archivos();
        this.ConexionCliente= new EnvioServidor();
        this.setContentPane(fondo);
        
        initComponents();
        this.NombreUsuario.setText(this.Usuario);
        this.NombreEmpresa.setText(this.Empresa);
        this.NombreEstacion.setText(this.UsuarioEstacion);
        this.NumEstacion.setText(String.valueOf(this.NumeroEstacion));
        Ventana_Inicio.pintarTabla(this.ConexionCliente.CargarCLientes());
        this.setLocationRelativeTo(null);
        Ventana_Inicio.FichaAtencion.setText("");
        Ventana_Inicio.FichaAtencion1.setText("");
        Ventana_Inicio.FichaAtencion2.setText("");
        //this.jPanel1.setOpaque(false);
       
        //this.ColaEmpresa= ConexionCliente.CargarEmpresa();
      
        
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public void conteo() throws IOException, ClassNotFoundException{
        while(true){
         Ventana_Inicio.ColaEmpresa= new ColaEmpresa();
         ConexionCliente= new EnvioServidor();
         Ventana_Inicio.ColaEmpresa= ConexionCliente.CargarEmpresa(); 
        
        }
    }
    public static void cargar(){
       
    }
   
    
    private static DefaultTableModel modelo = new DefaultTableModel() {
       
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
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
    
     public static void pintarTabla(ColaClientes ColaClientes) throws Exception {
        int largolista= ColaClientes.obtenerLargoLista();
       String [][] DatosTemp= new String[largolista][4];
       Cliente ColaClienteTemp= ColaClientes.getClientes().siguiente;
       int contar=0;
       String Tramite="";
       while(ColaClienteTemp.siguiente!= null){
           if((ColaClienteTemp.empresa!=null)&&(Empresa!=null)){
           if(ColaClienteTemp.empresa.compareTo(Empresa)==0){
               boolean TareaCajero= false;
              
            if(ColaClienteTemp.atendido==false){
              DatosTemp[contar][0]= ColaClienteTemp.ficha + String.valueOf(ColaClienteTemp.numero);
              DatosTemp[contar][1]= (String) ColaClienteTemp.id ;
              DatosTemp[contar][2]=  Tramite ;
              if(ColaClienteTemp.atendido==false)
              DatosTemp[contar][3]=  "En espera";
              contar +=1;
            }
           
           }}
           ColaClienteTemp= ColaClienteTemp.siguiente;
       }
       if((ColaClienteTemp.empresa!=null)&&(Empresa!=null)){
       if(ColaClienteTemp.empresa.compareTo(Empresa)==0){   
            if(ColaClienteTemp.atendido==false){
              DatosTemp[contar][0]= ColaClienteTemp.ficha + String.valueOf(ColaClienteTemp.numero);
              DatosTemp[contar][1]= (String) ColaClienteTemp.id ;
              DatosTemp[contar][2]=  Tramite ;
              if(ColaClienteTemp.atendido==false)
              DatosTemp[contar][3]=  "En espera";
            }

           }}
         contar= 0;
         for(int i=0; i<DatosTemp.length;i++){
             if(DatosTemp[i][0]!=null){
                 contar +=1;
                 
             }
         }
        //String[][]datos1= new String [contar][4];
        datos= new String [contar][4];
        
        for(int i=0; i<DatosTemp.length;i++){
             if((DatosTemp[i][0]!=null)){
               datos[i][0]= new String();
               datos[i][0]= DatosTemp[i][0];
               datos[i][1]= DatosTemp[i][1];
               datos[i][2]= DatosTemp[i][2];
               datos[i][3]= DatosTemp[i][3];
             }
         }
        modelo.setDataVector(datos, cabeceras);
        jTable1.setModel(modelo);
        if(datos.length>0){
        //FichaAtencion.setText((String) jTable1.getValueAt(0, 0));
        }
        else{
        FichaAtencion.setText("-------");
        //JOptionPane.showMessageDialog(null, "No esxiten personas en la fila");
        }
        //FichaAtencion.setText((String) jTable1.getValueAt(0, 0));
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
        jLabel4 = new javax.swing.JLabel();
        FichaAtencion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NombreEstacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NumEstacion = new javax.swing.JLabel();
        FichaAtencion1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FichaAtencion2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        FichaAtencion1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FichaAtencion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FichaAtencion1.setText("A1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre estación:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Numero estación:");

        FichaAtencion2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FichaAtencion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FichaAtencion2.setText("A1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FichaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FichaAtencion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FichaAtencion2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(FichaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(FichaAtencion1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(FichaAtencion2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
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
    public static javax.swing.JLabel FichaAtencion;
    public static javax.swing.JLabel FichaAtencion1;
    public static javax.swing.JLabel FichaAtencion2;
    private javax.swing.JLabel NombreEmpresa;
    private javax.swing.JLabel NombreEstacion;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel NumEstacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
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
