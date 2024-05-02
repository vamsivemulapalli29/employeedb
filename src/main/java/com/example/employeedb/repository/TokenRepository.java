package com.example.employeedb.repository;

import com.example.employeedb.model.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Tokens,Long> {

}
