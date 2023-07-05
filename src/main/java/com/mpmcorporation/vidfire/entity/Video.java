package com.mpmcorporation.vidfire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video implements Serializable {

    private String uuid;

    private String nome;

    private String descricao;

    private String video;

    private String tipo;
}
