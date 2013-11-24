package br.com.gr.controller;

import br.com.gr.dao.SacDao;
import br.com.gr.dao.SacTipoDao;
import br.com.gr.model.Sac;
import br.com.gr.model.SacTipo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class SacController implements Serializable {
    private SacTipoDao sacTipoDao = new SacTipoDao();
    private SacDao sacDao = new SacDao();
    private int sacTipoSelecionado;
    
    private Sac novoSac;

    @PostConstruct
    public void initMyBean(){
        novoSac = new Sac();
    }

    public int getSacTipoSelecionado() {
        return sacTipoSelecionado;
    }

    public void setSacTipoSelecionado(int sacTipoSelecionado) {
        this.sacTipoSelecionado = sacTipoSelecionado;
    }
    
    public Sac getNovoSac() {
        return novoSac;
    }

    public void setNovoSac(Sac novoSac) {
        this.novoSac = novoSac;
    }

    public List<SelectItem> getTodosTiposSacs(){
        List<SacTipo> sacsTipos = sacTipoDao.listar();
        List<SelectItem> itens = new ArrayList<SelectItem>(sacsTipos.size());
        for(SacTipo item : sacsTipos){
            itens.add(new SelectItem(item.getIdSACTipo(), item.getNomeSACTipo()));
        }
        return itens;
    }
    
    public void enviaSac(ActionEvent actionEvent){
        SacTipo sacTipo = sacTipoDao.buscaporId(sacTipoSelecionado);
        novoSac.setSactipo(sacTipo);
        sacDao.inserir(novoSac);
    }
    
}
