/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

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
public class Tamanho 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    int idTamanho;
    
    String nomeTamanho;
    
    @OneToMany(mappedBy = "tamanho", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Loja> lojas = new HashSet<Loja>();

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getNomeTamanho() {
        return nomeTamanho;
    }

    public void setNomeTamanho(String nomeTamanho) {
        this.nomeTamanho = nomeTamanho;
    }

    public Set<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(Set<Loja> lojas) {
        this.lojas = lojas;
    }
    
}
