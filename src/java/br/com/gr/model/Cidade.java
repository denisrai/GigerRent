/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import br.com.gr.model.UF;
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
public class Cidade implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCidade;
    
    String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUF", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    UF uf;
    
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Cliente> clientes = new HashSet<Cliente>();
    
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Funcionario> funcionarios = new HashSet<Funcionario>();
    
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Loja> lojas = new HashSet<Loja>();

    public Set<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(Set<Loja> lojas) {
        this.lojas = lojas;
    }
    

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
