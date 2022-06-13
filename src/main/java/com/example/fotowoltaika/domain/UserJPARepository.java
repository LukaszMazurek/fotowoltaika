package com.example.fotowoltaika.domain;

import com.example.fotowoltaika.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserJPARepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
