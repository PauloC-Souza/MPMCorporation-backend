package com.mpmcorporation.vidfire.service.impl;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public class BaseService {

    protected Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}
