/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Modelo;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class ModeloDao extends GenericDAO<Modelo> implements Serializable {
    private static final long serialVersionUID = 1L;

    public ModeloDao() {
        super(Modelo.class);
    }
}
