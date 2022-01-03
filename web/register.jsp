<%@page import="dtos.UserDTO"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Register </title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="center">
            <h1>Register</h1>
            <%

                UserDTO dto = (UserDTO) session.getAttribute("USER");

                if (dto != null) {
                    if (dto.getRole().equals("Admin")) {
                        String mess2 = (String) request.getAttribute("SUCCESS");
                        String url = "admin.jsp";
                        response.sendRedirect(url);
                        return;
                    } else {
                        String mess2 = (String) request.getAttribute("SUCCESS");
                        String url = "home.jsp";
                        response.sendRedirect(url);
                        return;
                    }
                }


            %>


            <form action="RegisterController" method="post">
                <div class="txt_field">

                    <input value="${param.username}"type="email" name="username"class="form-control"  id="username" required="">
                    <span></span>
                    <label>Email</label>

                </div>

                <p style="color:red;">${requestScope.MESSAGE.userIDError}</p>
                <div class="txt_field">
                    <input type="password" name="password"class="form-control"  id="pwd" required="">
                    <span></span>
                    <label>Password</label>
                </div>
                <p style="color:red;">${requestScope.MESSAGE.passwordError}</p>
                <div class="txt_field">
                    <input type="password" name="confirm"class="form-control"  required="">
                    <span></span>
                    <label>Confirm Password</label>
                </div>
                <p style="color:red;">${requestScope.MESSAGE.confirmError}</p>
                <div class="txt_field">
                    <input  value="${param.fullname}"type="text" name="fullname"class="form-control" required="">
                    <span></span>
                    <label>Fullname</label>
                </div>

                <div class="signup_link">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Male" checked/>
                    <label class="form-check-label" for="inlineRadio1" >Male</label>
                    <input style="margin-left:65px;"class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Female" />
                    <label class="form-check-label" for="inlineRadio1" >Female</label>

                </div>


                <input type="submit" name="action" value="Register">

                <div class="signup_link">
                    <a href="home.jsp"> Back to shopping </a> |
                    <a href="login.jsp"> Back to login </a>
                </div>
            </form>
        </div>
    </body>
    <script>
        <%    String mess = (String) request.getAttribute("SUCCESS");
            if (mess != null) {
        %>

        alert("${requestScope.MESSAGE}");
        <%}%>
        <%    String mess1 = (String) request.getAttribute("ERROR");
            if (mess1 != null) {
        %>

        alert("${requestScope.ERROR}");
        <%}%>
    </script>
</html>
