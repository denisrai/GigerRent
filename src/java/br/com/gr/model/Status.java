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
public class Status 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idStatus;
    
    String nomeStatus;
    
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Carro> carros = new HashSet<Carro>();

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }
    
}
