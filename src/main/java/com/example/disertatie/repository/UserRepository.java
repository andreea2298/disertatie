package com.example.disertatie.repository;

import com.example.disertatie.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScope
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User create(User user) {
        entityManager.persist(user);
        return user;
    }


}
