package com.hxg.simpledemo.service.impl;

import com.hxg.simpledemo.bean.People;
import com.hxg.simpledemo.dao.PeopleDao;
import com.hxg.simpledemo.dao.impl.PeoplDaoImpl;
import com.hxg.simpledemo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("peopleSerice")
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Override
    public List<People> listPeople() {

        return peopleDao.listPeople();
    }
}
