package com.uahannam.readmodel.example.repository;

import com.uahannam.readmodel.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
