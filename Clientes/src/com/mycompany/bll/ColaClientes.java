/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bll;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class ColaClientes implements Serializable {
    private Cliente clientes;
    
    public ColaClientes() {
        this.clientes = new Cliente();
        this.clientes.siguiente = null;
    }
    
    public boolean vacia() {
        return (this.getClientes().siguiente == null);
    }
    
    public void borrar() throws Exception {
        try {
            if (this.vacia()) {
                throw new Exception ("No hay más clientes por atender.");
            } else {
                this.setClientes(this.getClientes().siguiente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error borrando clientes de la lista, detalles: " + e.getMessage());
        }
    }
    
    public void meter(Object Id, String Empresa, String Ficha, int Numero, boolean Atendido, int Prioridad) throws Exception {
        try {
            Cliente clienteBusqueda;
            Cliente clienteAux;
            boolean encontrado = false;
            clienteBusqueda = this.getClientes();
            
            while ((clienteBusqueda.siguiente != null) && (!encontrado)) {
                if (clienteBusqueda.siguiente.prioridad < Prioridad) {
                    encontrado = true;
                } else {
                    clienteBusqueda = clienteBusqueda.siguiente;
                }
            }
            
            clienteAux = clienteBusqueda.siguiente;
            clienteBusqueda.siguiente = new Cliente();
            clienteBusqueda = clienteBusqueda.siguiente;
            clienteBusqueda.id = Id;
            clienteBusqueda.empresa = Empresa;
            clienteBusqueda.ficha = Ficha;
            clienteBusqueda.numero = Numero;
            clienteBusqueda.atendido = Atendido;
            clienteBusqueda.prioridad = Prioridad;
            clienteBusqueda.siguiente = clienteAux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error agregando clientes a la lista, detalles: " + e.getMessage());
        }
    }
    
    public Object sacar() throws Exception{
        Object retorno = null;
        if (this.vacia()) {
                JOptionPane.showMessageDialog(null, "No hay más clientes por atender.");
            } else {
                retorno = this.getClientes().siguiente.id;
                this.borrar();
            }
        return retorno;
    }
    
    public int obtenerLargoLista() throws Exception {
        int largo = 0;
        try {
            Cliente oCliente = this.getClientes();
            while ((oCliente.siguiente != null)) {
                largo ++;
                oCliente = oCliente.siguiente;
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el largo de la lista, detalles: " + e.getMessage());
	}
        return largo;
    }
    
     public int buscarNumeroFicha(String Ficha) throws Exception {
        int numero = 0;
        try {
            Cliente clienteBusqueda;
            clienteBusqueda = this.clientes;
            
            while (clienteBusqueda.siguiente != null) {
                
                
                if (clienteBusqueda.siguiente.ficha.equals(Ficha)) {
                    if (clienteBusqueda.siguiente.numero >= numero) {
                        numero = clienteBusqueda.siguiente.numero + 1;
                    }
                }
                clienteBusqueda= clienteBusqueda.siguiente;
            }
            
            if (clienteBusqueda.ficha.equals(Ficha)) {
                    if (clienteBusqueda.numero >= numero) {
                        numero = clienteBusqueda.numero + 1;
                    }
                }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando el número de ficha, detalles: " + e.getMessage());
        }
        return numero;
    }
    
    @Override
    public String toString() {
        String strCola = "";
        try {
            if (!this.vacia()) {
                Cliente nodoBusqueda = this.getClientes().siguiente;
                while (nodoBusqueda.siguiente != null) {
                    strCola += nodoBusqueda.id + " "+nodoBusqueda.empresa +" " + nodoBusqueda.ficha + " " +
                            nodoBusqueda.atendido +" "+ nodoBusqueda.numero+ " " +
                            nodoBusqueda.prioridad + "\n";
                    
                    nodoBusqueda = nodoBusqueda.siguiente;
                }
                strCola += nodoBusqueda.id + " "+nodoBusqueda.empresa +" " + nodoBusqueda.ficha + " " +
                            nodoBusqueda.atendido +" "+ nodoBusqueda.numero+ " " +
                            nodoBusqueda.prioridad+ "\n";
            } else {
                
            }
        } catch (Exception e) {
            
        }
        return strCola;
    }

    /**
     * @return the clientes
     */
    public Cliente getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }
    
}
