<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="dtos.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Admin Page</title>
        <!-- Font Awesome -->

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
        <!-- Your custom styles (optional) -->
        <link href="css/style.min.css" rel="stylesheet">
        <style type="text/css">
            html,
            body,
            header,
            .carousel {
                height: 60vh;
            }

            @media (max-width: 740px) {

                html,
                body,
                header,
                .carousel {
                    height: 100vh;
                }
            }

            @media (min-width: 800px) and (max-width: 850px) {

                html,
                body,
                header,
                .carousel {
                    height: 100vh;
                }
            }
            #btnLogin:hover{
                background-color: white;
            }
        </style>


    <body >

        <%

            UserDTO dto = (UserDTO) session.getAttribute("USER");


        %>

        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
            <div class="container">

                <!-- Brand -->
                <a class="navbar-brand waves-effect" href="home.jsp" target="_self">
                
                    <strong class="red-text">Simple Blog Page</strong>
                </a>

                <!-- Collapse -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- Links -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <!-- Left -->
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link waves-effect" href="home.jsp#main-page">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>

                    </ul>

                    <c:forEach var="cart" items="${sessionScope.LIST_CART.getCart().values()}" >

                        <c:set var="count" value="${count+1}"></c:set>
                    </c:forEach>
                    <!-- Right -->
                    <ul class="navbar-nav nav-flex-icons">



                        <li class="nav-item" style="margin-right:5px;">

                            <%                                if (dto == null) {
                            %>
                            <a  href="register.jsp"class="nav-link border border-light rounded waves-effect"
                                target="_self" >
                                <i class="fas fa-user-plus"></i>Register
                            </a>
                            <%}%>


                        </li>




                        <li class="nav-item">


                            <c:url var="logout" value="LogoutController">

                            </c:url>

                            <%                                if (dto == null) {
                            %>
                            <a  style="display:inline;text-decoration:none;color:black;" href="login.jsp"/>
                            <button id="btnLogin"class="nav-link border border-light rounded waves-effect"
                                    target="_blank">   
                                <i class="fas fa-sign-in-alt"></i>Login
                            </button>
                            </a>
                            <%} else {%>
                            <a href="${pageScope.logout}" class="nav-link border border-light rounded waves-effect"
                               target="_blank">
                                <i class="fas fa-sign-in-alt"></i>Logout
                            </a>
                            <%}%>
                        </li>

                    </ul>

                </div>

            </div>
        </nav>

        <!--Carousel Wrapper-->
        <div id="carousel-example-1z" class="carousel slide carousel-fade pt-4" data-ride="carousel">

            <!--Indicators-->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-1z" data-slide-to="1"></li>
                <li data-target="#carousel-example-1z" data-slide-to="2"></li>
            </ol>
            <!--/.Indicators-->

            <!--Slides-->
            <div class="carousel-inner" role="listbox">

                <!--First slide-->
                <div class="carousel-item active">
                    <div class="view" style="background-image: url('https://pearlriverhotel.vn/wp-content/uploads/2019/07/pearl-river-hotel-home1.jpg'); background-repeat: no-repeat; background-size: cover;">
                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

                            <!-- Content -->
                             <div class="text-center white-text mx-5 wow fadeIn">
                                <h1 class="mb-4">
                                    <strong>Hi ${sessionScope.USER.getFullName()}, Welcome to Simple Blog Page </strong>
                                </h1>                         
                                <a  href="#main-page" class="btn btn-outline-white btn-lg">Start
                                    discover
                                    <i class="fas fa-book"></i>
                                </a>
                            </div>
                            <!-- Content -->
                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/First slide-->

                <!--Second slide-->
                <div class="carousel-item">
                    <div class="view" style="background-image: url('https://cdn.vietnambiz.vn/2019/11/4/dd32d9b188d86d6d8dc40d1ff9a0ebf6-15728512315071030248829.jpg'); background-repeat: no-repeat; background-size: cover;">
                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <h1 class="mb-4">
                                    <strong>Hi ${sessionScope.USER.getFullName()}, Welcome to Simple Blog Page </strong>
                                </h1>                         
                                <a  href="#main-page" class="btn btn-outline-white btn-lg">Start
                                    discover
                                    <i class="fas fa-book"></i>
                                </a>
                            </div>
                            <!-- Content -->
                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/Second slide-->

                <!--Third slide-->
                <div class="carousel-item">
                    <div class="view" style="background-image: url('https://pix8.agoda.net/hotelImages/124/1246280/1246280_16061017110043391702.jpg?s=1024x768'); background-repeat: no-repeat; background-size: cover;">
                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

                            <!-- Content -->
                           <div class="text-center white-text mx-5 wow fadeIn">
                                <h1 class="mb-4">
                                    <strong>Hi ${sessionScope.USER.getFullName()}, Welcome to Simple Blog Page </strong>
                                </h1>                         
                                <a  href="#main-page" class="btn btn-outline-white btn-lg">Start
                                    discover
                                    <i class="fas fa-book"></i>
                                </a>
                            </div>
                            <!-- Content -->
                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/Third slide-->

            </div>
            <!--/.Slides-->

            <!--Controls-->
            <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            <!--/.Controls-->

        </div>
        <!--/.Carousel Wrapper-->

        <!--Main layout-->
        <main id="main-page">
            <div class="container">

                <!--Navbar-->
                <nav class="navbar navbar-expand-lg navbar-dark mdb-color lighten-3 mt-3 mb-5">

                    <!-- Navbar brand -->


                    <!-- Collapse button -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                            aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!-- Collapsible content -->
                    <div class="collapse navbar-collapse" id="basicExampleNav">
                        <form action="PagingController" class="form-inline">
                            <input value="${param.search}"name="search"class="form-control mr-sm-2" type="text" placeholder="Search by title" aria-label="Search">
                            <jsp:useBean class="daos.StatusDAO" id="statusDAO"></jsp:useBean>
                                <select  name="status">
                                <c:forEach  var="status" items="${statusDAO.status}">
                                    <option value="${status.statusName}">${status.statusName}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden"name="index" value="1" >
                            <input style="border:none;"class="fas fa-search" type="submit"  >
                        </form>
                    </div>
                    <!-- Collapsible content -->

                </nav>                               <!--/.Navbar-->
                <c:if test="${requestScope.LIST!=null and not empty requestScope.LIST}">
                    <!--Section: Products v.3-->
                    <section class="text-center mb-4">

                        <div>


                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>ID</th>
                                        <th>Title</th>
                                        <th>Content</th>
                                        <th>Create by</th>
                                        <th>Create date</th>
                                        <th>Create status</th>

                                    </tr>
                                </thead>
                                <tbody>


                                    <c:forEach var="art" items="${requestScope.LIST}" varStatus="counter">


                                        <tr>
                                            <td>${counter.count}</td>
                                            <td >${art.articleID}</td>
                                            <td>${art.articleTitle}</td>
                                            <td style="min-width:100px;" >${art.articleContent}</td>
                                            <td>${art.createBy}</td>
                                            <td>${art.createDate}</td>
                                            <td>${art.status}</td>



                                            <td>   

                                                <input ${art.status=="Active"?"disabled":""}onclick="if (confirm('Are you sure you want to approve this article?'))
                                                            window.location.href = 'UpdateStatusController?status1=Approve&articleID=${art.articleID}&index=${param.index}&search=${param.search}&status=${param.status}';
                                                        else
                                                            disabled"     type="submit" value="Approval" name="action" class="btn btn-success">


                                            </td>

                                            <td>   

                                                <input ${art.status=="Deleted"?"disabled":""}onclick="if (confirm('Are you sure you want to delete this article?'))
                                                            window.location.href = 'UpdateStatusController?status1=Delete&articleID=${art.articleID}&index=${param.index}&search=${param.search}&status=${param.status}';
                                                        else
                                                            disabled"     type="submit" value="Delete" name="action" class="btn btn-danger">

                                            </td>
                                        </tr>
                                        </form>

                                    </c:forEach>
                                </tbody>

                            </table>



                        </div>




                    </section>
                    <!--Section: Products v.3-->

                </c:if>

                <c:if test="${requestScope.LIST==null and empty requestScope.LIST}">
                    <!--Section: Products v.3-->
                    <section class="text-center mb-4">

                        <div>


                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>ID</th>
                                        <th>Title</th>
                                        <th>Content</th>
                                        <th>Create by</th>
                                        <th>Create date</th>
                                        <th>Create status</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <jsp:useBean class="daos.ArticleDAO" id="articleDAO"></jsp:useBean>

                                    <c:forEach var="art" items="${articleDAO.getListPagingArticle(1)}" varStatus="counter">


                                        <tr>
                                            <td>${counter.count}</td>
                                            <td >${art.articleID}</td>
                                            <td>${art.articleTitle}</td>
                                            <td style="min-width:100px;" >${art.articleContent}</td>
                                            <td>${art.createBy}</td>
                                            <td>${art.createDate}</td>
                                            <td>${art.status}</td>



                                            <td>   

                                                <input ${art.status=="Active"?"disabled":""}onclick="if (confirm('Are you sure you want to approve this article?'))
                                                            window.location.href = 'UpdateStatusController?status1=Approve&articleID=${art.articleID}&index=${param.index}';
                                                        else
                                                            disabled"     type="submit" value="Approval" name="action" class="btn btn-success">


                                            </td>

                                            <td>   

                                                <input ${art.status=="Deleted"?"disabled":""}onclick="if (confirm('Are you sure you want to delete this article?'))
                                                            window.location.href = 'UpdateStatusController?status1=Delete&articleID=${art.articleID}';
                                                        else
                                                            disabled"     type="submit" value="Delete" name="action" class="btn btn-danger">

                                            </td>
                                        </tr>
                                        </form>

                                    </c:forEach>
                                </tbody>

                            </table>



                        </div>




                    </section>
                    <!--Section: Products v.3-->

                </c:if>
                <c:if test="${requestScope.page==0 }">
                    <h3>Nothing here !</h3>
                </c:if>
                <!--Pagination-->
                <nav class="d-flex justify-content-center wow fadeIn">
                    <ul class="pagination pg-blue">

                        <!--Arrow left-->

                        <!--Main layout-->
                        <jsp:useBean class="daos.ArticleDAO" id="articleDAO1"></jsp:useBean>

                        <c:if test="${requestScope.page!=null and not empty requestScope.page}">
                            <c:forEach begin="1" end="${requestScope.page}" var="c">

                                <li class="page-item active">
                                    <a id="${c}"class="page-link" href="PagingController?index=${c}&search=${param.search}&status=${param.status}">${c}

                                    </a>
                                </li>
                            </c:forEach>
                        </c:if>
                        <c:if test="${requestScope.page==null and empty requestScope.page}">
                            <c:forEach begin="1" end="${articleDAO1.numberArticle}" var="c">

                                <li class="page-item active">
                                    <a id="${c}"class="page-link" href="PagingController?index=${c}">${c}

                                    </a>
                                </li>
                            </c:forEach>
                        </c:if>
                    </ul>

                </nav>
                <!--Pagination-->

            </div>
        </main>
        <!--Main layout-->

        <!--Footer-->
        <footer class="page-footer text-center font-small mt-4 wow fadeIn">

            <!--Call to action-->
            <div class="pt-4">
                <a class="btn btn-outline-white" href="https://mdbootstrap.com/docs/jquery/getting-started/download/" target="_blank"
                   role="button">Download MDB
                    <i class="fas fa-download ml-2"></i>
                </a>
                <a class="btn btn-outline-white" href="https://mdbootstrap.com/education/bootstrap/" target="_blank" role="button">Start
                    free tutorial
                    <i class="fas fa-graduation-cap ml-2"></i>
                </a>
            </div>
            <!--/.Call to action-->

            <hr class="my-4">

            <!-- Social icons -->
            <div class="pb-4">
                <a href="https://www.facebook.com/mdbootstrap" target="_blank">
                    <i class="fab fa-facebook-f mr-3"></i>
                </a>

                <a href="https://twitter.com/MDBootstrap" target="_blank">
                    <i class="fab fa-twitter mr-3"></i>
                </a>

                <a href="https://www.youtube.com/watch?v=7MUISDJ5ZZ4" target="_blank">
                    <i class="fab fa-youtube mr-3"></i>
                </a>

                <a href="https://plus.google.com/u/0/b/107863090883699620484" target="_blank">
                    <i class="fab fa-google-plus-g mr-3"></i>
                </a>

                <a href="https://dribbble.com/mdbootstrap" target="_blank">
                    <i class="fab fa-dribbble mr-3"></i>
                </a>

                <a href="https://pinterest.com/mdbootstrap" target="_blank">
                    <i class="fab fa-pinterest mr-3"></i>
                </a>

                <a href="https://github.com/mdbootstrap/bootstrap-material-design" target="_blank">
                    <i class="fab fa-github mr-3"></i>
                </a>

                <a href="http://codepen.io/mdbootstrap/" target="_blank">
                    <i class="fab fa-codepen mr-3"></i>
                </a>
            </div>
            <!-- Social icons -->

            <!--Copyright-->
            <div class="footer-copyright py-3">
                © 2021 Copyright:
                <a href="admin.jsp" target="_blank"> Simple Blog </a>
            </div>
            <!--/.Copyright-->

        </footer>
        <!--/.Footer-->

        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Initializations -->
        <script>  <%    String check = (String) request.getAttribute("CHECKDAY");
            if (check != null) {
            %>

                                                    alert("${requestScope.CHECKDAY}");
            <%}%>

            <%    String add = (String) request.getAttribute("ADD");
                if (add != null) {
            %>

                                                    alert("${requestScope.ADD}");
            <%}%>
            <%    String mess = (String) request.getAttribute("SUCCESS");
                if (mess != null) {
            %>

                                                    alert("${requestScope.SUCCESS}");
            <%}%>
            <%    String mes1 = (String) request.getAttribute("MESSAGE");
                if (mes1 != null) {
            %>

                                                    alert("${requestScope.MESSAGE}");
            <%}%>
            <%    String a = (String) request.getAttribute("index");
                if (a != null) {
            %>
                                                    document.getElementById('${index}').style.color = "black";
            <%
            } else {
            %>
                                                    document.getElementById('1').style.color = "black";
            <%
                }
            %>
        </script>
    </body>

</html>
