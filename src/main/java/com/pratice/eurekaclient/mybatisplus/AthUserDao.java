package com.pratice.eurekaclient.mybatisplus;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pratice.eurekaclient.Entity.EntityBase;

@Mapper
public interface AthUserDao extends BaseMapper<EntityBase> {

}
