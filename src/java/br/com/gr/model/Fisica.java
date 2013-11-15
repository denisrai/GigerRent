/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author Junior
 */
@Entity

public class Fisica extends Cliente
{
    
    String CPF;


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

       
    
}
