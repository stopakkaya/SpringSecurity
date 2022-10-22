package com.platonakademisi.SpringSecurity.controller;

import com.platonakademisi.SpringSecurity.model.AppUser;
import com.platonakademisi.SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
}
