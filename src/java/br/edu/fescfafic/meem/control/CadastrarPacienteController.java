/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.PacienteDAO;
import br.edu.fescfafic.meem.model.Endereco;
import br.edu.fescfafic.meem.model.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laelkayo
 */
public class CadastrarPacienteController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        //String DataNascimento = request.getParameter("DataNascimento");
        String idade = request.getParameter("idade");
        
        
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setSobrenome(sobrenome);
        paciente.setSexo(sexo);
        paciente.setEndereco(endereco);
        paciente.setSexo(sexo);
        paciente.setTelefone(telefone);
        //paciente.setDataNascimento(DataNascimento);
        paciente.setIdade(idade);
        
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.cadastrar(paciente);
        
        String url = "http://localhost:8080/MEEM/sucesso-cadastro.jsp";
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
