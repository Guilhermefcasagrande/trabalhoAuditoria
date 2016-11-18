<%-- 
    Document   : insereUsuario
    Created on : 11/11/2016, 10:03:24
    Author     : guilherme
--%>

<%@page import="Modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Usuarios</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/bootstrap-table.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="js/lumino.glyphs.js"></script>
    </head>

    <body>
        <%@include file="menu.html" %>
        <%@include file="header.html" %>
        <%
            User user = (User) session.getAttribute("user");

            if (user == null) {
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Icons</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Incluir Novo Usuario</h1>
                </div>
            </div><!--/.row-->	

            <div class="row">
                <form role="form" action="trataUsuario.jsp" method="post">
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" name="nome" id="nome">
                    </div>

                    <div class="form-group">
                        <label>Login</label>
                        <input class="form-control" name="login" id="login">
                    </div>
                    
                    <div class="form-group">
                        <label>Senha</label>
                        <input class="form-control" name="senha" id="senha" type="password">
                    </div>
                    
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" placeholder="algo@email.com" name="email" id="email">
                    </div>
                    
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Cadastrar">
                    </div>
                </form>
            </div>

        </div><!--/.main-->

        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/bootstrap-table.js"></script>
        <script>
            !function ($) {
                $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                    $(this).find('em:first').toggleClass("glyphicon-minus");
                });
                $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
            }(window.jQuery);

            $(window).on('resize', function () {
                if ($(window).width() > 768)
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })
        </script>	
    </body>

</html>
