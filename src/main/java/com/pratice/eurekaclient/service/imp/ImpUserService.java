package com.pratice.eurekaclient.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.eurekaclient.Entity.UserEntity;
import com.pratice.eurekaclient.mapper.UserMapper;
import com.pratice.eurekaclient.mybatisplus.AthUserDao;
import com.pratice.eurekaclient.service.UserService;

@Service
public class ImpUserService implements UserService{

	@Autowired
	UserMapper userMapper;

	@Autowired
	AthUserDao userDao;

	@Override
	public void regist(UserEntity user) {
		userMapper.reigst(user);
		//userDao.insert(user);
	}

	@Override
	public UserEntity getUserInfo(String userName) {
		return userMapper.getPwdByUserName(userName);
	}

}
