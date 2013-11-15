/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Cliente;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class ClienteDao extends GenericDAO<Cliente> implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClienteDao() {
        super(Cliente.class);
    }
}

