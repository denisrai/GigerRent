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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

    //METODO PRINCIPAL QUE CADASTRA UM NOVO CARRO
    public void adiciona() {
        List<String> nomesExistentes = new ArrayList<String>();
        for (Loja loja : lojaDao.listar()) {
            nomesExistentes.add(loja.getNome());
        }
        //VERIFICO SE O NOME DE FILIAL DIGITADO JA EXISTE NO BANCO
        if (nomesExistentes.contains(nomeLoja)) {
            nomeLoja = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "ESSE NOME DE FILIAL JA EXISTE, TENTE OUTRO", ""));
        } else {
            Loja novaLoja = new Loja();
            novaLoja.setNome(nomeLoja);
            
            //TODO: Ver o logradouro
            novaLoja.setLogradouro(logradouro);

            Cidade cidadeObj = cidadeDao.getObjByName(cidadeSelect);
            novaLoja.setCidade(cidadeObj);

            for (LojaTipo lojaTipo : lojaTipoDao.listar()) {
                if (lojaTipo.getNomeTipo().equals(lojaTipoSelect)) {
                    novaLoja.setLojaTipo(lojaTipo);
                }
            }

            lojaDao.inserir(novaLoja);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "FILIAL CADASTRADA COM SUCESSO!", ""));
        }

    }
    
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

    //METODO QUE ENCONTRA AS CIDADES DE UM CERTO ESTADO
    public void escutandoEstado() {
        if (estadoSelect != null) {
            cidades.clear();
            cidades = cidadeDao.buscaCidadesEstado(estadoSelect);
        }
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

    //GET DINAMICO DO TIPOS DE FILIAIS QUE SAO TRAZIDOS DA BASE DE DADOS
    public List<String> getLojasTipoStr() {
        lojasTipoStr.clear();
        List<LojaTipo> lojasTipo = lojaTipoDao.listar();
        for (LojaTipo c : lojasTipo) {
            lojasTipoStr.add(c.getNomeTipo());
        }
        return lojasTipoStr;
    }

    public void setTiposfilStr(List<String> lojasTipoStr) {
        this.lojasTipoStr = lojasTipoStr;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
