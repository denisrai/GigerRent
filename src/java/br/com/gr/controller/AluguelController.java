package br.com.gr.controller;

import br.com.gr.dao.CarroDao;
import br.com.gr.dao.UsuarioDao;
import br.com.gr.model.Carro;
import br.com.gr.model.Cliente;
import br.com.gr.model.Usuario;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.gr.model.Aluguel;

import java.util.Date;

@ManagedBean
@RequestScoped
public class AluguelController implements Serializable {
    private Carro carro;
    private Usuario usuario_aluguel;
    Map<String,String> requestParams;
    private String idCarSelected, idUser;
    
    @PostConstruct
    public void initMyBean(){
        requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        idCarSelected = requestParams.get("from_reserva");
        idUser = requestParams.get("id_user");
        
        if(idCarSelected != null){
            carro = new CarroDao().buscaporId(Integer.parseInt(idCarSelected));
        }
        
        if(idUser != null){
            usuario_aluguel = new UsuarioDao().buscaporId(Integer.parseInt(idUser));
        }
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Usuario getUsuario_aluguel() {
        return usuario_aluguel;
    }

    public void setUsuario_aluguel(Usuario usuario_aluguel) {
        this.usuario_aluguel = usuario_aluguel;
    }
    
    public void cadastraAluguel(ActionEvent actionEvent){
        Aluguel aluguel = new Aluguel();
        
        aluguel.setCliente((Cliente) usuario_aluguel);
        Date data_reserva = new Date();
        aluguel.setDataReserva(data_reserva);
        
        
    }
    
}
