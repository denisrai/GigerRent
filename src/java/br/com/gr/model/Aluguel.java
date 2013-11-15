/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "aluguel")
public class Aluguel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAluguel;
      
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataReserva;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataRetirada;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataDevolucao;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataPrevista;
    
    Boolean multa;
    double valorMulta;
    double valorTotal;
    Boolean cancelado;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Carro_has_Aluguel", joinColumns = {@JoinColumn(name = "idAluguel")},
            inverseJoinColumns = {@JoinColumn(name = "idCarro")})
    Set<Carro> carros = new HashSet<Carro>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFuncionario", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE) 
    Funcionario funcionario;

    
    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

        
    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Boolean getMulta() {
        return multa;
    }

    public void setMulta(Boolean multa) {
        this.multa = multa;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
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

    
    
    
}
