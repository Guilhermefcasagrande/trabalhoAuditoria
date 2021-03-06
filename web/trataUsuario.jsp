<%-- 
    Document   : trataUsuario
    Created on : 19/11/2016, 23:42:56
    Author     : Guilherme
--%>

<%@page import="Controle.VerificaAcao"%>
<%@page import="Modelo.Log"%>
<%@page import="Controle.GravaLog"%>
<%@page import="Controle.UserDB"%>
<%@page import="Modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Cidade</title>

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
                    <h1 class="page-header">Incluir Nova Cidade</h1>
                </div>
            </div><!--/.row-->	

            <div class="row">
                <div class="col-lg-12">
                    <%
                        User user = (User) session.getAttribute("user");

                        if (user == null) {
                            session.invalidate();
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        } else {

                            String nome = request.getParameter("nome");
                            String login = request.getParameter("login");
                            String senha = request.getParameter("senha");
                            String email = request.getParameter("email");
                            int tentLogin = 0;
                            String stAtivo = "S";

                            User usuario = new User();
                            usuario.setNome(nome);
                            usuario.setLogin(login);
                            usuario.setSenha(senha);
                            usuario.setEmail(email);
                            usuario.setTentativasLogin(tentLogin);
                            usuario.setStAtivo(stAtivo);

                            boolean inseriu = UserDB.insereUser(usuario);

                            if (inseriu) {
                                out.println("<div class=\"alert bg-success\" role=\"alert\">");
                                out.println("<svg class=\"glyph stroked checkmark\">");
                                out.println("<use xlink:href=\"#stroked-checkmark\"></use>");
                                out.println("</svg> Usuario inserido com sucesso!");
                                out.println("<a href=\"insereUsuario.jsp\" class=\"pull-right\">");
                                out.println("<span class=\"glyphicon glyphicon-remove\"></span>");
                                out.println("</a>");
                                out.println("</div>");

                                String acao = "Incluir";
                                VerificaAcao verifica = new VerificaAcao();
                                int acCodigo = verifica.buscaAcao(acao);

                                Log log = new Log();
                                log.setAcCodigo(acCodigo);
                                log.setUsrCodigo(user.getUsrCodigo());
                                log.setTabela("Usuario");

                                GravaLog.log(log);

                            } else {
                                out.println("<div class=\"alert bg-danger\" role=\"alert\">");
                                out.println("<svg class=\"glyph stroked cancel\">");
                                out.println("<use xlink:href=\"#stroked-cancel\"></use>");
                                out.println("</svg> Erro no cadastro do Usuario!");
                                out.println("<a href=\"insereUsuario.jsp\" class=\"pull-right\">");
                                out.println("<span class=\"glyphicon glyphicon-remove\"></span>");
                                out.println("</a>");
                                out.println("</div>");
                            }
                        }

                    %>  
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
