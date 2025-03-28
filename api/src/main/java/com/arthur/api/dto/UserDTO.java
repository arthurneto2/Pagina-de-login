package com.arthur.api.dto;

import com.arthur.api.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String nome;

    private String login;




    public UserDTO() {
    }

    public UserDTO(Usuario user) {
        this.id = user.getId();
        this.login = user.getEmail();
        this.nome = user.getNome();
    }

}
