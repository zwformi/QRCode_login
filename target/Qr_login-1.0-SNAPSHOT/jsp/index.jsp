<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<body>
<div id="divCon">
    <img  src="" id="QrCodeImg"/>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function()
    {
        var uuid;
        $.get("/GetQrCodeServlet.do", function(data, status) {
                var obj = eval("(" + data + ")");
                //存储UUID
                uuid = obj.uuid;
                //显示二维码
                $("#QrCodeImg").attr("src", obj.qrCodeImg);
                //开始验证登录
                validateLogin();
            });



        function  validateLogin(){
            $.get("/LongConnectionCheckServlet.do?uuid="
                + uuid , function(data, status) {
                if(data == ""){
                    validateLogin();
                }else{
                    var obj = eval("("+ data + ")");
                    alert("登录成功了:" + obj.uname);
                    window.location.href="/index1.jsp";
                }
            });
        }
    });

</script>
</html>
