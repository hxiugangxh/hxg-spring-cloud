package com.hxg.simpledemo.service;

import com.hxg.simpledemo.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> saveBatch();

    Page<User> userPage(Pageable pageable);

    String greet(String name);
}
