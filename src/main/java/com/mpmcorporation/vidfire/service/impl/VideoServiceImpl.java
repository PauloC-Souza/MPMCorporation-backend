package com.mpmcorporation.vidfire.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
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

        video.setNome(arquivo.getOriginalFilename());
        video.setUuid(gerarUuid());
        video.setDescricao(descricao);

        ApiFuture<WriteResult> apiFuture = getFirestore()
                .collection(COLLECTION_NAME)
                .document(video.getUuid())
                .set(video);

        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Video BuscarVideo(String uuid) throws ExecutionException, InterruptedException {

        DocumentReference reference = getFirestore()
                .collection(COLLECTION_NAME)
                .document(uuid);

        ApiFuture<DocumentSnapshot> apiFuture = reference.get();
        DocumentSnapshot document = apiFuture.get();

        if(document.exists()) {
           Video video = document.toObject(Video.class);
           Base64.decodeBase64(video.getVideo());
           return video;
        } else {
            return new Video();
        }
    }
}
