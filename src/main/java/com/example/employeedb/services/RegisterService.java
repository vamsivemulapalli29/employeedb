package com.example.employeedb.services;

import com.example.employeedb.model.User;
import com.example.employeedb.payload.AuthenticatePayload;
import com.example.employeedb.payload.RegisterPayload;
import com.example.employeedb.payload.RegisterResponse;
import com.example.employeedb.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    JWTService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public RegisterResponse saveUser(RegisterPayload registerPayload){
        var user = User
                .builder()
                .firstName(registerPayload.getFirstName())
                .lastName(registerPayload.getLastName())
                .email(registerPayload.getEmail())
                .password(passwordEncoder.encode(registerPayload.getPassword()))
                .role(registerPayload.getRole()).build();
        var saveUser = usersRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return RegisterResponse.builder().jwtToken(jwtToken).build();
    }

    public RegisterResponse authenticate(AuthenticatePayload authenticatePayload){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticatePayload.getEmail(),
                        authenticatePayload.getPassword())
        );
        var user = usersRepository.findByEmail(authenticatePayload.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return RegisterResponse.builder().jwtToken(jwtToken).build();
    }

}
