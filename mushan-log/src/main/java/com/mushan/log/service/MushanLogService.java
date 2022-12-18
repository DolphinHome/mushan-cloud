package com.mushan.log.service;

import java.util.List;
import com.mushan.log.pojo.MushanLog;


public interface MushanLogService
{


    public List<MushanLog>List(MushanLog mushanLog);

    public MushanLog query(Long id);

    public int add(MushanLog mushanLog);

    public int edit(MushanLog mushanLog);

    public int delete(Long id);

}
