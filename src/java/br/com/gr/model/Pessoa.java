/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
 
/**
 *
 * @author Raison
 */
@Entity
public class Pessoa implements Serializable {
 
    @Id
    private String username;
    private String password;
    @Column(name = "enable", columnDefinition = "BOOLEAN")
    private boolean enable;
    
    @OneToMany
    private List<Autorizacao> autorizacoes;
 
    public Pessoa() {
    }
 
    //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
 
}
