package com.stillhere.generate.dao;

import com.stillhere.generate.pojo.Lcbpo;

public interface LcbpoDao {
    int insert(Lcbpo record);

    int insertSelective(Lcbpo record);
}