package com.bblc.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Category{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull
    @Column(nullable = false)
    private String categoryName;

    @NotBlank(message = "Código não pode estar em branco")
    @NotNull
    @Column(nullable = false)
    private String code;
    
}
