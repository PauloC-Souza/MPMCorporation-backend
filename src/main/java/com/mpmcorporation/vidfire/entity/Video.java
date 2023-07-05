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

    private Integer id;

    private String nom_arquivo;

    private String video;
}
