package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

//    @PostMapping("/add")
//    public ResponseEntity<HttpStatus> addProduct(@RequestBody AddProductRequest request) {
//        groupService.addProduct(request);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

//    @GetMapping("/{userId}")
//    public List<Child> find(@PathVariable Long userId) {
//        return groupService.find(userId).getChildren();
//    }
}
