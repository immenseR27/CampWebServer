package com.immenser.interserv.controllers;

import com.immenser.interserv.dto.JwtTokenResponse;
import com.immenser.interserv.dto.UserLoginDto;
import com.immenser.interserv.models.Employee;
import com.immenser.interserv.services.AuthorizationService;
//import com.immenser.interserv.util.errors.user.UserNotExistsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {
    private final AuthorizationService authorizationService;
//    private final UserNotExistsValidator userNotExistsValidator;

    @PostMapping("/register")
    public ResponseEntity<JwtTokenResponse> register(@RequestBody Employee employee, BindingResult bindingResult) {
//        userNotExistsValidator.validate(user, bindingResult);
//        returnErrorsIfContains(bindingResult, new MyException(""));
        return new ResponseEntity<>(authorizationService.saveUserAndReturnJwtResponse(employee), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenResponse> login(@RequestBody UserLoginDto loginDto) {
        return ResponseEntity.ok(authorizationService.login(loginDto));
    }
}