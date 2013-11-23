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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import org.primefaces.event.FileUploadEvent;
  
import org.primefaces.model.UploadedFile;  

@ManagedBean
//@ViewScoped
@RequestScoped
public class CarroController implements Serializable {
    
    //Primitives
    private static final int BUFFER_SIZE = 6124;  
    
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
    
    public void handleFileUpload(FileUploadEvent event) {
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        File result = new File(extContext.getRealPath("//WEB-INF//files//" + event.getFile().getFileName()));
        System.out.println(extContext.getRealPath("//WEB-INF//files//" + event.getFile().getFileName()));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);

            byte[] buffer = new byte[BUFFER_SIZE];

            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg =
                    new FacesMessage("File Description", "file name: "
                    + event.getFile().getFileName() + "file size: " +
                    event.getFile().getSize() / 1024 + " Kb content type: " +
                    event.getFile().getContentType() + " The file was uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {
            e.printStackTrace();
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }
    
}
