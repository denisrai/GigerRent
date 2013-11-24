package br.com.gr.controller;

import br.com.gr.dao.AluguelDao;
import br.com.gr.dao.SacDao;
import br.com.gr.model.Aluguel;
import br.com.gr.model.Sac;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@RequestScoped
public class DashBoardController {
    
    private DashboardModel model;  
    private PieChartModel  listaSacPorTipo; 
    private PieChartModel  listaAlugueisPorStatus;
    
    @PostConstruct
    public void initMyBean(){
        model = new DefaultDashboardModel();  
        DashboardColumn column1 = new DefaultDashboardColumn();  
        DashboardColumn column2 = new DefaultDashboardColumn();  
          
        column1.addWidget("SAC");  
          
        column2.addWidget("Alugueis");  
  
        model.addColumn(column1);  
        model.addColumn(column2);
        
        listaSacPorTipo = new PieChartModel();
        List<Sac> listaSac = new SacDao().listaQtdSacPorTipo();
        Iterator itrSac = listaSac.iterator();
        
        while(itrSac.hasNext()) {
            Object[] element = (Object[]) itrSac.next();
            listaSacPorTipo.set((String) element[1], (Number) element[0]);
        }
        
        listaAlugueisPorStatus = new PieChartModel();
        List<Aluguel> listaAluguel = new AluguelDao().listaQtdAlugueisPorStatus();
        Iterator itrAluguel = listaAluguel.iterator();
        
        String texto = "";
        while(itrAluguel.hasNext()) {
            Object[] element = (Object[]) itrAluguel.next();
            if(element[1] == false){
                texto = "Aberto";
            }else{
                texto = "Cancelado";
            }
            
            listaAlugueisPorStatus.set(texto, (Number) element[0]);
        }
        
    }
    
    public void handleReorder(DashboardReorderEvent event) {  
        FacesMessage message = new FacesMessage();  
        message.setSeverity(FacesMessage.SEVERITY_INFO);  
        message.setSummary("Reordenado: " + event.getWidgetId());  
        message.setDetail("Indice do item: " + event.getItemIndex() + ", Coluna: " + event.getColumnIndex() + ", Envio: " + event.getSenderColumnIndex());  
          
        addMessage(message);  
    }  
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
      
    public DashboardModel getModel() {  
        return model;  
    }  
    
    public PieChartModel getListaSacPorTipo() {  
        return listaSacPorTipo;  
    }
    
    public PieChartModel getListaAlugueisPorStatus() {  
        return listaAlugueisPorStatus;  
    }
}
