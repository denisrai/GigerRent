/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Carro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raison
 */

public class CarroDao extends GenericDAO<Carro> implements Serializable{
    private static final long serialVersionUID = 1L;
    private List listaCarros;

    public CarroDao() {
        super(Carro.class);
    }
    
    //Verificar se nao tem um melhor jeito de fazer a busca 
    public List<Carro> listaCarrosDisponiveis(){
        List<Carro> listaCarros = new ArrayList<Carro>();
        iniciarTransacao();
        
        listaCarros = sessao.createQuery("SELECT c FROM Carro c INNER JOIN c.status s WHERE s.nomeStatus = 'disponivel'").list();

        fecharTransacao();
        
        return listaCarros;
    }
}
