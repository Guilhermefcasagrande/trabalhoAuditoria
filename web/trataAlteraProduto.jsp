<%-- 
    Document   : trataAlteraProduto
    Created on : 20/10/2016, 09:56:21
    Author     : guilherme
--%>

<%@page import="Modelo.User"%>
<%@page import="Controle.ProdutoDB"%>
<%@page import="Modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar Produto</title>

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
                    <h1 class="page-header">Alterar Produto</h1>
                </div>
            </div><!--/.row-->	

            <%
                User user = (User) session.getAttribute("user");

                if (user == null) {
                    session.invalidate();
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {

                    int codigo = Integer.parseInt(request.getParameter("codigo"));
                    String descricao = request.getParameter("descricao");
                    double preco = Double.parseDouble(request.getParameter("preco"));
                    int qtd = Integer.parseInt(request.getParameter("qtd"));

                    Produto produto = new Produto();

                    produto.setProCodigo(codigo);
                    produto.setDescricao(descricao);
                    produto.setPreco(preco);
                    produto.setQtdEstoque(qtd);

                    boolean alterou = ProdutoDB.alteraProduto(produto);

                    if (alterou) {
                        out.println("<div class=\"alert bg-success\" role=\"alert\">");
                        out.println("<svg class=\"glyph stroked checkmark\">");
                        out.println("<use xlink:href=\"#stroked-checkmark\"></use>");
                        out.println("</svg> Produto alterado com sucesso!");
                        out.println("<a href=\"listaProduto.jsp\" class=\"pull-right\">");
                        out.println("<span class=\"glyphicon glyphicon-remove\"></span>");
                        out.println("</a>");
                        out.println("</div>");
                    } else {
                        out.println("<div class=\"alert bg-danger\" role=\"alert\">");
                        out.println("<svg class=\"glyph stroked cancel\">");
                        out.println("<use xlink:href=\"#stroked-cancel\"></use>");
                        out.println("</svg> Erro na alteração do produto!");
                        out.println("<a href=\"listaProduto.jsp\" class=\"pull-right\">");
                        out.println("<span class=\"glyphicon glyphicon-remove\"></span>");
                        out.println("</a>");
                        out.println("</div>");
                    }
                }

            %>

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
