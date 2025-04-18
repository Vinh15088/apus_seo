package org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.controller;

import org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.context.UserContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/info")
    public String getCurrentUser() {
        return UserContext.getUserId();
    }

}
