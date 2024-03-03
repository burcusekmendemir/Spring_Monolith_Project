package com.burcu.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserRegisterRequestDto {

    @Size(min=5, max=32)
    @NotNull
    private String userName;
    @Email
    @NotNull
    private String email;
    @Size(min=5, max=32)
    @NotNull
    private String password;
}
