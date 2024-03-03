package com.burcu.service;

import com.burcu.dto.request.UserLoginRequestDto;
import com.burcu.dto.request.UserRegisterRequestDto;
import com.burcu.dto.response.UserRegisterResponseDto;
import com.burcu.entiy.User;
import com.burcu.exception.ErrorType;
import com.burcu.exception.RentACarException;
import com.burcu.mapper.UserMapper;
import com.burcu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserRegisterResponseDto register(UserRegisterRequestDto dto) {
        Optional<User> optionalUser=userRepository.findByUserName(dto.getUserName());
        if (optionalUser.isPresent()){
            throw new RentACarException(ErrorType.USER_DUPLICATE);
        }
        User user= userRepository.save(UserMapper.INSTANCE.fromUserRegisterDtoToUser(dto));
        return UserMapper.INSTANCE. fromUserToUserRegisterResponseDto(user);
    }

    public Boolean doLogin(UserLoginRequestDto dto) {
        Optional<User> optionalUser=userRepository.findByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (optionalUser.isEmpty()){
            throw new RentACarException(ErrorType.LOGIN_ERROR);
        }
        return true;
    }

    public Optional<User> findByUserName(String userName) {
        Optional<User> optionalUser=userRepository.findByUserName(userName);
        if (optionalUser.isEmpty()){
            throw new RentACarException(ErrorType.USER_NOT_FOUND);
        }
        return optionalUser;
    }
}
