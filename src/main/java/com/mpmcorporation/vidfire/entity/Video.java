package com.mpmcorporation.vidfire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private String uuid;

    private String nome;

    private String descricao;

    private String video;
}
