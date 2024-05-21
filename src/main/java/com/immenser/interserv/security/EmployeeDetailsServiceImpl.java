package com.immenser.interserv.security;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeDetailsServiceImpl implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> optionalUser = employeeRepository.findByEmail(username);
        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new EmployeeDetailsImpl(optionalUser.get());
    }
}
