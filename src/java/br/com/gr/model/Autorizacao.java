/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Raison
 */
@Entity
public class Autorizacao implements Serializable {
 
    @Id
    private String nome;
 
    public Autorizacao() {
    }
 
    //getter and setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
}
