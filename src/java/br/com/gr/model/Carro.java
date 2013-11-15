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
public class Carro implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCarro;
    
    String ano;
    String placa;
    String renavam;
    double valorAluguel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCor", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Cor cor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoCarro", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    TipoCarro tipoCarro;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idStatus", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Status status;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLoja", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Loja loja;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModelo", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Modelo modelo;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Carro_has_Aluguel", joinColumns = {@JoinColumn(name = "idCarro")},
            inverseJoinColumns = {@JoinColumn(name = "idAluguel")})
    Set<Aluguel> alugueis = new HashSet<Aluguel>();

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Set<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(Set<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
    
    
}
