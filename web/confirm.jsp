<%@page import="dtos.UserDTO"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title> Verification  </title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            UserDTO dto = (UserDTO) session.getAttribute("USER");

        
            if (dto != null) {
                if (dto.getRole().equals("Admin")) {
                    String mess2 = (String) request.getAttribute("SUCCESS");
                    String url = "admin.jsp";
                    response.sendRedirect(url);
                    return;
                } else {
                    if (dto.getStatus().equals("Active")) {
                        String mess2 = (String) request.getAttribute("SUCCESS");
                        String url = "home.jsp";
                        response.sendRedirect(url);
                        return;
                    }
                }
            }
        %>

        <div class="center">
            <h1>Verification Account</h1>


            <form action="ConfirmAccountController" method="post">
                <div class="txt_field">
                    <input type="text"name="code" >
                    <span></span>
                    <label>Code</label>
                </div>

                <h3>${requestScope.ERROR}</h3>
                <input type="submit" name="action" value="Confirm">

                <div class="signup_link">
                    <a href="home.jsp">Back to home</a>
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
        <%    HttpSession session1 = request.getSession();
            String mess1 = (String) session1.getAttribute("MESSAGE");
            if (mess1 != null) {
        %>

        alert("${sessionScope.MESSAGE}");
        <%}%>
    </script>
</html>
