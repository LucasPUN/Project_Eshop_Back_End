package com.fsse2309.project_backend.api;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.UserDataOut;
import com.fsse2309.project_backend.dto.UserResponseDto;
import com.fsse2309.project_backend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin({EnvConfig.devEnvBaseUrl,EnvConfig.prodBaseUrl,EnvConfig.devEnvBaseUrl1})
public class AdminUserApi {

    private UserService userService;

    public AdminUserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponseDto> getAllUserDto(){
        List<UserDataOut> userDataOutList = userService.getAllUser();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (UserDataOut userDataOut : userDataOutList){
            userResponseDtoList.add(new UserResponseDto(userDataOut));
        }
        return userResponseDtoList;
    }
}
