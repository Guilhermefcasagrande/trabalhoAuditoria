<%@page import="Controle.UserDB"%>
<%@page import="Modelo.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login - Sistema</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

    </head>

    <body>
        <%
            String erro = "";
            if (request.getParameter("login") != null) {
                String auxLogin = request.getParameter("usuario");
                String auxSenha = request.getParameter("senha");
                User usuario = UserDB.getUsuario(auxLogin, auxSenha);
                if (usuario != null) {
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("/trabalhoAuditoria/index.jsp");
                    erro = "";
                } else {
                    erro = "Usu�rio inv�lido! Entre novamente com os dados!";

                }
            }
        %>
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">Log in</div>
                    <div class="panel-body">
                        <form role="form" method="post" name="Form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Usuario" name="usuario" type="text" autofocus="" id="usuario">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="senha" type="password" value="" id="senha">
                                </div>
                                <input class="btn btn-success" type="submit" value="Entrar" id="login">
                                <%=erro%>
                                <!--<a href="index.jsp">Clique aqui</a>-->
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div><!-- /.col-->
        </div><!-- /.row -->	



        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
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
