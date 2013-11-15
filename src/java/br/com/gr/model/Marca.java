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
public class Marca implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMarca;
    
    String nomeMarca;
    
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Modelo> modelos = new HashSet<Modelo>();

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Set<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(Set<Modelo> modelos) {
        this.modelos = modelos;
    }

    
    
}
