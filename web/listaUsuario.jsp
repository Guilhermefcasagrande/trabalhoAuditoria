<%-- 
    Document   : listaUsuario
    Created on : 20/11/2016, 00:06:32
    Author     : Guilherme
--%>

<%@page import="Controle.UserDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controle.GravaLog"%>
<%@page import="Modelo.Log"%>
<%@page import="Controle.VerificaAcao"%>
<%@page import="Modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consulta de Usuários</title>

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

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Icons</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Consulta de Usuários</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <%
                                User user = (User) session.getAttribute("user");

                                if (user == null) {
                                    session.invalidate();
                                    request.getRequestDispatcher("login.jsp").forward(request, response);
                                } else {

                                    String acao = "Consultar";
                                    VerificaAcao verifica = new VerificaAcao();
                                    int acCodigo = verifica.buscaAcao(acao);

                                    Log log = new Log();
                                    log.setAcCodigo(acCodigo);
                                    log.setUsrCodigo(user.getUsrCodigo());
                                    log.setTabela("Usuario");

                                    GravaLog.log(log);

                                    ArrayList<User> lista = new ArrayList();
                                    lista = UserDB.listaUsuario();

                                    out.println("<table class=\"table table-bordered\">");
                                    out.println("<thead>");
                                    out.println("<tr>");
                                    out.println("<th>Código</th>");
                                    out.println("<th>Nome</th>");
                                    out.println("<th>Login</th>");
                                    out.println("<th>Email</th>");
                                    out.println("<th>Ativo</th>");
                                    out.println("<th>Ações</th>");
                                    out.println("</tr>");
                                    out.println("</thead>");
                                    out.println("<tbody>");

                                    for (int i = 0; i < lista.size(); i++) {
                                        User usuario = lista.get(i);
                                        out.println("<tr>");
                                        out.println("<td>" + usuario.getUsrCodigo() + "</td>");
                                        out.println("<td>" + usuario.getNome() + "</td>");
                                        out.println("<td>" + usuario.getLogin() + "</td>");
                                        out.println("<td>" + usuario.getEmail() + "</td>");
                                        out.println("<td>" + usuario.getStAtivo() + "</td>");
                                        out.println("<td>"
                                                + "<a href=\"alteraUsuario.jsp?codigo=" + usuario.getUsrCodigo() + "&nome=" + usuario.getNome() + "&login=" + usuario.getLogin() + "&email="
                                                + usuario.getEmail() + "&ativo=" + usuario.getStAtivo() + "\" class=\"btn btn-primary\" role=\"button\">Alterar</a></td>");
                                        out.println("</tr>");
                                    }

                                    out.println("</tbody>");
                                    out.println("</table>");
                                }

                            %> 
                        </div>
                    </div>
                </div>
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
