package com.example.fotowoltaika.service;

import com.example.fotowoltaika.entity.User;
import com.example.fotowoltaika.entity.VerificationToken;
import com.example.fotowoltaika.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldAToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUsers(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordToken(String token);

    void changePassword(User user, String newPassword);
}
