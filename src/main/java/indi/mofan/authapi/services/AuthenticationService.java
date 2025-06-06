package indi.mofan.authapi.services;


import indi.mofan.authapi.dtos.LoginUserDto;
import indi.mofan.authapi.dtos.RegisterUserDto;
import indi.mofan.authapi.entities.User;
import indi.mofan.authapi.respostories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author mofan
 * @date 2025/4/8 20:14
 */
@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 AuthenticationManager authenticationManager,
                                 PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
        );
        authenticationManager.authenticate(authentication);
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
