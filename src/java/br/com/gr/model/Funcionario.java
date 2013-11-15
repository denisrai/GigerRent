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
@Table(name = "funcionario")
public class Funcionario extends Usuario implements Serializable
{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //int idFuncionario;
    
    String nome;
    String telefone;
    String CNH;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataNascimento;
    Character sexo;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLoja", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Loja loja;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidade", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Cidade cidade;
    
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Sac> sacs = new HashSet<Sac>();
    
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    Set<Aluguel> alugueis = new HashSet<Aluguel>();

    
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
    

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
