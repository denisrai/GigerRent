/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Permissao;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class PermissaoDao extends GenericDAO<Permissao> implements Serializable {
    private static final long serialVersionUID = 1L;

    public PermissaoDao() {
        super(Permissao.class);
    }
}