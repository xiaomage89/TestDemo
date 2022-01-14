<%--
  Created by IntelliJ IDEA.
  User: majj
  Date: 2021/12/23
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
      $(function () {
          $("#username").blur(function () {
            var username = $(this).val();
            $.ajax({
              url:"findUserServlet",
              type:"POST",
              data:{"username":username},
              success:function (data) {
                var s_user_msg = $("#s_user_msg");
                if (data.userExsit){
                  s_user_msg.css("color","red")
                  s_user_msg.html(data.msg);
                }else{
                  s_user_msg.css("color","green")
                  s_user_msg.html(data.msg);
                }
              },
              dataType:"json"
                    }
            )

          })
      })
    </script>
  </head>
  <body>
  <form>
    <input type="text" id = "username" class="username" placeholder="请输入用户名">
    <span id="s_user_msg"></span>
    <br>
    <input type="password" id = "password" class="password" placeholder="请输入密码">
    <br>
    <input type="submit" value="注册">
  </form>

  </body>
</html>
