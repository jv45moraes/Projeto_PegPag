/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.Produto;
import hibernates.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lino
 */
public class ProdutodDAO {
    
    private  Session session;
    private Transaction  transaction; 
    
    //Método para salvar 
    public void salvarCliente(Produto produto){
        try{
            session = HibernateUtil.getSeccionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(produto);
            transaction.commit();
        } catch (Exception e){
          System.out.println("Erro ao Salvar o cadastro");  
    } finally{
            session.close();
        }
    }
    
    //Método para Atualizar
    public void atualizarCliente(Produto produto){
        try{
            session = HibernateUtil.getSeccionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(produto);
            transaction.commit();
        } catch (Exception e){
          System.out.println("Erro ao Atualizar o cadastro");  
    } finally{
            session.close();
        }
    }
    
    //Método para Excluir
    public void excluirCliente(Produto produto){
        try{
            session = HibernateUtil.getSeccionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(produto);
            transaction.commit();
        } catch (Exception e){
          System.out.println("Erro ao Excluir o cadastro");  
    } finally{
            session.close();
        }
        
        
    }
    
    
}
    
