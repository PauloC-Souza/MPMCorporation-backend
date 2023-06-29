package com.mpmcorporation.vidfire.service;

import com.mpmcorporation.vidfire.entity.Video;

import java.util.concurrent.ExecutionException;

public interface VideoService {

    String salvar(Video video) throws ExecutionException, InterruptedException;

    Video BuscarVideo(String nomeVideo) throws ExecutionException, InterruptedException;
}
