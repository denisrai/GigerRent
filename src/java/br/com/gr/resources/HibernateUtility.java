package br.com.gr.resources;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.gr.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtility {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            //cfg.configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(Aluguel.class);
            cfg.addAnnotatedClass(Carro.class);
            cfg.addAnnotatedClass(Cidade.class);
            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(Cor.class);
            cfg.addAnnotatedClass(Fisica.class);
            cfg.addAnnotatedClass(Funcionario.class);
            cfg.addAnnotatedClass(Juridica.class);
            cfg.addAnnotatedClass(Loja.class);
            cfg.addAnnotatedClass(LojaTipo.class);
            cfg.addAnnotatedClass(Marca.class);
            cfg.addAnnotatedClass(Modelo.class);
            cfg.addAnnotatedClass(Sac.class);
            cfg.addAnnotatedClass(SacTipo.class);
            cfg.addAnnotatedClass(Status.class);
            cfg.addAnnotatedClass(Tamanho.class);
            cfg.addAnnotatedClass(TipoCarro.class);
            cfg.addAnnotatedClass(UF.class);
            cfg.addAnnotatedClass(Usuario.class);

            return cfg.configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Criacão inicial do objeto SessionFactory falhou. Erro: " + e);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
