package com.hxg.simpledemo.dao.impl;

import com.hxg.simpledemo.bean.People;
import com.hxg.simpledemo.dao.PeopleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("peopleDao")
@Slf4j
public class PeoplDaoImpl implements PeopleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<People> listPeople() {
        String querySQL = "select * from people";

        log.info("listPeople: {}", querySQL);


        return this.jdbcTemplate.query(querySQL, new BeanPropertyRowMapper<>(People.class));
    }
}
