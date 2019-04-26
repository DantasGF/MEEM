/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.LoginDAO;
import br.edu.fescfafic.meem.model.Psicologo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author COMPUTER
 */
public class EditarSenhaPsicologoController extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String senhaAntiga = request.getParameter("senhaAntiga");
        String senhaNova1 = request.getParameter("senhaNova1");
        String senhaNova2 = request.getParameter("senhaNova2");
        
        Psicologo psicologo = (Psicologo) request.getSession().getAttribute("psicologo");
        
        LoginDAO loginDAO = new LoginDAO();

        if (psicologo.getLogin().getSenha().equals(senhaAntiga)) {
            if (senhaNova1.equals(senhaNova2)) {
                loginDAO.alterarSenha(id, senhaNova1);
                response.sendRedirect("./area-psicologo.jsp");
            }
            else{
                String url = "erro-alterar-senha.jsp";
                response.sendRedirect(url);
            }
        }
        else{
            String url = "erro-alterar-senha.jsp";
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
