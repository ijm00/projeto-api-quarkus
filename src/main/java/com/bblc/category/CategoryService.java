package com.bblc.category;

import java.util.List;
import java.util.stream.Collectors;

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

    @Inject
    CategoryMapper categoryMapper;

    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void init() {
        Category categoryDev = new Category()
            .setName("Developer");
        categoryRepository.persist(categoryDev);

        Category categorySell = new Category()
            .setName("Merchant");
        categoryRepository.persist(categorySell);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public CategoryDTO create(Category category) {
        categoryRepository.persist(category);
        return categoryMapper.toDomain(category);
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> list() {
        return categoryRepository.streamAll()
            .map(cat -> categoryMapper.toDomain(cat))
            .collect(Collectors.toList());
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

