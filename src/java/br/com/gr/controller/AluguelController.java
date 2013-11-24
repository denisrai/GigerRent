package br.com.gr.controller;

import br.com.gr.dao.AluguelDao;
import br.com.gr.dao.CarroDao;
import br.com.gr.dao.StatusDao;
import br.com.gr.dao.UsuarioDao;
import br.com.gr.model.Carro;
import br.com.gr.model.Cliente;
import br.com.gr.model.Usuario;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.gr.model.Aluguel;
import br.com.gr.model.Status;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@ManagedBean
@SessionScoped
public class AluguelController {
    private AluguelDao aluguelDao = new AluguelDao();
    private CarroDao carroDao = new CarroDao();
    private StatusDao statusCarroDao = new StatusDao();
    
    private Carro carro;
    private Usuario usuario_aluguel;
    Map<String,String> requestParams;
    private String idCarSelected, idUser;
    
    @PostConstruct
    void initMyBean(){
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
        Status reservado = new Status();
        
        aluguel.setCliente((Cliente) usuario_aluguel);
        Date data_reserva = new Date();
        aluguel.setDataReserva(data_reserva);
        Set<Carro> carros = new HashSet<Carro>();
        carros.add(carro);
        aluguel.setCarros(carros);
        aluguelDao.inserir(aluguel);
        
        reservado = statusCarroDao.buscaporId(2);
        carro.setStatus(reservado);
        carroDao.atualiza(carro);
    }
    
    //METODO RESPONSAVEL PELA ELABORAÇÃO E EXIBIÇÃO DO RELATÓRIO JASPER/PDF
    public void imprimeRelatorio(List<Aluguel> lista)
            throws IOException, SQLException {
        //PREENCHO O COLLECTION DATASOURCE CONFORME O RESULTADO DA MINHA LISTA PASSADA POR PARAMETRO
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
            //CAMINHO EM QUE O RELATORIO JASPER SE ENCONTRA
            JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/resources/report/RelatorioAlugueisObj.jasper"), parameters, ds);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
            exporter.exportReport();
            byte[] bytes = baos.toByteArray();
            if (bytes != null && bytes.length > 0) {
                HttpServletResponse response = (HttpServletResponse) facesContext
                        .getExternalContext().getResponse();
                //TIPO 'PDF' SERÁ A SAIDA DO RELATORIO
                response.setContentType("application/pdf");
                //NOME DO ARQUIVO AO SER BAIXADO
                response.setHeader("Content-disposition", "inline; filename=\"relatorioMoni.pdf\"");
                response.setContentLength(bytes.length);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void imprimeRelatorioAluguel(ActionEvent actionEvent) throws IOException, SQLException {
        
        List<Aluguel> dados = aluguelDao.listar();
        
        imprimeRelatorio(dados);
        
    }
}
