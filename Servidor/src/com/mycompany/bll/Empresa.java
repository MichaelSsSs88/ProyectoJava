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
public class Empresa implements Serializable {
        public Object Empresa;
        public Object [] Tramites;
        public Object [] CodigosTramites;
        public Estacion Estaciones;
	public int prioridad;
	public Empresa siguiente;
}
