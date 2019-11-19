/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Estudiante
 */
public class ProductoDAO {
    private static EntityManagerFactory
            emf= Persistence.createEntityManagerFactory("SIG-TerpelPU");
    
    public void crear(Producto object){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(object);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    public boolean eliminar(Producto p){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret=false;
        Producto object= new Producto();
        object= leerID(p);
        try{
            if(!em.contains(object)){
                object = em.merge(object);
            }
            em.remove(object);
            em.getTransaction().commit();
            ret=true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
    
    public Producto leerID(Producto par){
        EntityManager em=emf.createEntityManager();
        Producto producto= null;
        Query q= em.createQuery("SELECT productos FROM Producto productos "+
                "WHERE productos.id = :id")
                .setParameter("id", par.getId());
        try{
            producto=(Producto)q.getSingleResult();
        }catch(NonUniqueResultException e){
            producto=(Producto)q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return producto;
        }
    }
    public Producto leerNOM(Producto par){
        EntityManager em=emf.createEntityManager();
        Producto producto= null;
        Query q= em.createQuery("SELECT u FROM Producto u "+
                "WHERE u.nombre = :nombre")
                .setParameter("nombre", par.getNombre());
        try{
            producto=(Producto)q.getSingleResult();
        }catch(NonUniqueResultException e){
            producto=(Producto)q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return producto;
        }
    }
    public List <Producto> leerCAT(Producto p){
        EntityManager em=emf.createEntityManager();
        List <Producto> producto= null;
        Query q= em.createQuery("SELECT productos FROM Producto productos "+
                "WHERE productos.categoria = :categoria")
                .setParameter("categoria", p.getCategoria());
        try{
            producto=(List)q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return producto;
        }
    }
    public boolean actualizarEDIT(Producto object, String nombrenuevo, int valor){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret=false;
        try{
            object= leerID(object);
            if(nombrenuevo!=null){
                object.setNombre(nombrenuevo);
            }
            if(valor!=0){
                object.setValor(valor);
            }
            
            em.merge(object);
            em.getTransaction().commit();
            ret=true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
    public boolean actualizarCANT(Producto object, int nuevaCantidad){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret=false;
        try{
            object= leerID(object);
            object.setCantidad(nuevaCantidad);
            em.merge(object);
            em.getTransaction().commit();
            ret=true;
            
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
    
    
}
