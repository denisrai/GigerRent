/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.TipoCarro;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class TipoCarroDao extends GenericDAO<TipoCarro> implements Serializable {
    private static final long serialVersionUID = 1L;

    public TipoCarroDao() {
        super(TipoCarro.class);
    }
}
