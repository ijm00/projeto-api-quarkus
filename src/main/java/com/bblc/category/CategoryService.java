package com.bblc.category;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class CategoryService {
              
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Category create(Category category) {
        category.persist();
        return category;
    }

    public List<Category> list() {
        return Category.listAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Category update(Long id, Category category) {
        Category dataCategory = Category.findById(id);
            dataCategory.setName(category.getName());

        Category.persist(dataCategory);
        return dataCategory;
    }

    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(long id) {
        Category.deleteById(id);
        return "category " + id + " deleted";
    }
}

