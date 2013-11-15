package br.com.gr.controller;

import br.com.gr.dao.CidadeDao;
import br.com.gr.dao.UFDao;

import br.com.gr.model.Cidade;
import br.com.gr.model.UF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class CidadeController implements Serializable {

//    private RegiaoDao regiaodao = new RegiaoDao();
    private UFDao ufDao = new UFDao();
    private CidadeDao cidadeDao = new CidadeDao();

    private DataModel listaCidades;
    private Cidade cidade;
    
    private String estadoSelect;

    public String getEstadoSelect() {
        return estadoSelect;
    }

    public void setEstadoSelect(String estadoSelect) {
        this.estadoSelect = estadoSelect;
    }

    public void adicionarCidade(ActionEvent actionEvent){
        cidadeDao.inserir(cidade);
    }
    
    public void alterarCidade(ActionEvent actionEvent){
        cidadeDao.atualiza(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public DataModel getListarCidades() {
        List<Cidade> lista = new CidadeDao().listar();
        listaCidades = new ListDataModel(lista);
        return listaCidades;
    }
    
    public void prepararAdicionarCidade(ActionEvent actionEvent){
        cidade = new Cidade();
    }
    
    public void prepararAlterarCidade(ActionEvent actionEvent){
        cidade = (Cidade)(listaCidades.getRowData());
    }
    
    public String excluirCidade(){
        Cidade cidadeTemp = (Cidade)(listaCidades.getRowData());
        CidadeDao dao = new CidadeDao();
        dao.remove(cidadeTemp);
        return "index";
    }
    
    public List<SelectItem> getAllUF(){
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<UF> listaEstados = ufDao.listar();
        for(UF estado: listaEstados){
            items.add(new SelectItem(estado.getIdUF(), estado.getNome()));
        }
        return items;
     }
}
