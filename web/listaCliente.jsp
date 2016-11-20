<%-- 
    Document   : listaCliente
    Created on : 23/10/2016, 20:59:46
    Author     : Guilherme
--%>

<%@page import="Controle.GravaLog"%>
<%@page import="Modelo.Log"%>
<%@page import="Controle.VerificaAcao"%>
<%@page import="Modelo.User"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Controle.ClienteDB"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consulta de Clientes</title>

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
                    <h1 class="page-header">Consulta de Clientes</h1>
                </div>
            </div>

            <div class="row">

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
                                log.setTabela("Cliente");

                                GravaLog.log(log);

                                ArrayList<Cliente> lista = new ArrayList();
                                lista = ClienteDB.listaCliente();

                                out.println("<table class=\"table table-bordered\">");
                                out.println("<thead>");
                                out.println("<tr>");
                                out.println("<th>Código</th>");
                                out.println("<th>Cep</th>");
                                out.println("<th>Nome</th>");
                                out.println("<th>Endereço</th>");
                                out.println("<th>Sexo</th>");
                                out.println("<th>Nascimento</th>");
                                out.println("<th>Saldo</th>");
                                out.println("<th>Ativo</th>");
                                out.println("<th>Ações</th>");
                                out.println("</tr>");
                                out.println("</thead>");
                                out.println("<tbody>");
                                for (int i = 0; i < lista.size(); i++) {
                                    Cliente cli = lista.get(i);
                                    out.println("<tr>");
                                    out.println("<td>" + cli.getCliCodigo() + "</td>");
                                    out.println("<td>" + cli.getCep() + "</td>");
                                    out.println("<td>" + cli.getNome() + "</td>");
                                    out.println("<td>" + cli.getEndereco() + "</td>");
                                    out.println("<td>" + cli.getSexo() + "</td>");
                                    out.println("<td>" + cli.getDtNascto() + "</td>");
                                    out.println("<td>" + cli.getSaldoDevedor() + "</td>");
                                    out.println("<td>" + cli.getAtivo() + "</td>");
                                    out.println("<td><a href=\"excluiCliente.jsp?codigo=" + cli.getCliCodigo() + "\" class=\"btn btn-danger\" role=\"button\">Excluir</a>"
                                            + "<a href=\"alteraCliente.jsp?codigo=" + cli.getCliCodigo() + "&cep=" + cli.getCep() + "&nome=" + cli.getNome() + "&endereco="
                                            + cli.getEndereco() + "&sexo=" + cli.getSexo() + "&dt_nascto=" + cli.getDtNascto() + "&saldo=" + cli.getSaldoDevedor() + "&ativo=" + cli.getAtivo() + "\" "
                                            + "class=\"btn btn-primary\" role=\"button\">Alterar</a></td>");
                                    out.println("</tr>");
                                }

                                out.println("</tbody>");
                                out.println("</table>");
                            }
                        %> 
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
