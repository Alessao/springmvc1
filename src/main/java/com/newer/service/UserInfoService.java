package com.newer.service;

import com.newer.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo login(UserInfo userinfo);

    int updatePwd(UserInfo userInfo);

    int findUserName(String username);

    int addUserInfo(UserInfo userInfo);

    List<UserInfo> findAll();
}
