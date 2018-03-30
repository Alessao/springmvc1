package com.newer.test;

import com.newer.bean.UserInfo;
import com.newer.service.UserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInfoTest {
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoService service = ctx.getBean("userInfoService",UserInfoService.class);

        UserInfo userinfo = new UserInfo();
        userinfo.setUsername("Jack");
        userinfo.setUserPwd("1");
        System.out.println(service.login(userinfo));
    }
}
