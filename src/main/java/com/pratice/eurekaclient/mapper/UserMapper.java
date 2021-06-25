package com.pratice.eurekaclient.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pratice.eurekaclient.Entity.UserEntity;

@Mapper
public interface UserMapper {

	/**
	 * 用戶注冊
	 * @param user
	 */
	public void reigst(UserEntity user);

	/**
	 * 獲取用戶信息
	 * @param userName
	 * @return
	 */
	public UserEntity getPwdByUserName(@Param("userName") String userName);
}
