package com.newer.dao;

import com.newer.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userInfoMapper")
public interface UserInfoMapper {

    @Select("select * from userinfo where username = #{username} and userpwd = #{userPwd}")
    UserInfo findByNameAndPwd(UserInfo userinfo);

    @Update("update userinfo set userpwd=#{userPwd} where userid=#{userId}")
    int updatePwd(UserInfo userInfo);

    @Select("select count(userid) from userinfo where username=#{username}")
    int findUserName(String username);

    @Insert("insert into userinfo(username,birthday,usersex,userpwd,usermail) " +
            "values(#{username},#{userBirthday},#{userSex},#{userPwd},#{userEmail})")
    int addUserInfo(UserInfo userInfo);

    @Select("select * from userinfo")
    List<UserInfo> findAll();
}
