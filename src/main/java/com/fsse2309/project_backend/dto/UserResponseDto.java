package com.fsse2309.project_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.domainObject.UserDataOut;

public class UserResponseDto {

    private Integer id;

    private String firebaseUid;

    private String email;

    public UserResponseDto(UserDataOut userDataOut) {
        this.id = userDataOut.getUid();
        this.firebaseUid = userDataOut.getFirebaseUid();
        this.email = userDataOut.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
