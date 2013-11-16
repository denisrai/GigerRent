package br.com.gr.controller;

import br.com.gr.dao.CarroDao;
import br.com.gr.dao.CidadeDao;
import br.com.gr.dao.UFDao;
import br.com.gr.dao.CarroDao;
import br.com.gr.model.Carro;

import br.com.gr.model.Cidade;
import br.com.gr.model.Carro;
import br.com.gr.model.UF;
import java.io.InputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
  
import org.primefaces.model.UploadedFile;  

@ManagedBean
@ViewScoped
public class CarroController implements Serializable {
    
    private CarroDao carroDao = new CarroDao();
    
    private UploadedFile image_car;
    private ListDataModel listaCarros;
    private Carro carro;
    
    private String idCarSelected;
    
    
    @PostConstruct
    public void initMyBean(){
        /**This map contains all the params you submitted from the html form */
        Map<String,String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        idCarSelected = requestParams.get("id_carro");
        
        if (idCarSelected != null) {
            carro = carroDao.buscaporId(Integer.parseInt(idCarSelected));
        }
    }
    
    // Getters e setters
    public UploadedFile getImage_car() {
        return image_car;
    }

    public void setImage_car(UploadedFile image_car) {
        this.image_car = image_car;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public DataModel getListarCarros() {
        List<Carro> lista = carroDao.listar();
        listaCarros = new ListDataModel(lista);
        return listaCarros;
    }
    
    public DataModel getListarCarrosDisponiveis() {
        List<Carro> lista = carroDao.listaCarrosDisponiveis();
        listaCarros = new ListDataModel(lista);
        return listaCarros;
    }

    public void prepararAlterarCarro(ActionEvent actionEvent){
        carro = (Carro)(listaCarros.getRowData());
    }
    
    public void adicionarCarro(ActionEvent actionEvent){
        if(image_car != null) {
            carro.setImage(image_car.getContents());
        }
        
        carroDao.inserir(carro);
    }
    
    public void alterarCarro(ActionEvent actionEvent){
        if(image_car != null) {
            carro.setImage(image_car.getContents());
        }
        carroDao.atualiza(carro);
    }
    
}
