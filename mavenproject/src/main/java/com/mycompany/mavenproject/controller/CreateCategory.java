/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.controller;

import com.mycompany.mavenproject.entity.Category;
import com.mycompany.mavenproject.service.CategoryService;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 1315
 */
@Named
@ViewScoped
public class CreateCategory implements Serializable{
    
    @EJB
    private CategoryService categoryService;
    
    private Category category;
    
    @PostConstruct
    public void init(){
        category = new Category();
        
    }
    
    public void save(){
        try {
            categoryService.create(category);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/view/category/list.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CreateCategory.class.getName()).log(Level.SEVERE, null,ex);
        }
    }

    public Category getCategory() {
        return category;
    }
    
}
