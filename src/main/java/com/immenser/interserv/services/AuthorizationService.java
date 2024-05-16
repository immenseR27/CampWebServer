package com.immenser.interserv.services;


import com.immenser.interserv.dto.JwtTokenResponse;
import com.immenser.interserv.dto.UserLoginDto;
import com.immenser.interserv.models.User;
import com.immenser.interserv.repositories.UserRepository;
import com.immenser.interserv.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final UserRepository userRepository;
//    private final CartRepository cartRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public JwtTokenResponse saveUserAndReturnJwtResponse(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
//        Cart cart = new Cart(user, new ArrayList<>());
//        cartRepository.save(cart);

        return jwtUtil.generateJWTResponse(user);
    }

    public JwtTokenResponse login(UserLoginDto loginDto) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
        authenticationManager.authenticate(auth);
        return jwtUtil.generateJWTResponse(userRepository.findByEmail(loginDto.email()).orElseThrow());
    }
}
