package com.mushan.generate.dao;



import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


public interface GenDao {

    List<Map> list();
}
