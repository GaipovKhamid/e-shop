package com.e_commerce.e_commerce.common.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListDto<T> {
    private List<T> data;

    public ListDto(List<T> data) {
        this.data = data;
    }
}
