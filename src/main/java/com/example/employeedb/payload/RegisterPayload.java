package com.example.employeedb.payload;

import com.example.employeedb.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPayload {

    String firstName;
    String lastName;
    String email;
    String password;
    Roles role;
}
