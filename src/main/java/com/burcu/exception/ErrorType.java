package com.burcu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(5000, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(4100,"Parametre Hatası", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110, "Girilen kullanıcı adı ya da parola hatalıdır.", HttpStatus.BAD_REQUEST),
    USER_DUPLICATE(4111, "Bu kullanıcı adı zaten kayıtlıdır.", HttpStatus.BAD_REQUEST),
    CAR_ALREADY_EXISTS(4112, "Bu araç sistemde zaten kayıtlıdır.", HttpStatus.BAD_REQUEST),
    CAR_NOT_FOUND(4113, "Bu araç sistemde bulunamadı.",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4114,"Kullanıcı bulunamadı", HttpStatus.BAD_REQUEST);



    int code;
    String message;
    HttpStatus httpStatus;


}
