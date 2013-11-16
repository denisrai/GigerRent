/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raison
 */
public class UsuarioDao extends GenericDAO<Usuario> implements Serializable {
    private static final long serialVersionUID = 1L;

    public UsuarioDao() {
        super(Usuario.class);
    }
    
    public Usuario getUserByUsername(String username){
        iniciarTransacao();
        Usuario user = (Usuario)sessao.createQuery("from Usuario WHERE username = :username").setParameter("username", username).uniqueResult();
        fecharTransacao();
        return user;
    }
}