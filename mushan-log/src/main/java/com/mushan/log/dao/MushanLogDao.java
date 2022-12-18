package com.mushan.log.dao;

import java.util.List;
import com.mushan.log.pojo.MushanLog;


public interface MushanLogDao
{


    public List<MushanLog> list(MushanLog mushanLog);

    public MushanLog query(Long id);

    public int add(MushanLog mushanLog);

    public int edit(MushanLog mushanLog);

    public int delete(Long id);

}
