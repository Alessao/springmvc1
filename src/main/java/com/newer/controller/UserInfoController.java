package com.newer.controller;

import com.newer.bean.User;
import com.newer.bean.UserInfo;
import com.newer.service.UserInfoService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/login")
    public String login(UserInfo userInfo, HttpSession session){
        UserInfo userInfo1 = userInfoService.login(userInfo);
        if(userInfo1==null){
            session.setAttribute("msg","用户名或密码错误");
            return "login";
        }else{
            session.setAttribute("loginer",userInfo1);
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping("/changePwd")
    public void changePwd(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        //获取响应对象后，控制器方法返回值必须是void
        UserInfo userInfo = new UserInfo();
        //将请求参数封装成bean
        BeanUtils.populate(userInfo,request.getParameterMap());
        if(userInfoService.updatePwd(userInfo)>0){
            response.sendRedirect("../suc.jsp");
        }else{
            request.getRequestDispatcher("../index.jsp");
        }

    }

    @RequestMapping("/checkName")
    public void checkName(String username, PrintWriter printWriter){
        if(userInfoService.findUserName(username)==0){
            printWriter.print("该用户名可以使用");
        }else{
            printWriter.print("改用户名已被注册");
        }
    }

    @RequestMapping("/registerUser")
    public void registerUser(UserInfo userInfo,PrintWriter printWriter){
        if(userInfoService.addUserInfo(userInfo)>0){
            printWriter.print(true);
        }else{
            printWriter.print(false);
        }
    }
}
