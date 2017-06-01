package com.zw.controller;

import com.zw.util.TwoDimensionCode;
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
 生成二维码图片以及uuid
 *
 @author zijuntang
 *
 */
@Controller
public class GetQrCodeServlet{

    @RequestMapping("/GetQrCodeServlet")
    @ResponseBody
    public void GetQrCodeServlet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        //生成唯一ID
        int uuid = (int)(Math.random() * 100000);

        //二维码内容

        String content = "http://192.168.43.124:8080/jsp/phonelogin.jsp?uuid="
                + uuid;

        //生成二维码

        String imgName =  uuid + "_" + (int)(new Date().getTime() / 1000)
                + ".png";
        ///home/web/apache/htdocs/QrCodeLogin/
        //request.getSession().getServletContext().getRealPath("/");这个方法拿到localhost:8080/项目名
        String imgPath = request.getSession().getServletContext().getRealPath("/")+"/QrCodeLogin/"+ imgName;
        TwoDimensionCode  handler = new TwoDimensionCode();

        handler.encoderQRCode(content,imgPath, "png");

        //生成的图片访问地址

        String qrCodeImg = "http://192.168.43.124:8080/QrCodeLogin/"
                + imgName;

        String jsonStr = "{\"uuid\":" + uuid + "," +
                          "\"qrCodeImg\":\""+ qrCodeImg + "\"}";
        out.print(jsonStr);
        out.flush();
        out.close();
    }

}
