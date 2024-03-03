package com.burcu.controller;

import com.burcu.dto.request.UserLoginRequestDto;
import com.burcu.dto.request.UserRegisterRequestDto;
import com.burcu.dto.response.UserRegisterResponseDto;
import com.burcu.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(REGISTER)
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody @Valid UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> doLogin(@RequestBody @Valid UserLoginRequestDto dto){
        return ResponseEntity.ok(userService.doLogin(dto));
    }
}
