package br.com.gr.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.gr.resources.HibernateUtility;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GenericDAO<T> extends HibernateUtility implements Serializable {

    private static final long serialVersionUID = 1L;
    protected Session sessao;
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("unchecked")
    public T buscaporId(Integer codigo) {
        T x = null;
        try {
            sessao = HibernateUtility.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            x = (T) sessao.get(entityClass, codigo);
            sessao.getTransaction().commit();
        } catch (Throwable e) {
            if (sessao.getTransaction().isActive()) {
                sessao.getTransaction().rollback();
            }
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Throwable e) {
                System.out
                        .println("Erro ao fechar opera��o de busca. Mensagem: "
                        + e.getMessage());
            }
        }
        return x;
    }

    public void inserir(T x) {
        try {
            sessao = HibernateUtility.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            sessao.save(x);
            sessao.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("N�o foi possivel inserir "
                    + x.getClass().getName() + " Mensagem: " + e.getMessage());
            sessao.getTransaction().rollback();
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Throwable e) {
                System.out
                        .println("Erro ao fechar opera��o de inser��o. Mensagem: "
                        + e.getMessage());
            }
        }
    }

    public void atualiza(T x) {
        try {
            sessao = HibernateUtility.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            sessao.merge(x);
            sessao.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("N�o foi possivel atualizar "
                    + x.getClass().getName() + " Mensagem: " + e.getMessage());
            sessao.getTransaction().rollback();
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Throwable e) {
                System.out
                        .println("Erro ao fechar opera��o de atualiza�ao. Mensagem: "
                        + e.getMessage());
            }
        }
    }

    public void remove(T x) {
        try {
            sessao = HibernateUtility.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            sessao.delete(x);
            sessao.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("N�o foi possivel excluir "
                    + x.getClass().getName() + " Mensagem: " + e.getMessage());
            sessao.getTransaction().rollback();
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Throwable e) {
                System.out
                        .println("Erro ao fechar opera��o de exclus�o. Mensagem: "
                        + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> listar() {
        List<T> lista = new ArrayList<T>();
        try {
            sessao = HibernateUtility.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            lista = sessao.createCriteria(entityClass).list();
        } catch (HibernateException e) {
            System.out.println("N�o foi possivel listar "
                    + entityClass.getClass().getName() + " Mensagem: "
                    + e.getMessage());
            sessao.getTransaction().rollback();
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Throwable e) {
                System.out
                        .println("Erro ao fechar opera��o de exclus�o. Mensagem: "
                        + e.getMessage());
            }
        }
        return lista;
    }

    public void iniciarTransacao() {
        sessao = HibernateUtility.getSessionFactory().openSession();
        sessao.getTransaction().begin();
    }

    public void fecharTransacao() {
        try {
            sessao.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            sessao.getTransaction().rollback();
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
