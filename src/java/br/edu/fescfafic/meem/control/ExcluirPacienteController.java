package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.ExameDAO;
import br.edu.fescfafic.meem.dao.PacienteDAO;
import br.edu.fescfafic.meem.dao.PsicologoDAO;
import br.edu.fescfafic.meem.model.Login;
import br.edu.fescfafic.meem.model.Psicologo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author COMPUTER
 */
public class ExcluirPacienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Psicologo psicologo = (Psicologo)request.getSession().getAttribute("psicologo");
        int id = Integer.parseInt(request.getParameter("id"));
        
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.excluir(id);
        
        HttpSession sessao = request.getSession();
        Login login = new Login();
        login.setUsuario(psicologo.getLogin().getUsuario());
        login.setSenha(psicologo.getLogin().getSenha());
        sessao.setAttribute("quantidadePaciente", new PsicologoDAO()
                .quantidadePacientes(new PsicologoDAO().returnIdPsicologo(login)));
        sessao.setAttribute("quantidadeExames", new ExameDAO()
                .quantidadeExamesRealizados(new PsicologoDAO().returnIdPsicologo(login)));
        sessao.setAttribute("mediaPontuacaoExames", new ExameDAO()
                .mediaPontuacaoExame(new PsicologoDAO().returnIdPsicologo(login)));
        
        response.sendRedirect("./ListarPacientesController");
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
