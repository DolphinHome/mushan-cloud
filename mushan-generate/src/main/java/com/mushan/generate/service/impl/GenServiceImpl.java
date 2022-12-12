package com.mushan.generate.service.impl;

import com.mushan.generate.dao.GenDao;
import com.mushan.generate.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class GenServiceImpl implements GenService {

    @Autowired
    private GenDao genDao;

    @Override
    public List<Map> list() {
        return genDao.list();
    }
}
