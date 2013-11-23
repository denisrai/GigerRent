package br.com.gr.controller;

import br.com.gr.dao.CarroDao;
import br.com.gr.dao.SacTipoDao;
import br.com.gr.dao.UsuarioDao;
import br.com.gr.model.Carro;
import br.com.gr.model.Cliente;
import br.com.gr.model.Funcionario;
import br.com.gr.model.Loja;
import br.com.gr.model.SacTipo;
import br.com.gr.model.Usuario;
import java.io.IOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@RequestScoped
public class SacController implements Serializable {
    private SacTipo sacTipo;
    private SacTipoDao sacTipoDao = new SacTipoDao();

    public SacTipo getSacTipo() {
        return sacTipo;
    }

    public void setSacTipo(SacTipo sacTipo) {
        this.sacTipo = sacTipo;
    }
    
    public List<SelectItem> getTodosTiposSacs(){
        List<SacTipo> sacsTipos = sacTipoDao.listar();

        List<SelectItem> itens = new ArrayList<SelectItem>(sacsTipos.size());

        for(SacTipo item : sacsTipos){
            itens.add(new SelectItem(item.getIdSACTipo(), item.getNomeSACTipo()));
        }

        return itens;
    }
    
}
