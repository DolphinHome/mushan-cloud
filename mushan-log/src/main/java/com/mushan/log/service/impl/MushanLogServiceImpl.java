package com.mushan.log.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.mushan.log.dao.MushanLogDao;
import com.mushan.log.pojo.MushanLog;
import com.mushan.log.service.MushanLogService;


@Service
public class MushanLogServiceImpl implements MushanLogService
{
    @Autowired
    private MushanLogDao mushanLogDao;

    @Override
    public List<MushanLog>List(MushanLog mushanLog){
        return  mushanLogDao.list(mushanLog);
    }

    @Override
    public MushanLog query(Long id){
        return mushanLogDao.query(id);
    }

    @Override
    public int add(MushanLog mushanLog){
       return mushanLogDao.add(mushanLog);
    }

    @Override
    public int edit(MushanLog mushanLog){
        return mushanLogDao.edit(mushanLog);
    }

    @Override
    public int delete(Long id){
        return mushanLogDao.delete(id);
    }

}
