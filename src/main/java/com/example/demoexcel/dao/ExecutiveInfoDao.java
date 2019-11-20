package com.example.demoexcel.dao;

import com.example.demoexcel.entity.ExecutiveInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExecutiveInfoDao {
    boolean insertOrUpdate(@Param("list") List<ExecutiveInfoEntity> list);
}
