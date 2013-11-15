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
public class UF 
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int idUF;
    String nome;
    
    @OneToMany(mappedBy = "uf", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Cidade> cidades = new HashSet<Cidade>();

    public int getIdUF() {
        return idUF;
    }

    public void setIdUF(int idUF) {
        this.idUF = idUF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    
}
