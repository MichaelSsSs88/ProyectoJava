/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bll;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ColaEmpresa implements Serializable {
    private Empresa cola;
    private Empresa primero;
    private int tamanno;
    
    public ColaEmpresa() {
        this.cola = new Empresa();
        this.cola.siguiente = null;
        this.tamanno=0;
    }

    public boolean vacia() {
        return (this.getCola().siguiente == null);
    }

    public Object sacar() throws Exception {
        Object retorno = null;
        if (this.vacia()) {
            throw new Exception("Cola vacía");
        } else {
            retorno = this.getCola().siguiente.Empresa;
            this.borrar();
        }
        return retorno;
    }
    public void borrar(String NombreEmpresa) throws Exception{
            Object retorno=null;
            if(this.vacia()){
                
            }
            
            else{
                
                Empresa anterior= this.getCola();
                if(anterior.siguiente==null){
                    anterior= null;
                }
                while(anterior.siguiente!=null){
                    if(anterior.siguiente.Empresa.toString().compareTo(NombreEmpresa)!=0){
                        anterior= anterior.siguiente;
                    }
                    else{
                        Empresa eliminado= anterior.siguiente;
                        anterior.siguiente = eliminado.siguiente;
                        break;
                    }
                }
    
                /*for(int i=0;i<(posicion-1); i++){
                    anterior= anterior.siguiente;
                }
                 //Nodo nuevo= new Nodo(dato);
                 Nodo eliminado= anterior.siguiente;
                 anterior.siguiente = eliminado.siguiente;
                 this.tamanno--;*/
                
            }
            
            
        }

    public void meter(Object NombreEmpresa, Object [] Tramites, Object [] CodigosTramites, Estacion Lista, int prioridad) throws Exception {
        try {
            Empresa nodoBusqueda;
            Empresa nodoAux;
            boolean encontrado = false;
            nodoBusqueda = this.getCola();
            while ((nodoBusqueda.siguiente != null) && (!encontrado)) {
                if (nodoBusqueda.siguiente.prioridad < prioridad) {
                    encontrado = true;
                } else {
                    nodoBusqueda = nodoBusqueda.siguiente;
                }
            }

            nodoAux = nodoBusqueda.siguiente;
            nodoBusqueda.siguiente = new Empresa();
            nodoBusqueda = nodoBusqueda.siguiente;
            nodoBusqueda.Empresa = NombreEmpresa;
            nodoBusqueda.Tramites= Tramites;
            nodoBusqueda.CodigosTramites = CodigosTramites;
            nodoBusqueda.Estaciones= Lista;
            nodoBusqueda.prioridad = prioridad;
            nodoBusqueda.siguiente = nodoAux;
            this.tamanno++;
        } catch (Exception e) {
            throw new Exception("Error agregando datos a la cola, detalles: " + e.getMessage());
        }
    }
    

    private void borrar() throws Exception {
        try {
            if (this.vacia()) {
                throw new Exception("Cola vacía");
            }
            this.cola = this.getCola().siguiente;
        } catch (Exception e) {
            throw new Exception("Error borrando datos de la cola, detalles: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        String strCola = "";
        try {
            if (!this.vacia()) {
                Empresa nodoBusqueda = this.getCola().siguiente;
                while (nodoBusqueda.siguiente != null) {
                    strCola += nodoBusqueda.Empresa +",";
                    for(int i=0; i <nodoBusqueda.Tramites.length;i++){
                        strCola += nodoBusqueda.Tramites[i] + " ";
                        strCola += nodoBusqueda.CodigosTramites[i] +" ";
                    }
                    strCola += "\n";
                    ColaEstaciones estaciones= new ColaEstaciones();
                    estaciones.setCola(nodoBusqueda.Estaciones);
                    strCola += estaciones.toString();
                    nodoBusqueda = nodoBusqueda.siguiente;
                }
                strCola += nodoBusqueda.Empresa +",";
                    for(int i=0; i <nodoBusqueda.Tramites.length;i++){
                        strCola += nodoBusqueda.Tramites[i] + " ";
                        strCola += nodoBusqueda.CodigosTramites[i] +" ";
                    }
                    strCola += "\n";
                    ColaEstaciones estaciones= new ColaEstaciones();
                    estaciones.setCola(nodoBusqueda.Estaciones);
                    strCola += estaciones.toString();
                    //nodoBusqueda = nodoBusqueda.siguiente;
                    
            } else {
                
            }
        } catch (Exception e) {
            
        }
        return strCola;
    }

    /**
     * @return the cola
     */
    public Empresa getCola() {
        return cola;
    }
    
}
