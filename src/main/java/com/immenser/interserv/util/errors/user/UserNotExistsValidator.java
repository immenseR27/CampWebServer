package com.immenser.interserv.util.errors.user;

import com.immenser.interserv.models.User;
import com.immenser.interserv.security.UserDetailsServiceImpl;
import jakarta.validation.Validator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


//@Component
//@RequiredArgsConstructor
//public class UserNotExistsValidator implements Validator {
//    private final UserDetailsServiceImpl userDetailsService;
//
//    @Override
//    public boolean supports(@NonNull Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(@NonNull Object target, @NonNull Errors errors) {
//        User user = (User) target;
//
//        try {
//            userDetailsService.loadUserByUsername(user.getEmail());
//        } catch (UsernameNotFoundException ignored) {
//            return; // все ок, пользователь не найден
//        }
//
//        errors.rejectValue("email", "", "Client with this email already exists!");
//    }
//}

