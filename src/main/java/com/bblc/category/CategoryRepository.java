package com.bblc.category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
    
    public boolean existsCategory(String name) {
        try {
            findByName(name);
            return true;
        } catch (NoResultException nre) {
            return false;
        }
    }

    public Category findByName(String name) {
        return find("name like ?1", "%".concat(name).concat("%")).singleResult();
    }

}
