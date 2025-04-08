package indi.mofan.authapi.dtos;


import lombok.Getter;
import lombok.Setter;

/**
 * @author mofan
 * @date 2025/4/8 20:05
 */
@Getter
@Setter
public class LoginUserDto {
    private String email;

    private String password;
}
