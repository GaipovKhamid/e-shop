package com.e_commerce.e_commerce.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CartType {
    UZCARD("8600"),
    HUMO("9860"),
    VISA("4216");

    private final String startNum;

}