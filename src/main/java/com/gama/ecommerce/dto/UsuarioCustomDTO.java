package com.gama.ecommerce.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioCustomDTO implements UserDetails {
    private String login, senha;

    public UsuarioCustomDTO(Object byLogin) {
    }
}
