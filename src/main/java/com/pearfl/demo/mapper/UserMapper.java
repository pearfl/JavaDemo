package com.pearfl.demo.mapper;


import com.pearfl.demo.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findByLoginName(String loginName);

    List<User> list();

}