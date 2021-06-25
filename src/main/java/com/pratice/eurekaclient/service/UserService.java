package com.pratice.eurekaclient.service;


import com.pratice.eurekaclient.Entity.UserEntity;

public interface UserService {

	public void regist(UserEntity user);

	public UserEntity getUserInfo(String username);

}
