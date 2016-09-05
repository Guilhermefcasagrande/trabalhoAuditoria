/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Cidade;
import View.CidadeDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet("/insereCidade")
public class InsereCidadeServlet extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        // busca o writer
        PrintWriter out = response.getWriter();

        // buscando os parâmetros no request
        String cep = request.getParameter("cep");
        String nome = request.getParameter("nome");
        String estado = request.getParameter("estado");

        // monta um objeto cidade
        Cidade cidade = new Cidade();
        
        cidade.setCep(Integer.parseInt(cep));
        cidade.setNome(nome);
        cidade.setEstado(estado);

        // salva a cidade
        CidadeDao dao = new CidadeDao();
        dao.adiciona(cidade);

        // imprime o nome da cidade que foi adicionada
        out.println("<html>");
        out.println("<body>");
        out.println("Cidade " + cidade.getNome()
                + " adicionada com sucesso");
        out.println("</body>");
        out.println("</html>");
    }

}
