package com.newer.service;

import com.newer.bean.UserInfo;
import com.newer.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userInfoService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(UserInfo userinfo) {
        return userInfoMapper.findByNameAndPwd(userinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,rollbackFor = Exception.class)
    public int updatePwd(UserInfo userInfo) {
        return this.userInfoMapper.updatePwd(userInfo);
    }

    @Override
    public int findUserName(String username) {
        return this.userInfoMapper.findUserName(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,rollbackFor = Exception.class)
    public int addUserInfo(UserInfo userInfo) {
        return this.userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return this.userInfoMapper.findAll();
    }
}
