<%-- 
    Document   : trataVenda
    Created on : 24/10/2016, 12:28:12
    Author     : guilherme
--%>

<%@page import="Controle.GravaLog"%>
<%@page import="Modelo.Log"%>
<%@page import="Controle.VerificaAcao"%>
<%@page import="Modelo.User"%>
<%@page import="Controle.VendaDB"%>
<%@page import="Modelo.Venda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Vendas</title>

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
                    <h1 class="page-header">Incluir Nova Venda</h1>
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

                            int cliente = Integer.parseInt(request.getParameter("cliente"));
                            int cep = Integer.parseInt(request.getParameter("cep"));
                            int produto = Integer.parseInt(request.getParameter("produto"));
                            String data = request.getParameter("data");
                            int qtd = Integer.parseInt(request.getParameter("qtd"));
                            String dataPagto = request.getParameter("data_pagto");
                            double valor = Double.parseDouble(request.getParameter("valor_pagto"));

                            Venda venda = new Venda();
                            venda.setCep(cep);
                            venda.setCliCodigo(cliente);
                            venda.setProCodigo(produto);
                            venda.setData(data);
                            venda.setQtdVenda(qtd);
                            venda.setDataPagto(dataPagto);
                            venda.setValorPagto(valor);

                            boolean inseriu = VendaDB.insereVenda(venda);

                            if (inseriu) {
                                out.println("<div class=\"alert bg-success\" role=\"alert\">");
                                out.println("<svg class=\"glyph stroked checkmark\">");
                                out.println("<use xlink:href=\"#stroked-checkmark\"></use>");
                                out.println("</svg> Nova venda realizada com sucesso!");
                                out.println("<a href=\"insereVenda.jsp\" class=\"pull-right\">");
                                out.println("<span class=\"glyphicon glyphicon-remove\"></span>");
                                out.println("</a>");
                                out.println("</div>");

                                String acao = "Incluir";
                                VerificaAcao verifica = new VerificaAcao();
                                int acCodigo = verifica.buscaAcao(acao);

                                Log log = new Log();
                                log.setAcCodigo(acCodigo);
                                log.setUsrCodigo(user.getUsrCodigo());
                                log.setTabela("Venda");

                                GravaLog.log(log);

                            } else {
                                out.println("<div class=\"alert bg-danger\" role=\"alert\">");
                                out.println("<svg class=\"glyph stroked cancel\">");
                                out.println("<use xlink:href=\"#stroked-cancel\"></use>");
                                out.println("</svg> Erro no cadastro da Venda!");
                                out.println("<a href=\"insereVenda.jsp\" class=\"pull-right\">");
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
