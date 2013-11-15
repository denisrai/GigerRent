/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Usuario implements Serializable 
{

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //int idCliente;
    
    String nome;
    String logradouro;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidade", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Cidade cidade;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    Set<Sac> sacs = new HashSet<Sac>();
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    Set<Aluguel> alugueis = new HashSet<Aluguel>();
    
    String telefone;
    String CNH;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataNascimento;
    Character sexo;





    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Set<Sac> getSacs() {
        return sacs;
    }

    public void setSacs(Set<Sac> sacs) {
        this.sacs = sacs;
    }

    public Set<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(Set<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
}
