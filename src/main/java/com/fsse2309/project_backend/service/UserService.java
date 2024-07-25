package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.FirebaseUserData;
import com.fsse2309.project_backend.domainObject.UserDataOut;
import com.fsse2309.project_backend.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData);

    List<UserDataOut> getAllUser();
}
