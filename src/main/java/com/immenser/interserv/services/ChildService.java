package com.immenser.interserv.services;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.repositories.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepository childRepository;

    public List<Child> findAll() {
        return childRepository.findAll();
    }

    public Child findChild(Long id) {
        return childRepository.findById(id).orElseThrow();
    }
}
