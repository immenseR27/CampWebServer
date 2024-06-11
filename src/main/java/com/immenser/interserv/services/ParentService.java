package com.immenser.interserv.services;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Parent;
import com.immenser.interserv.repositories.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;
    private final ChildService childService;

    public List<Parent> findParentsByChild(long childId) {
        Child child = childService.findChild(childId);
        return parentRepository.findParentsByChildren(child);
    }
}
