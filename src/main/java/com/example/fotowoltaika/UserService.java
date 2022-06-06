package com.example.fotowoltaika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getUsers() {
        List<User> users = userDAO.getUsers();
        return users;
    }
}
