package com.mpmcorporation.vidfire.controller;

import com.mpmcorporation.vidfire.dto.UsuarioDTO;
import com.mpmcorporation.vidfire.repository.UsuarioRepository;
import com.mpmcorporation.vidfire.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> cadastrar(@RequestBody @Valid UsuarioDTO usuarioDTO){
        if(this.usuarioRepository.findByLogin(usuarioDTO.getLogin()) != null){
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDTO.getPassword());
        usuarioDTO.setPassword(senhaCriptografada);
       return ResponseEntity.ok(usuarioService.cadastrar(usuarioDTO));
    }
}
