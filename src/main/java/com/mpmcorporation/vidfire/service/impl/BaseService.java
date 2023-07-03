package com.mpmcorporation.vidfire.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class BaseService {

    private Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

    protected String gerarUuid() {
       return UUID.randomUUID().toString().replace("-", "");
    }

    protected ApiFuture<WriteResult> salvarFirestore(String collectionName, Object entity, String key) {
        return getFirestore()
                .collection(collectionName)
                .document(key)
                .set(entity);
    }

    protected DocumentSnapshot buscarFirestore(String collectionName, String key)
            throws ExecutionException, InterruptedException {

        DocumentReference reference = getFirestore()
                .collection(collectionName)
                .document(key);

        ApiFuture<DocumentSnapshot> apiFuture = reference.get();
        return apiFuture.get();
    }
}
