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
import java.util.Date;

/**
 *
 用长连接，检查登录状态
 *
 @author zijuntang
 *
 */
@Controller
public class LongConnectionCheckServlet{
    @RequestMapping("/LongConnectionCheckServlet")
    @ResponseBody
    public void LongConnectionCheckServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String jsonStr = "";
        System.out.println("in");
        System.out.println("uuid:"+ uuid);
        long inTime = new Date().getTime();
        boolean bool = true;
        while(bool) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            //检测登录
            UserVo userVo = LoginUserVo.getLoginUserMap().get(uuid);
            System.out.println("userVo:"+ userVo);
            if(userVo!= null){
                bool = false;
                jsonStr = "{\"uname\":\""+userVo.getUname()+"\"}";
                LoginUserVo.getLoginUserMap().remove(uuid);
            }else{
                if(new Date().getTime() - inTime > 5000){
                    bool = false;
                }
            }
        }

        System.out.println("login ok : "
                + jsonStr);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }

}
