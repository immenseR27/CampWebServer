package com.immenser.interserv.services;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.repositories.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepository childRepository;
    private final GroupService groupService;

    public List<Child> findAll() {
        return childRepository.findAll();
    }

    public List<Child> findByUser(Long userId) {
        Group group = groupService.find(userId);
        List<Child> children = childRepository.findByGroup(group);
        System.out.println(children.get(0).getSurname());
        return childRepository.findByGroup(group);
    }

    public Child findChild(Long id) {
        return childRepository.findById(id).orElseThrow();
    }
}
