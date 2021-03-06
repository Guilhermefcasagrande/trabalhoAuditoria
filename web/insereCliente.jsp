<%-- 
    Document   : insereCliente
    Created on : 21/10/2016, 09:08:02
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
                    <h1 class="page-header">Incluir Novo Cliente</h1>
                </div>
            </div><!--/.row-->	

            <div class="row">
                <form role="form" action="trataCliente.jsp" method="post">
                    <div class="form-group">
                        <label>CEP</label>
                        <select class="form-control" id="cep" name="cep">
                            <%
                                String sql = "select cep, nome from cidade order by cep";

                                //Connection conexao = ConexaoElep.getConnection();
                                Connection conexao = ConexaoPostgres.getConnection();
                                Statement stm = conexao.createStatement();
                                ResultSet rs = stm.executeQuery(sql);
                                while (rs.next()) {
                                    int cep = rs.getInt("cep");
                                    String nome = rs.getString("nome");

                                    out.println("<option value=" + cep + ">" + nome + "</option>");
                                }
                                //ConexaoElep.fechaConexao(conexao);
                                ConexaoPostgres.fechaConexao(conexao);
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" name="nome" id="nome">
                    </div>

                    <div class="form-group">
                        <label>Endereço</label>
                        <input class="form-control" name="endereco" id="estado">
                    </div>

                    <div class="form-group">
                        <label>Sexo</label>
                        <select class="form-control" id="sexo" name="sexo">
                            <option value="M">M</option>
                            <option value="F">F</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Data de Nascimento</label>
                        <input class="form-control" name="dt_nascto" id="estado">
                    </div>

                    <div class="form-group">
                        <label>Saldo Devedor</label>
                        <input class="form-control" name="saldo" id="estado">
                    </div>

                    <div class="form-group">
                        <label>Ativo</label>
                       <select class="form-control" id="ativo" name="ativo">
                            <option value="S">S</option>
                            <option value="N">N</option>
                        </select>
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
