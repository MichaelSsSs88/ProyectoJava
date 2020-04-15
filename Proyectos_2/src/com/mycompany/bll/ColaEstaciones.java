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
public class ColaEstaciones implements Serializable {
    private Estacion cola;
    private Estacion primero;
    private int tamanno;
    
    public ColaEstaciones() {
        this.cola = new Estacion();
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
            retorno = this.getCola().siguiente.NombreEstacion;
            this.borrar();
        }
        return retorno;
    }
    public void borrar(String NombreEstacion, int NumeroEstacion) throws Exception{
            Object retorno=null;
            if(this.vacia()){
                
            }
            
            else{
                
                Estacion anterior= this.getCola();
                if(anterior.siguiente==null){
                    anterior= null;
                }
                while(anterior.siguiente!=null){
                    if((anterior.siguiente.NombreEstacion.toString().compareTo(NombreEstacion)!=0)&&
                        (anterior.siguiente.NumeroEstacion==NumeroEstacion)){
                        anterior= anterior.siguiente;
                    }
                    else{
                        Estacion eliminado= anterior.siguiente;
                        anterior.siguiente = eliminado.siguiente;
                        break;
                    }
                }
            }
            
            
        }

    public void meter(Object NombreEstacion, int NumeroEstacion, Object [] Tramites, Object [] CodigosTramites, Object NombreCajero, int prioridad) throws Exception {
        try {
            Estacion nodoBusqueda, nodoAux;
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
            nodoBusqueda.siguiente = new Estacion();
            nodoBusqueda = nodoBusqueda.siguiente;
            nodoBusqueda.NombreEstacion = NombreEstacion;
            nodoBusqueda.NumeroEstacion= NumeroEstacion;
            nodoBusqueda.Tramites= Tramites;
            nodoBusqueda.CodigosTramites = CodigosTramites;
            nodoBusqueda.NombreCajero= NombreCajero;
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
            this.setCola(this.getCola().siguiente);
        } catch (Exception e) {
            throw new Exception("Error borrando datos de la cola, detalles: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        String strCola = "";
        try {
            if (!this.vacia()) {
                Estacion nodoBusqueda = this.getCola().siguiente;
                while (nodoBusqueda.siguiente != null) {
                    strCola += nodoBusqueda.NombreEstacion +" " + nodoBusqueda.NumeroEstacion + ":";
                    for(int i=0; i < nodoBusqueda.Tramites.length; i++){
                        strCola += nodoBusqueda.Tramites[i] +" ";
                        strCola += nodoBusqueda.CodigosTramites[i] +" ";
                    }
                    strCola += "Nombre cajero: "+ nodoBusqueda.NombreCajero + "\n";
                    nodoBusqueda = nodoBusqueda.siguiente;
                }
                strCola += nodoBusqueda.NombreEstacion+" "+ nodoBusqueda.NumeroEstacion  + ":";
                for(int i=0; i < nodoBusqueda.Tramites.length; i++){
                    strCola += nodoBusqueda.Tramites[i] +" ";
                    strCola += nodoBusqueda.CodigosTramites[i] +" ";
                    }
                strCola += "Nombre cajero: "+ nodoBusqueda.NombreCajero +"\n";
            } else {
                
            }
        } catch (Exception e) {
            
        }
        return strCola;
    }
    
    

    /**
     * @param cola the cola to set
     */
    public void setCola(Estacion cola) {
        this.cola = cola;
    }

    /**
     * @return the cola
     */
    public Estacion getCola() {
        return cola;
    }
}
