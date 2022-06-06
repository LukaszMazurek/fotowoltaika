package com.example.fotowoltaika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController// This means that this class is a Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService instalationService;
    @GetMapping("/list")
    public List<User> list(Model model) {
        List<User> instalation = instalationService.getUsers();
        return instalation;
    }
}
