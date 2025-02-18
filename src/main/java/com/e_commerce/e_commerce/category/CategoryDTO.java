package com.e_commerce.e_commerce.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDTO {
    private Long id;
    private String name;
}
