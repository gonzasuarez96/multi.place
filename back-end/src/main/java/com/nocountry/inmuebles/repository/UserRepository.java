package com.nocountry.inmuebles.repository;

import com.nocountry.inmuebles.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email=?1")
    public User iniciarSesion(String vLogin);
}
