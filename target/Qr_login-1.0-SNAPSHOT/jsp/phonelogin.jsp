<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/31
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>phonelogin.jsp</title>
    <style>
        .l_m_l
        {
            float:
                    left;
            font-size:
                    14px;
            padding:5px 0 0 0;
            width:
                    330px;
            color:
                    #414141;
        }



        .l_m_linput
        {
            height:
                    31px;
            position:
                    relative;
            width:
                    300px;
            margin-bottom:
                    21px;
        }



        .l_m_linput span {
            float:
                    left;
            width:
                    78px;
            text-align:
                    right;
            line-height:
                    31px;
        }



        input
        {
            float:
                    left;
            width:
                    195px;
            height:
                    24px;
            line-height:
                    24px;
            background:
                    #f2f2f2;
            border:
                    1px solid #c4c4c4;
            padding:
                    2px 22px 2px 2px;
        }



        .l_mimacon
        {
            position:
                    absolute;
            top:
                    6px;
            right:
                    6px;
            width:
                    15px;
            height:
                    17px;
            background:
                    url(img/l_mimacon.png)
                    no-repeat;
        }

        .l_peoplecon
        {
            position:
                    absolute;
            top:
                    7px;
            right:
                    6px;
            width:
                    15px;
            height:
                    15px;
            background:
                    url(img/l_peoplecon.png)
                    no-repeat;
        }
        .l_m_lload a {
            display:block;
            width:154px;
            height:40px;
            background: url(img/l_loadingbtn.png) no-repeat;
            margin:0 auto;
            line-height:40px;
            text-align: center;
            font-size:18px;
            color:#52340c;
            text-decoration: none;
        }

    </style>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
</head>
<body style="background-color:#333333">
<div style="margin-left: 100px;">
    <img src="img/logo.png" />
</div>
<div>
    <p class="l_m_linput"> <span><font color="#fff">用户名：</font></span><input type="text" id="login_name" value="zijuntang" /><em class="l_peoplecon"></em> </p>
    <p class="l_m_linput"> <span><font color="#fff">密码：</font></span><input type="password" id="login_psw" value="tangzijun" /><em class="l_mimacon"></em> </p>
    <div class="l_m_linput2"></div>
    <div class="l_m_lload">
        <a href="javascript:login();">确认登录</a>
    </div>
</div>
<script type="text/javascript">

    //登录

    function login(){
        $.post("/PhoneLoginServlet.do",
            {
                uuid:$.getUrlParam('uuid'),

                uname:$("#login_name").val(),

                upwd:$("#login_psw").val()

            },
            function(data, status) {
                if(data == ""){
                    alert("登录失败");
                }else{
                    alert("登录成功");
                    //WeixinJSBridge.call('closeWindow');
                    history.back();
                }
            });
    }


    //获取网页参数

    (function($){
        $.getUrlParam = function(name){
            var reg = new
                    RegExp("(^|&)"+
                    name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)
                return  unescape(r[2]);
            return  null;
        }
    })(jQuery);

</script>
</body>
</html>