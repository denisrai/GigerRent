package br.com.gr.controller;

import br.com.gr.dao.UsuarioDao;
import br.com.gr.model.Cliente;
import br.com.gr.model.Funcionario;
import br.com.gr.model.Usuario;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@RequestScoped
public class UsuarioController implements Serializable {
    private Usuario usuario;
    private UsuarioDao usuarioDao = new UsuarioDao();
    Map<String,String> requestParams;
    HttpServletRequest request;
    
    
    private String idCarSelected;
    
//    @Autowired
//    RequestCache requestCache;
//
//    @Autowired
//    @Qualifier("authenticationManager")
//    protected AuthenticationManager authenticationManager;
    
    private Usuario novoUsuario = new Cliente();

    @PostConstruct
    public void initMyBean(){
        requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();  
  
        idCarSelected = requestParams.get("from_reserva");

        usuario = new Usuario();
        usuario = efetuaLogin(usuario);
    }
    
    public Usuario efetuaLogin(Usuario user){
        SecurityContext context = SecurityContextHolder.getContext();
        
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                if("anonymousUser".equals(authentication.getPrincipal())){
                    user = null;
                }else{
                    user =  usuarioDao.getUserByUsername(((User)authentication.getPrincipal()).getUsername());
                }
            }
        }
        
        return user;
    }
    
    public void cadastrarUsuario(ActionEvent actionEvent){
        if(!novoUsuario.getCPF_CNPJ().isEmpty() &&
           !novoUsuario.getUsername().isEmpty() &&
           !novoUsuario.getPassword().isEmpty()){
            
            novoUsuario.setPermissoes("ROLE_USER");
            novoUsuario.setEnable(true);
                    
            usuarioDao.inserir(novoUsuario);
            
//            authenticateUserAndSetSession(novoUsuario, request);
//            usuario = efetuaLogin(novoUsuario);
        }
        
    }
    
    public String continuaAluguel(){
        return "confimaAluguel";
    }
    
    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
 
    public Usuario getUsuario() {
        if (usuario != null){
            return getFuncOrCli(usuario);
        }else {
            return usuario;
        }
    }
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getFuncOrCli(Usuario user) {
        if("ROLE_ADMIN".equals(user.getPermissoes())) {
            return (Funcionario) user;
        } else {
            return (Cliente) user;
        }
    }

    public String getIdCarSelected() {
        return idCarSelected;
    }

    public void setIdCarSelected(String idCarSelected) {
        this.idCarSelected = idCarSelected;
    }

//    private void authenticateUserAndSetSession(Usuario user, HttpServletRequest request){
//        List<GrantedAuthority> lista = new ArrayList<GrantedAuthority>();
//        lista.add(new GrantedAuthorityImpl("ROLE_CLI"));
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), lista);
//        request.getSession();
//        WebAuthenticationDetails detalhes = new WebAuthenticationDetails(request);
//        
//        token.setDetails(detalhes);
//        Authentication authenticatedUser = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
//    }
    
}
