<%@page import="dtos.UserDTO"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title> New Article  </title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>


        <div class="center">
            <h1>Post New Article </h1>


            <form action="PostArticleController" method="post">
                <div class="txt_field">
                    <input type="text"name="title" required="" autofocus="" draggable="false">
                    <jsp:useBean class="daos.ArticleDAO" id="articleDAO"></jsp:useBean>
                    <%
                        String id = articleDAO.generateArticleID();
                    %>
                    <input type="hidden" name="articleID" value="<%=id%>"
                           <span></span>
                    <label>Title</label>
                </div>
                <div class="txt_field">
                    <input type="text"name="short" required="" autofocus="" draggable="false">


                    <span></span>
                    <label>Short Description</label>
                </div>
                <label>Content</label>
                <div >

                    <textarea type="text"name="content" required="" rows="10" cols="50"></textarea>
                    <span></span>

                </div>

                <h3>${requestScope.ERROR}</h3>
                <input type="submit" name="action" value="Post">

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
    </script>
</html>
