package com.uahannam.readmodel.example.controller;

import com.uahannam.readmodel.example.service.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final SaveUserUseCase saveUserUseCase;

    @PostMapping("/test")
    public ResponseEntity<Void> testMethod() {
        saveUserUseCase.saveUser();
        return ResponseEntity.ok().build();
    }
}
