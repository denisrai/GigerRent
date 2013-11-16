package br.com.gr.controller;

import br.com.gr.dao.CidadeDao;
import br.com.gr.dao.UFDao;
import br.com.gr.dao.LojaDao;
import br.com.gr.dao.LojaTipoDao;

import br.com.gr.model.Cidade;
import br.com.gr.model.Loja;
import br.com.gr.model.LojaTipo;
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
public class LojaController implements Serializable {

//    private RegiaoDao regiaodao = new RegiaoDao();
    private UFDao ufDao = new UFDao();
    private CidadeDao cidadeDao = new CidadeDao();
    private LojaTipoDao lojaTipoDao = new LojaTipoDao();
    private LojaDao lojaDao = new LojaDao();
    private String lojaTipoSelect;
    private String nomeLoja;
    private String logradouro;
    private List<String> nomesLoja = new ArrayList<String>();
    private List<String> lojasTipoStr = new ArrayList<String>();
    private List<String> estados = new ArrayList<String>();
    private List<String> cidades = new ArrayList<String>();
    
    private DataModel listaLojas;
    private Loja loja;
    private String estadoSelect;
    private String cidadeSelect;

    public void adicionarLoja(ActionEvent actionEvent){
        lojaDao.inserir(loja);
    }
    
    public void alterarLoja(ActionEvent actionEvent){
        lojaDao.atualiza(loja);
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    
    public DataModel getListarLojas() {
        List<Loja> lista = new LojaDao().listar();
        listaLojas = new ListDataModel(lista);
        return listaLojas;
    }
    
    public void prepararAdicionarLoja(ActionEvent actionEvent){
        loja = new Loja();
    }
    
    public void prepararAlterarLoja(ActionEvent actionEvent){
        loja = (Loja)(listaLojas.getRowData());
    }
    
    public String excluirLoja(){
        Loja lojaTemp = (Loja)(listaLojas.getRowData());
        LojaDao dao = new LojaDao();
        dao.remove(lojaTemp);
        return "index";
    }
    
    public List<SelectItem> getAllCities(){
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<Cidade> listaCidades = cidadeDao.listar();
        for(Cidade cidade: listaCidades){
            items.add(new SelectItem(cidade.getIdCidade(), cidade.getNome()));
        }
        return items;
     }
    
    public List<UF> getAllUF(){
        return ufDao.listar();
    }

    public List<String> getEstados() {
        estados.clear();
        estados = ufDao.getStringList();
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public String getEstadoSelect() {
        if (estadoSelect == null) {
            return "--Selecione--";
        }
        return estadoSelect;
    }

    public void setEstadoSelect(String estadoSelect) {
        this.estadoSelect = estadoSelect;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public String getCidadeSelect() {
        return cidadeSelect;
    }

    public void setCidadeSelect(String cidadeSelect) {
        this.cidadeSelect = cidadeSelect;
    }

    public String getLojaTipoSelect() {
        return lojaTipoSelect;
    }

    public void setLojaTipoSelect(String lojaTipoSelect) {
        this.lojaTipoSelect = lojaTipoSelect;
    }

    public String getLojaNome() {
        return nomeLoja;
    }

    public void setLojaNome(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public List<String> getNomesLoja() {
        return nomesLoja;
    }

    public void setNomesLoja(List<String> nomesLoja) {
        this.nomesLoja = nomesLoja;
    }
    
    
    //Tela de busca da homepage
    public List<SelectItem> getTodasLojas(){
        List<Loja> lojas = lojaDao.listar();

        List<SelectItem> itens = new ArrayList<SelectItem>(lojas.size());

        for(Loja item : lojas){
            itens.add(new SelectItem(item.getIdLoja(), item.getNome()));
        }

        return itens;
    }
    
    
}
