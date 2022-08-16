package com.bblc.client;

import com.bblc.category.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTO {

    private String name;
    private String email;
    private CategoryDTO category;
    
}
