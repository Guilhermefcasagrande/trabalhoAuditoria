<%-- 
    Document   : alteraProduto
    Created on : 20/10/2016, 09:42:07
    Author     : guilherme
--%>

<%@page import="Modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Produtos</title>

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

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String desc = request.getParameter("descricao");
            double preco = Double.parseDouble(request.getParameter("preco"));
            int qtd = Integer.parseInt(request.getParameter("qtd"));

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
                    <h1 class="page-header">Alterar Produtos</h1>
                </div>
            </div>

            <div class="row">
                <div class="form-group">
                    <a class="btn btn-primary" href="listaProduto.jsp">Cancelar</a>
                </div>
            </div>

            <div class="row">
                <form role="form" action="trataAlteraProduto.jsp" method="post">
                    <div class="form-group">
                        <label>Código</label>
                        <input class="form-control" name="codigo" id="codigo" value="<%=codigo%>">
                    </div>

                    <div class="form-group">
                        <label>Descrição</label>
                        <input class="form-control" name="descricao" id="descricao" value="<%=desc%>">
                    </div>

                    <div class="form-group">
                        <label>Preço</label>
                        <input class="form-control" name="preco" id="preco" value="<%=preco%>">
                    </div>

                    <div class="form-group">
                        <label>Quantidade em Estoque</label>
                        <input class="form-control" name="qtd" id="qtd" value="<%=qtd%>">
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
