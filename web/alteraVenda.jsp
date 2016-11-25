<%-- 
    Document   : trataAlteraVenda
    Created on : 25/11/2016, 20:33:23
    Author     : Guilherme
--%>

<%@page import="Conexao.ConexaoPostgres"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar venda</title>

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
            
            String cliente = request.getParameter("cliente");
            String cep = request.getParameter("cep");
            String produto = request.getParameter("produto");
            String data = request.getParameter("data");
            String qtd = request.getParameter("qtd");
            String dt_pagto = request.getParameter("dt_pagto");
            Double valor = Double.parseDouble(request.getParameter("valor"));
        
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
                    <h1 class="page-header">Alterar Venda</h1>
                </div>
            </div><!--/.row-->	

            <div class="row">
                <form role="form" action="trataAlteraVenda.jsp" method="post">
                    <div class="form-group">
                        <label>Cliente</label>
                        <input class="form-control" name="cliente" id="cliente" readonly value="<%=cliente%>">
                    </div>

                    <div class="form-group">
                        <label>CEP</label>
                        <input class="form-control" name="cep" id="cep" readonly value="<%=cep%>">
                    </div>

                    <div class="form-group">
                        <label>Produto</label>
                        <input class="form-control" name="produto" id="produto" readonly value="<%=produto%>">
                    </div>

                    <div class="form-group">
                        <label>Data</label>
                        <input class="form-control" name="data" id="data" value="<%=data%>">
                    </div>

                    <div class="form-group">
                        <label>Quantidade</label>
                        <input class="form-control" name="qtd" id="qtd" value="<%=qtd%>">
                    </div>

                    <div class="form-group">
                        <label>Data do Pagamento</label>
                        <input class="form-control" name="data_pagto" id="data_pagto" value="<%=dt_pagto%>">
                    </div>

                    <div class="form-group">
                        <label>Valor Pago</label>
                        <input class="form-control" name="valor_pagto" id="valor_pagto" value="<%=valor%>">
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
