package com.bblc.category;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CategoryDTO {

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;
    
}
