package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployee(id);
        return ResponseEntity.ok(employee);
    }

//    @PatchMapping("/edit/{id}")
//    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody UserEditDTO userEditDTO) {
//        User user = userService.editUser(id, userEditDTO);
//        return ResponseEntity.ok(user);
//    }
}