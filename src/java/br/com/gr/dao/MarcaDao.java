/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Marca;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class MarcaDao extends GenericDAO<Marca> implements Serializable {
    private static final long serialVersionUID = 1L;

    public MarcaDao() {
        super(Marca.class);
    }
}
