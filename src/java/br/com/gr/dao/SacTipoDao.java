/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.SacTipo;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class SacTipoDao extends GenericDAO<SacTipo> implements Serializable {
    private static final long serialVersionUID = 1L;

    public SacTipoDao() {
        super(SacTipo.class);
    }
}
