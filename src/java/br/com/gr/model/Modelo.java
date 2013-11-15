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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 *
 * @author Junior
 */
@Entity
public class Modelo implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idModelo;
    
    String nomeModelo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMarca", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE) 
    Marca marca;
    
    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Carro> carros = new HashSet<Carro>();

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    
    
}
