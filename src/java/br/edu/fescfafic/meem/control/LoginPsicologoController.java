/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.ExameDAO;
import br.edu.fescfafic.meem.dao.LoginDAO;
import br.edu.fescfafic.meem.dao.PsicologoDAO;
import br.edu.fescfafic.meem.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author COMPUTER
 */
public class LoginPsicologoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        Login login = new Login();
        login.setUsuario(usuario);
        login.setSenha(senha);
        
        LoginDAO loginDAO = new LoginDAO();
        if (loginDAO.validar(login)){
            
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("psicologo", new PsicologoDAO()
                    .buscarPsicologoLogin(login));
            
            
            
            
            sessao.setAttribute("quantidadePaciente", new PsicologoDAO()
                    .quantidadePacientes(new PsicologoDAO().returnIdPsicologo(login)));
            sessao.setAttribute("quantidadeExames", new ExameDAO()
                    .quantidadeExamesRealizados(new PsicologoDAO().returnIdPsicologo(login)));
            sessao.setAttribute("mediaPontuacaoExames", new ExameDAO()
                    .mediaPontuacaoExame(new PsicologoDAO().returnIdPsicologo(login)));
            response.sendRedirect("./area-psicologo.jsp");
        }
        else{
            String url = "erro-login.jsp";
            response.sendRedirect(url);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
