/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.service;
import com.mycompany.mavenproject.entity.Category;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author 1315
 */
@Stateless
public class CategoryService {
    @PersistenceContext(unitName = "tugascrudPU")
    private EntityManager em;
    
    public Category findById(String id){
        return em.find(Category.class, id);
    }
    
    public List<Category> findAll() {
        return em.createQuery("SELECT c FROM Category c ORDER BY c.name ASC")
                .getResultList();
    }
    
    public void create (Category category){
        category.setId(UUID.randomUUID().toString());
        category.setWaktuDibuat(new Date());
        em.persist(category);
    }
    
    public void edit (Category category){
        em.merge(category);
    }
    
    public void remove (Category category){
        em.remove(em.merge(category));
    }
    
}
