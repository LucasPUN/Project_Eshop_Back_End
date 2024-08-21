package com.fsse2309.project_backend.domainObject;

import com.fsse2309.project_backend.entity.UserEntity;

public class UserDataOut {
    private Integer uid;
    private String firebaseUid;
    private String email;

    public UserDataOut(UserEntity userEntity) {
        this.uid = userEntity.getUid();
        this.firebaseUid = userEntity.getFirebaseUid();
        this.email = userEntity.getEmail();
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

