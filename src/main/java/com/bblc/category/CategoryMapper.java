package com.bblc.category;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CategoryMapper {
    
    CategoryDTO toDomain(Category category);

    Category toEntity(CategoryDTO categoryDTO);
    
}
