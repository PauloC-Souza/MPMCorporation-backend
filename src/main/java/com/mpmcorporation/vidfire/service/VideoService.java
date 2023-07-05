package com.mpmcorporation.vidfire.service;

import com.mpmcorporation.vidfire.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

public interface VideoService {

    String salvar(MultipartFile arquivo, String descricao) throws ExecutionException, InterruptedException;

    Video buscarVideo(String uuid) throws ExecutionException, InterruptedException;

}
