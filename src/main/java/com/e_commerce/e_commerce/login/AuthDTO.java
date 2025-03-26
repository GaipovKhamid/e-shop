package com.e_commerce.e_commerce.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthDTO {
    private Long id;
    private String email;
    private String password;
    private Role role;

}
