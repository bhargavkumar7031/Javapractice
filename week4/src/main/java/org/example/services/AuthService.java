package org.example.services;

import org.example.DTO.AuthRequest;
import org.example.DTO.AuthResponse;
import org.example.classes.Auth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.repository.AuthRepository;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthRepository authRepository;

    public AuthService(PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, AuthRepository authRepository) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.authRepository = authRepository;
    }

    public AuthResponse register(AuthRequest request) {
        Auth userAuth = Auth.builder().userName(request.getUsername()).Password(passwordEncoder.encode(request.getPassword())).build();

        authRepository.save(userAuth);

        String token = jwtService.generateToken(userDetails(userAuth));
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        Auth auth = authRepository.findByUserName(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(userDetails(auth));
        return new AuthResponse(token);
    }

    private UserDetails userDetails(Auth userAuth) {
        return org.springframework.security.core.userdetails.User.withUsername(userAuth.getUserName()).password(userAuth.getPassword()).build();
    }

}
