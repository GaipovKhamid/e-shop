package com.e_commerce.e_commerce.login;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Role {
    SELLER, USER
}
