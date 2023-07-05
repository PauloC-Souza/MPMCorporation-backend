package com.mpmcorporation.vidfire.config;

import com.mpmcorporation.vidfire.dto.UsuarioDTO;
import com.mpmcorporation.vidfire.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static UsuarioDTO convertToDto(Usuario usuario) {
        UsuarioDTO usuarioDTO = modelMapper().map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }


    public static Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper().map(usuarioDTO, Usuario.class);
        return usuario;
    }

}
