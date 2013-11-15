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
public class TipoCarro 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTipo;
    
    String nomeTipoCarro;
    
    @OneToMany(mappedBy = "tipoCarro", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL) 
    Set<Carro> carros = new HashSet<Carro>();

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNomeTipoCarro() {
        return nomeTipoCarro;
    }

    public void setNomeTipoCarro(String nomeTipoCarro) {
        this.nomeTipoCarro = nomeTipoCarro;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }
    
}
