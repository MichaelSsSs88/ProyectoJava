/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bll;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class Cliente implements Serializable {
    public Object id;
    public String empresa;
    public String ficha;
    public int numero;
    public boolean atendido;
    public int prioridad;
    public Cliente siguiente;
    
}
