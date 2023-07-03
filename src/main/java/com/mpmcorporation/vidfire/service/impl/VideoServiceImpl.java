package com.mpmcorporation.vidfire.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.mpmcorporation.vidfire.entity.Video;
import com.mpmcorporation.vidfire.service.VideoService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@Service
public class VideoServiceImpl extends BaseService implements VideoService {

    private static final String COLLECTION_NAME = "video";

    @Override
    public String salvar(MultipartFile arquivo, String descricao) throws ExecutionException, InterruptedException {
        Video video = new Video();
        try{
            video.setVideo(new String(Base64.encodeBase64(arquivo.getBytes())));
        } catch(Exception e) {
            e.printStackTrace();
        }

        final String uuid = gerarUuid();
        video.setNome(arquivo.getOriginalFilename());
        video.setUuid(uuid);
        video.setDescricao(descricao);
        video.setTipo(arquivo.getContentType());

        ApiFuture<WriteResult> apiFuture = salvarFirestore(COLLECTION_NAME, video, uuid);

        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Video buscarVideo(String uuid) {
        DocumentSnapshot document;
        try {
            document = buscarFirestore(COLLECTION_NAME, uuid);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(document.exists()) {
           Video video = document.toObject(Video.class);
            return video;
        } else {
            return new Video();
        }
    }
}
