package br.com.gr.controller;

import br.com.gr.client_ws.CorRest;
import br.com.gr.model_webservice.CorWebService;
import br.com.gr.model_webservice.CoresWebService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

@ManagedBean
@SessionScoped
public class WebServiceController {
    private String listaDeCores;
    private CorWebService novaCor;
    
    
    @PostConstruct
    public void initMyBean(){
        CorRest wsCores = new CorRest();
        novaCor = new CorWebService();
        
        String total = wsCores.countREST();
        String find_first = wsCores.find_XML(String.class, "1"); 
        listaDeCores = wsCores.findAll_XML(String.class);
        
        wsCores.close();
    }
    
    public void adicionarCor(ActionEvent actionEvent){
        CorRest wsCores = new CorRest();
        
        wsCores.create_XML(novaCor);
        
        wsCores.close();
    }

    public CorWebService getNovaCor() {
        return novaCor;
    }

    public void setNovaCor(CorWebService novaCor) {
        this.novaCor = novaCor;
    }
    
    public String getListaDeCores() {
        return listaDeCores;
    }

    public void setListaDeCores(String listaDeCores) {
        this.listaDeCores = listaDeCores;
    }
    
    
//        CorRest wsCores = new CorRest();
//        
//        String total = wsCores.countREST();
//        String find_first = wsCores.find_XML(String.class, "1"); 
//        listaDeCores = wsCores.findAll_XML(String.class);
//        CorWebService cor = new CorWebService();
//        CoresWebService cores = new CoresWebService();
//        
//        JAXBContext jaxbContext = JAXBContext.newInstance(CorWebService.class);
//        JAXBContext jaxbContext_cores = JAXBContext.newInstance(CoresWebService.class);
// 
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        Unmarshaller jaxbUnmarshaller_cores = jaxbContext_cores.createUnmarshaller();
//        
//        cor = (CorWebService) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(find_first)));
//        cores = (CoresWebService) jaxbUnmarshaller_cores.unmarshal(new StreamSource(new StringReader(allXML)));
//        cor = (CorWebService) xs.fromXML(find_first);
//        List cores = (List) xs.fromXML(allXML);
        
//        wsCores.close();

}
