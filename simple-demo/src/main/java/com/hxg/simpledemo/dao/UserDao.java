package com.hxg.simpledemo.dao;

import com.hxg.simpledemo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findByIdIn(List<Integer> idList);
}
