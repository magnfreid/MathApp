package com.example.firebasetodo2

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class FirebaseManager {

    val db = Firebase.firestore
    val auth = Firebase.auth

}