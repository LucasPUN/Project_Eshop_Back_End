package com.fsse2309.project_backend.utill;

import com.fsse2309.project_backend.domainObject.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtill {
    public static FirebaseUserData getFirebaseUser(JwtAuthenticationToken jwt){
        return new FirebaseUserData(jwt);
    }
}
