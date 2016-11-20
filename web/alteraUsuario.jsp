<%-- 
    Document   : alteraUsuario
    Created on : 20/11/2016, 00:16:18
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar Usuários</title>

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

            String codigo = request.getParameter("codigo");
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String email = request.getParameter("email");
            String ativo = request.getParameter("ativo");

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
                    <h1 class="page-header">Alterar Clientes</h1>
                </div>
            </div>

            <div class="row">
                <div class="form-group">
                    <a class="btn btn-primary" href="listaClient.jsp">Cancelar</a>
                </div>
            </div>

            <div class="row">
                <form role="form" action="trataAlteraUsuario.jsp" method="post">
                    <div class="form-group">
                        <label>Código</label>
                        <input class="form-control" name="codigo" id="codigo" value="<%=codigo%>">
                    </div>

                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" name="nome" id="nome" value="<%=nome%>">
                    </div>

                    <div class="form-group">
                        <label>Login</label>
                        <input class="form-control" name="login" id="login" value="<%=login%>">
                    </div>

                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" name="email" id="email" value="<%=email%>">
                    </div>

                    <div class="form-group">
                        <label>Situação Ativo</label>
                        <input class="form-control" name="ativo" id="ativo" value="<%=ativo%>">
                    </div>

                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Alterar">
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
                    $('#sidebar-collapse').collapse('show');
            });
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide');
            });
        </script>	
    </body>

</html>
