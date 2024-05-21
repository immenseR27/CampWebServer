package com.immenser.interserv.services;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id) {
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        return optionalUser.orElseThrow();
    }

//    public User editUser(Long id, UserEditDTO userEditDTO) {
//        User user = userRepository.findById(id).orElseThrow();
//        user.setFirstName(userEditDTO.firstName());
//        user.setLastName(userEditDTO.lastName());
//        user.setMiddleName(userEditDTO.middleName());
//
//        return userRepository.save(user);
//    }
}