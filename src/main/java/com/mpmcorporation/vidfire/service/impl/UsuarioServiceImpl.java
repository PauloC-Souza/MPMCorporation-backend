package com.mpmcorporation.vidfire.service.impl;

import com.mpmcorporation.vidfire.config.ModelMapperConfig;
import com.mpmcorporation.vidfire.dto.UsuarioDTO;
import com.mpmcorporation.vidfire.entity.Usuario;
import com.mpmcorporation.vidfire.repository.UsuarioRepository;
import com.mpmcorporation.vidfire.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public String cadastrar(UsuarioDTO usuarioDTO) {
        try{
            Usuario entity = new Usuario();
            usuarioRepository.save(ModelMapperConfig.convertToEntity(usuarioDTO));
            return "Cadastro realizado com sucesso. ";
        }catch (Exception e){
            return "Algo deu errado";
        }
    }
}
