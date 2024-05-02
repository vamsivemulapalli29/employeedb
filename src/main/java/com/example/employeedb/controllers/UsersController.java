package com.example.employeedb.controllers;


import com.example.employeedb.payload.AuthenticatePayload;
import com.example.employeedb.payload.RegisterPayload;
import com.example.employeedb.payload.RegisterResponse;
import com.example.employeedb.services.JWTService;
import com.example.employeedb.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {


    @Autowired
    public JWTService jwtService;

    @Autowired
    public RegisterService registerService;

    @GetMapping("/hello")
    public String sayHello(){

        return "Hello!! How are you?";
    }

    @PostMapping("/auth/register")
    public ResponseEntity<RegisterResponse> saveUser(@RequestBody RegisterPayload payload){
        RegisterResponse registerResponse =  registerService.saveUser(payload);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/auth/authenticate")
    public ResponseEntity<RegisterResponse> authenticate(@RequestBody AuthenticatePayload authenticatePayload){
        RegisterResponse authenticateResponse =  registerService.authenticate(authenticatePayload);
        return ResponseEntity.ok(authenticateResponse);
    }

   /* @GetMapping("/employees")
    public List<Users> fetchEmployees(){
        return usersService.getAll();
    }*/

}
