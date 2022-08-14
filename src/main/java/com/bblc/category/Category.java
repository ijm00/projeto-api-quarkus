package com.bblc.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Category extends PanacheEntity{

    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull
    @Column(nullable = false)
    private String name;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category setId(long id) {
        this.id = id;
        return this;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    }
