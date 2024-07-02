package com.nocountry.inmuebles.service.abstraction;

import com.nocountry.inmuebles.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> listAll();
    ResponseEntity<?> login(Map<String, String> requestMap);
    ResponseEntity<String> signUp(Map<String, String> requestMap);

}
