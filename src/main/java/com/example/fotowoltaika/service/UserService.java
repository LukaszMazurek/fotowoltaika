package com.example.fotowoltaika.service;

import com.example.fotowoltaika.entity.User;
import com.example.fotowoltaika.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
