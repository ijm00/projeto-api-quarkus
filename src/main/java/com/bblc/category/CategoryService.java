package com.bblc.category;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Category create(Category category) {
        categoryRepository.persist(category);
        return category;
    }

    public List<Category> list() {
        return categoryRepository.listAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Category update(Long id, Category category) {
        Category dataCategory = categoryRepository.findById(id);
            dataCategory.setName(category.getName());

            categoryRepository.persist(dataCategory);
        return dataCategory;
    }

    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(long id) {
        categoryRepository.deleteById(id);
        return "category " + id + " deleted";
    }
}

