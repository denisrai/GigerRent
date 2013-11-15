/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Carro;
import java.io.Serializable;

/**
 *
 * @author Raison
 */

public class CarroDao extends GenericDAO<Carro> implements Serializable{
    private static final long serialVersionUID = 1L;

    public CarroDao() {
        super(Carro.class);
    }
}
