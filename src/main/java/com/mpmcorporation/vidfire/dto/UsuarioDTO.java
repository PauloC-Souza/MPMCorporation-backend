package com.mpmcorporation.vidfire.dto;

import com.mpmcorporation.vidfire.entity.Usuario;
import com.mpmcorporation.vidfire.entity.UsuarioRole;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {

    private Integer id;
    private String login;
    private String password;
    private UsuarioRole role;
    private String nome;
    private String sobrenome;

    public UsuarioDTO(Usuario usuario){
        BeanUtils.copyProperties(usuario, this);
    }
}
