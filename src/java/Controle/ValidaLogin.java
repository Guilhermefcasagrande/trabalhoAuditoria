/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Guilherme
 */
public class ValidaLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista

        User user = null;
        String loginForm = request.getParameter("usuario"); // Pega o Login vindo do formulario
        String senhaForm = request.getParameter("senha"); //Pega a senha vinda do formulario

        try {
            UserDB udb = new UserDB();
            user = udb.getUsuario(loginForm, senhaForm);
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
         se nao encontrou usuario no banco, redireciona para a pagina de erro, 
         e atualiza as tentativasde login.
         */
        if (user == null) {
            UserDB udb = new UserDB();
            boolean alterou = udb.updateTentativasLoginErro(loginForm);
            System.out.println("Errrouuu " + alterou);

            if (alterou == true) {
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                System.out.println("Aqui será enviado o email");
                //EnvioEmail.enviaEmail(loginForm);
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {//se o DB retornar um usuario, coloca na sessao
            if (user.getStAtivo().equals("N")) {
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                System.out.println("Usuario desativado");
            } else {
                UserDB udb = new UserDB();
                boolean alterou = udb.updateTentativasLogin(loginForm);

                session.setAttribute("user", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
}
