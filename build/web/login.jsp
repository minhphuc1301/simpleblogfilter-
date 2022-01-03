<%@page import="dtos.UserDTO"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title> Login </title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
//            response.setHeader("Cache-Control", "no-cache, no-store");
            UserDTO dto = (UserDTO) session.getAttribute("USER");

            if (dto != null) {

                String mess2 = (String) request.getAttribute("SUCCESS");
                String url = "home.jsp";
                response.sendRedirect(url);
                return;
            }


        %>

        <div class="center">
            <h1>Login</h1>


            <form action="LoginController" method="post">
                <div class="txt_field">
                    <input value="${param.username}"name="username"type="email" required>
                    <span></span>
                    <label>Email</label>
                </div>
                <div class="txt_field">
                    <input name="password"type="password" required>
                    <span></span>
                    <label>Password</label>
                </div>
                <h3>${requestScope.MESSAGE}</h3>
                <input type="submit" name="action" value="Login">
                <div class="signup_link">
                    Not a member? <a href="register.jsp">Signup</a>
                </div>
                <div class="signup_link">
                    <a href="home.jsp">Back to shopping</a>
                </div>
            </form>
        </div>
    </body>
    <script>
        <%    String mess = (String) request.getAttribute("SUCCESS");
            if (mess != null) {
        %>

        alert("${requestScope.SUCCESS}");
        <%}%>
    </script>
</html>
