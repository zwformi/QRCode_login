package com.zw.controller;

import com.zw.entity.LoginUserVo;
import com.zw.entity.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**

 *
 二维码手机端登录
 *
 @author zijuntang
 *
 */
@Controller
public class PhoneLoginServlet {

  @RequestMapping("/PhoneLoginServlet")
  @ResponseBody
  public void PhoneLoginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        System.out.println(uuid);
        System.out.println(uname);
        System.out.println(upwd);
        //TODO
        //验证登录
        boolean bool = true;
        if(bool){
            //将登陆信息存入map
            UserVo userVo = LoginUserVo.getLoginUserMap().get(uuid);
            if(userVo == null){
                userVo = new UserVo();
                userVo.setUname(uname);
                userVo.setUpwd(upwd);
                LoginUserVo.getLoginUserMap().put(uuid,userVo);
            }
        }
        PrintWriter out = response.getWriter();
        out.print(bool);
        out.flush();
        out.close();
    }
}
