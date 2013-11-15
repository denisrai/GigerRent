/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 *
 * @author Junior
 */
@Entity
public class LojaTipo implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idLojaTipo;
    
    String nomeTipo;
    
    @OneToMany(mappedBy = "lojaTipo", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Loja> lojas = new HashSet<Loja>();

    public int getIdLojaTipo() {
        return idLojaTipo;
    }

    public void setIdLojaTipo(int idLojaTipo) {
        this.idLojaTipo = idLojaTipo;
    }

    
    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public Set<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(Set<Loja> lojas) {
        this.lojas = lojas;
    }
    
}
