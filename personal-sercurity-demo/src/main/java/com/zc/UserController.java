package com.zc;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @GetMapping("/me")
    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
