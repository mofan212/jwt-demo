package indi.mofan.authapi.responses;


import lombok.Getter;
import lombok.Setter;

/**
 * @author cheny
 * @date 2025/4/8 20:18
 */
@Getter
@Setter
public class LoginResponse {
    private String token;

    private long expiresIn;
}
