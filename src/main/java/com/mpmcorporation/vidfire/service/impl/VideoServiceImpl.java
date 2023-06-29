package com.mpmcorporation.vidfire.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.mpmcorporation.vidfire.entity.Video;
import com.mpmcorporation.vidfire.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class VideoServiceImpl extends BaseService implements VideoService {

    private static final String COLLECTION_NAME = "video";

    @Override
    public String salvar(Video video) throws ExecutionException, InterruptedException {

        ApiFuture<WriteResult> apiFuture = getFirestore().collection(COLLECTION_NAME)
                .document(video.getNom_arquivo())
                .set(video);

        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Video BuscarVideo(String nomeVideo) throws ExecutionException, InterruptedException {

        DocumentReference reference = getFirestore().collection(COLLECTION_NAME).document(nomeVideo);
        ApiFuture<DocumentSnapshot> apiFuture = reference.get();
        DocumentSnapshot document = apiFuture.get();

        if(document.exists()) {
           return document.toObject(Video.class);
        } else {
            return new Video();
        }
    }
}
