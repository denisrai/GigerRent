/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.io.Serializable;
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
public class Sac implements Serializable
{
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private int idSac;
    
    private String descricao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSacTipo", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    SacTipo sactipo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)    
    Cliente cliente;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idFuncionario", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE) 
    private Funcionario funcionario;

    public int getIdSac() {
        return idSac;
    }

    public void setIdSac(int idSac) {
        this.idSac = idSac;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public SacTipo getSactipo() {
        return sactipo;
    }

    public void setSactipo(SacTipo sactipo) {
        this.sactipo = sactipo;
    }

    

    
   
}
