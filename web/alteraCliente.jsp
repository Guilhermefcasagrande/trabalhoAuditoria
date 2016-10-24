<%-- 
    Document   : alteraCliente
    Created on : 23/10/2016, 21:33:11
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar Clientes</title>

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
            String cep = request.getParameter("cep");
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String sexo = request.getParameter("sexo");
            String dt_nascto = request.getParameter("dt_nascto");
            Double saldo = Double.parseDouble(request.getParameter("saldo"));
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
                <form role="form" action="trataAlteraCliente.jsp" method="post">
                    <div class="form-group">
                        <label>Código</label>
                        <input class="form-control" name="codigo" id="codigo" value="<%=codigo%>">
                    </div>

                    <div class="form-group">
                        <label>CEP</label>
                        <input class="form-control" name="cep" id="cep" value="<%=cep%>">
                    </div>

                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" name="nome" id="nome" value="<%=nome%>">
                    </div>

                    <div class="form-group">
                        <label>Endereço</label>
                        <input class="form-control" name="endereco" id="endereco" value="<%=endereco%>">
                    </div>
                    
                    <div class="form-group">
                        <label>Sexo</label>
                        <input class="form-control" name="sexo" id="sexo" value="<%=sexo%>">
                    </div>
                    
                    <div class="form-group">
                        <label>Data de Nascimento</label>
                        <input class="form-control" name="dt_nascto" id="dt_nascto" value="<%=dt_nascto%>">
                    </div>
                    
                    <div class="form-group">
                        <label>Saldo</label>
                        <input class="form-control" name="saldo" id="saldo" value="<%=saldo%>">
                    </div>
                    
                    <div class="form-group">
                        <label>Ativo</label>
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
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })
        </script>	
    </body>

</html>
