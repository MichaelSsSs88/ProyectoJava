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
public class Estacion implements Serializable {
        public Object NombreEstacion;
        public int    NumeroEstacion;
        public Object [] Tramites;
        public Object [] CodigosTramites;
        public Object NombreCajero;
	public int prioridad;
	public Estacion siguiente;
}
