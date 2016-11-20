<%-- 
    Document   : insereVenda
    Created on : 24/10/2016, 12:10:00
    Author     : guilherme
--%>

<%@page import="Conexao.ConexaoPostgres"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Conexao.ConexaoElep"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Clientes</title>

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
            User user = (User) session.getAttribute("user");

            if (user == null) {
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
                    <h1 class="page-header">Incluir Nova Venda</h1>
                </div>
            </div><!--/.row-->	

            <div class="row">
                <form role="form" action="trataVenda.jsp" method="post">
                    <div class="form-group">
                        <label>Cliente</label>
                        <select class="form-control" id="cliente" name="cliente">
                            <%
                                String sql = "select cli_codigo, nome from cliente order by cli_codigo";

                                //Connection conexao = ConexaoElep.getConnection();
                                Connection conexao = ConexaoPostgres.getConnection();
                                Statement stm = conexao.createStatement();
                                ResultSet rs = stm.executeQuery(sql);
                                while (rs.next()) {
                                    int cliCodigo = rs.getInt("cli_codigo");
                                    String nome = rs.getString("nome");

                                    out.println("<option value=" + cliCodigo + ">" + nome + "</option>");
                                }
                                //ConexaoElep.fechaConexao(conexao);
                                ConexaoPostgres.fechaConexao(conexao);
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>CEP</label>
                        <select class="form-control" id="cep" name="cep">
                            <%
                                String sqlCep = "select cep, nome from cidade order by cep";
                                //Connection conexao2 = ConexaoElep.getConnection();
                                Connection conexao2 = ConexaoPostgres.getConnection();
                                Statement stm2 = conexao2.createStatement();
                                ResultSet rs2 = stm2.executeQuery(sqlCep);
                                while (rs2.next()) {
                                    int cep = rs2.getInt("cep");
                                    String nome = rs2.getString("nome");

                                    out.println("<option value=" + cep + ">" + nome + "</option>");
                                }
                                //ConexaoElep.fechaConexao(conexao2);
                                ConexaoPostgres.fechaConexao(conexao);
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Produto</label>
                        <select class="form-control" id="produto" name="produto">
                            <%
                                String sqlProd = "select pro_codigo, descricao from produto order by pro_codigo";
                                //Connection conexao3 = ConexaoElep.getConnection();
                                Connection conexao3 = ConexaoPostgres.getConnection();
                                Statement stm3 = conexao3.createStatement();
                                ResultSet rs3 = stm3.executeQuery(sqlProd);
                                while (rs3.next()) {
                                    int produto = rs3.getInt("pro_codigo");
                                    String descricao = rs3.getString("descricao");

                                    out.println("<option value=" + produto + ">" + descricao + "</option>");
                                }
                                //ConexaoElep.fechaConexao(conexao3);
                                ConexaoPostgres.fechaConexao(conexao);
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Data</label>
                        <input class="form-control" name="data" id="data">
                    </div>

                    <div class="form-group">
                        <label>Quantidade</label>
                        <input class="form-control" name="qtd" id="qtd">
                    </div>

                    <div class="form-group">
                        <label>Data do Pagamento</label>
                        <input class="form-control" name="data_pagto" id="data_pagto">
                    </div>

                    <div class="form-group">
                        <label>Valor Pago</label>
                        <input class="form-control" name="valor_pagto" id="valor_pagto">
                    </div>

                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Cadastrar">
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
