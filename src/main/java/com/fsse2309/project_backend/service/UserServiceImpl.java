package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.FirebaseUserData;
import com.fsse2309.project_backend.domainObject.UserDataOut;
import com.fsse2309.project_backend.entity.UserEntity;
import com.fsse2309.project_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData){
        Optional<UserEntity> optionalUserEntity = userRepository.findByFirebaseUid(firebaseUserData.getFirebaseUid());

        if (optionalUserEntity.isEmpty()){
            UserEntity userEntity = new UserEntity(firebaseUserData);
            return userRepository.save(userEntity);
        }
        return optionalUserEntity.get();
    }

    @Override
    public List<UserDataOut> getAllUser() {
        List<UserDataOut> userDataOutList = new ArrayList<>();

        for (UserEntity userEntity : userRepository.findAll()) {
            UserDataOut userDataOut = new UserDataOut(userEntity);
            userDataOutList.add(userDataOut);
        }
        return userDataOutList;
    }
}
