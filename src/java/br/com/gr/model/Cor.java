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
public class Cor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCor;
    
    String nomeCor;
    
    @OneToMany(mappedBy = "cor", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Carro> carros = new HashSet<Carro>();

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }

    public void setNomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }
    
    
}
