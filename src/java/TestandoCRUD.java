
import br.com.gr.model.*;
import br.com.gr.dao.*;
import java.util.ArrayList;
import java.util.List;

public class TestandoCRUD {

    public static void main(String[] args) {
        
//        UsuarioDao user_dao = new UsuarioDao();
//        
//        Funcionario admin = new Funcionario();
//        admin.setUsername("root");
//        admin.setPassword("123");
//        admin.setEnable(true);
//        admin.setPermissoes("ROLE_ADMIN");
//        user_dao.inserir(admin);
        
//        Cliente user = new Cliente();
//        user.setEnable(true);
//        user.setUsername("usuario");
//        user.setPassword("123");
//        user.setPermissoes("ROLE_USER");
//        user_dao.inserir(user);
        
//        RegiaoVO sudeste = new RegiaoVO();
//        RegiaoVO centroOeste = new RegiaoVO();
//        RegiaoVO nordeste = new RegiaoVO();
//        RegiaoVO norte = new RegiaoVO();
//        RegiaoVO sul = new RegiaoVO();
//        sudeste.setDescricao("Sudeste");
//        centroOeste.setDescricao("Centro-Oeste");
//        nordeste.setDescricao("Nordeste");
//        norte.setDescricao("Norte");
//        sul.setDescricao("Sul");
//
//        EstadoVO saoPaulo = new EstadoVO();
//        EstadoVO riodeJaneiro = new EstadoVO();
//        EstadoVO bahia = new EstadoVO();
//        EstadoVO minasGerais = new EstadoVO();
//        EstadoVO parana = new EstadoVO();
//        EstadoVO espiritoSanto = new EstadoVO();
//        saoPaulo.setNomeEstado("São Paulo");
//        saoPaulo.setRegiao(sudeste);
//        riodeJaneiro.setNomeEstado("Rio de Janeiro");
//        riodeJaneiro.setRegiao(sudeste);
//        bahia.setNomeEstado("Bahia");
//        bahia.setRegiao(nordeste);
//        minasGerais.setNomeEstado("Minas Gerais");
//        minasGerais.setRegiao(sudeste);
//        parana.setNomeEstado("Paraná");
//        parana.setRegiao(sul);
//        espiritoSanto.setNomeEstado("Espírito Santo");
//        espiritoSanto.setRegiao(sudeste);
//        CidadeVO sbc = new CidadeVO();
//        sbc.setNomeCidade("São Bernardo do Campo");
//        sbc.setEstado(saoPaulo);
//        CidadeVO sa = new CidadeVO();
//        sa.setNomeCidade("Santo André");
//        sa.setEstado(saoPaulo);
//        CidadeVO sp = new CidadeVO();
//        sp.setNomeCidade("São Paulo");
//        sp.setEstado(saoPaulo);
//        CidadeVO rj = new CidadeVO();
//        rj.setNomeCidade("Rio de Janeiro");
//        rj.setEstado(riodeJaneiro);
//
//        RegiaoDAO rdao = new RegiaoDAO();
//        rdao.inserir(sul);
//        rdao.inserir(sudeste);
//        rdao.inserir(nordeste);
//        rdao.inserir(norte);
//        rdao.inserir(centroOeste);
//
//        EstadoDAO edao = new EstadoDAO();
//        edao.inserir(bahia);
//        edao.inserir(espiritoSanto);
//        edao.inserir(minasGerais);
//        edao.inserir(parana);
//        edao.inserir(riodeJaneiro);
//        edao.inserir(saoPaulo);
//
//        CidadeDAO cdao = new CidadeDAO();
//        cdao.inserir(rj);
//        cdao.inserir(sa);
//        cdao.inserir(sbc);
//        cdao.inserir(sp);
//
//        TipoFilialDAO tdao = new TipoFilialDAO();
//        TipoFilialVO tvo = new TipoFilialVO();
//        tvo.setDescricao("Shopping");
//        TipoFilialVO tvo2 = new TipoFilialVO();
//        tvo2.setDescricao("Aeroporto");
//        tdao.inserir(tvo);
//        tdao.inserir(tvo2);
//
//        FilialVO f1 = new FilialVO();
//        f1.setNomeFilial("Filial1");
//        f1.setEndereco("rua da filial1,111");
//        f1.setCidade(sa);
//        f1.setTipoFilial(tvo2);
//        FilialVO f2 = new FilialVO();
//        f2.setEndereco("rua da filial2");
//        f2.setNomeFilial("Filial2");
//        f2.setCidade(rj);
//        f2.setTipoFilial(tvo);
//        FilialDAO fidao = new FilialDAO();
//        fidao.inserir(f2);
//        fidao.inserir(f1);
//
//        PermissaoVO ru = new PermissaoVO();
//        ru.setName("ROLE_USER");
//        PermissaoVO ra = new PermissaoVO();
//        ra.setName("ROLE_ADMIN");
//        PermissaoDAO pdao = new PermissaoDAO();
//        pdao.inserir(ra);
//        pdao.inserir(ru);
//        UsuarioVO admin = new UsuarioVO();
//        admin.setUsername("admin");
//        admin.setPassword("123");
//        admin.setEnable(true);
//        List<PermissaoVO> permissoes = new ArrayList<PermissaoVO>();
//        permissoes.add(ra);
//        admin.setPermissoes(permissoes);
//        UsuarioDAO userD = new UsuarioDAO();
//        userD.inserir(admin);
//        UsuarioVO user = new UsuarioVO();
//        user.setEnable(true);
//        user.setUsername("user");
//        user.setPassword("123");
//        permissoes.clear();
//        permissoes.add(ru);
//        user.setPermissoes(permissoes);
//        userD.inserir(user);
//
//        TipoCarroDAO tcardao = new TipoCarroDAO();
//        TipoCarroVO tc1 = new TipoCarroVO();
//        tc1.setDescricao("Sedã");
//
//        TipoCarroVO tc2 = new TipoCarroVO();
//        tc2.setDescricao("Esportivo");
//
//        TipoCarroVO tc3 = new TipoCarroVO();
//        tc3.setDescricao("Picape");
//
//        TipoCarroVO tc4 = new TipoCarroVO();
//        tc4.setDescricao("Hatch");
//
//        tcardao.inserir(tc4);
//        tcardao.inserir(tc3);
//        tcardao.inserir(tc2);
//        tcardao.inserir(tc1);
//
//
//        FabricanteDAO fadao = new FabricanteDAO();
//        ModeloDAO modao = new ModeloDAO();
//
//        FabricanteVO volks = new FabricanteVO();
//        volks.setDescricao("VolksWagem");
//        fadao.inserir(volks);
//
//        ModeloVO gol = new ModeloVO();
//        gol.setDescricao("Gol");
//        gol.setFabricante(volks);
//        modao.inserir(gol);
//
//        ModeloVO golf = new ModeloVO();
//        golf.setDescricao("Golf");
//        golf.setFabricante(volks);
//        modao.inserir(golf);
//
//        ModeloVO saveiro = new ModeloVO();
//        saveiro.setDescricao("Saveiro");
//        saveiro.setFabricante(volks);
//        modao.inserir(saveiro);
//
//        ModeloVO jetta = new ModeloVO();
//        jetta.setDescricao("Jetta");
//        jetta.setFabricante(volks);
//        modao.inserir(jetta);
//
//        FabricanteVO renault = new FabricanteVO();
//        renault.setDescricao("Renault");
//        fadao.inserir(renault);
//
//        ModeloVO clio = new ModeloVO();
//        clio.setDescricao("Clio");
//        clio.setFabricante(renault);
//        modao.inserir(clio);
//
//        ModeloVO sandero = new ModeloVO();
//        sandero.setDescricao("Sandero");
//        sandero.setFabricante(renault);
//        modao.inserir(sandero);
//
//        FabricanteVO fiat = new FabricanteVO();
//        fiat.setDescricao("Fiat");
//        fadao.inserir(fiat);
//
//        ModeloVO palio = new ModeloVO();
//        palio.setDescricao("Palio");
//        palio.setFabricante(fiat);
//        modao.inserir(palio);
//
//        ModeloVO punto = new ModeloVO();
//        punto.setDescricao("Punto");
//        punto.setFabricante(fiat);
//        modao.inserir(punto);
//
//        ModeloVO stilo = new ModeloVO();
//        stilo.setDescricao("Stilo");
//        stilo.setFabricante(fiat);
//        modao.inserir(stilo);
//
//        ModeloVO doblo = new ModeloVO();
//        doblo.setDescricao("Doblo");
//        doblo.setFabricante(fiat);
//        modao.inserir(doblo);
//
//        CorVO amarelo = new CorVO();
//        amarelo.setDescricao("Amarelo");
//        CorVO preto = new CorVO();
//        preto.setDescricao("Preto");
//        CorVO branco = new CorVO();
//        branco.setDescricao("Branco");
//        CorVO prata = new CorVO();
//        prata.setDescricao("Prata");
//        CorVO v = new CorVO();
//        v.setDescricao("Vermelho");
//        CorDAO cordao = new CorDAO();
//        cordao.inserir(amarelo);
//        cordao.inserir(preto);
//        cordao.inserir(branco);
//        cordao.inserir(prata);
//        cordao.inserir(v);
//
//        OpcionalVO alarme = new OpcionalVO();
//        alarme.setDescricao("Alarme");
//
//        OpcionalVO vid = new OpcionalVO();
//        vid.setDescricao("Vidro Elétrico");
//
//        OpcionalVO tve = new OpcionalVO();
//        tve.setDescricao("Trava Elétrica");
//
//        OpcionalVO banc = new OpcionalVO();
//        banc.setDescricao("Banco de Couro");
//
//        OpcionalVO ar = new OpcionalVO();
//        ar.setDescricao("Ar-Condicionado");
//
//        OpcionalVO air = new OpcionalVO();
//        air.setDescricao("Air Bag");
//
//        OpcionalVO radio = new OpcionalVO();
//        radio.setDescricao("Rádio");
//
//        OpcionalVO abs = new OpcionalVO();
//        abs.setDescricao("Freios ABS");
//
//        OpcionalVO hid = new OpcionalVO();
//        hid.setDescricao("Direção Hidraulica");
//
//        OpcionalVO aq = new OpcionalVO();
//        aq.setDescricao("Ar Quente");
//
//        OpcionalVO bl = new OpcionalVO();
//        bl.setDescricao("Blindado");
//
//        OpcionalDAO opdao = new OpcionalDAO();
//        opdao.inserir(alarme);
//        opdao.inserir(vid);
//        opdao.inserir(tve);
//        opdao.inserir(banc);
//        opdao.inserir(ar);
//        opdao.inserir(air);
//        opdao.inserir(radio);
//        opdao.inserir(abs);
//        opdao.inserir(hid);
//        opdao.inserir(aq);
//        opdao.inserir(bl);
//
//        TipoReclamacaoVO tipor1 = new TipoReclamacaoVO();
//        TipoReclamacaoVO tipor2 = new TipoReclamacaoVO();
//        TipoReclamacaoVO tipor3 = new TipoReclamacaoVO();
//        TipoReclamacaoVO tipor4 = new TipoReclamacaoVO();
//        TipoReclamacaoVO tipor5 = new TipoReclamacaoVO();
//        tipor1.setDescricao("Carro");
//        tipor2.setDescricao("Atendente");
//        tipor3.setDescricao("Atrasos");
//        tipor4.setDescricao("Site");
//        tipor5.setDescricao("Outros");
//        TipoReclamacaoDAO tipordao = new TipoReclamacaoDAO();
//        tipordao.inserir(tipor5);
//        tipordao.inserir(tipor4);
//        tipordao.inserir(tipor3);
//        tipordao.inserir(tipor2);
//        tipordao.inserir(tipor1);


    }
}
