package com.mushan.generate.service.impl;

import com.mushan.generate.dao.GenDao;
import com.mushan.generate.pojo.GenTable;
import com.mushan.generate.service.GenService;
import com.mushan.generate.utils.velocityUtil;
import com.mushan.utlis.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class GenServiceImpl implements GenService {

    @Autowired
    private GenDao genDao;

    @Override
    public List<Map> list(String name) {
        return genDao.list(name);
    }

    @Override
    public byte[] code(String tables) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        String[] table = tables.split(","); // 分割
        for (String name : table) {
            GenTable genTable = new GenTable();
            genTable.setTableName(name);
            //通过表名获取列数据
            List<Map> columns = genDao.queryColumnByTableName(name);
            velocityUtil.out(genTable,columns,zip);
        }


        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
