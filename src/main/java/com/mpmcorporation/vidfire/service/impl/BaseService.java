package com.mpmcorporation.vidfire.service.impl;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.UUID;

public class BaseService {

    protected String gerarUuid() {
       return UUID.randomUUID().toString().replace("-", "");
    }

    protected Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}
