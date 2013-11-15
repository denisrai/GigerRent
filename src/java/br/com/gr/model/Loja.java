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
public class Loja implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    int idLoja;
    
    String logradouro;
    
    String nome;
    
    @ManyToOne
    @JoinColumn(name = "idCidade", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)        
    Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "idLojaTipo", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)        
    LojaTipo lojaTipo;
    
    @ManyToOne
    @JoinColumn(name = "idTamanho", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    Tamanho tamanho;
    
    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Funcionario> funcionarios = new HashSet<Funcionario>();
    
    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Carro> carros = new HashSet<Carro>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public LojaTipo getTipo() {
        return lojaTipo;
    }

    public void setTipo(LojaTipo tipo) {
        this.lojaTipo = tipo;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    public LojaTipo getLojaTipo() {
        return lojaTipo;
    }

    public void setLojaTipo(LojaTipo lojaTipo) {
        this.lojaTipo = lojaTipo;
    }
    
    
    
}
