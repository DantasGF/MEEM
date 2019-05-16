package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.ExameDAO;
import br.edu.fescfafic.meem.dao.PsicologoDAO;
import br.edu.fescfafic.meem.model.Exame;
import br.edu.fescfafic.meem.model.Login;
import br.edu.fescfafic.meem.model.Paciente;
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
 * @author Gutemberg
 */
public class CadastrarExameController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Psicologo psicologo = (Psicologo)request.getSession().getAttribute("psicologo");
        int idPaciente = Integer.parseInt(request.getParameter("pid"));
        
        int q1a = 0;
        int q1b = 0;
        int q1c = 0;
        int q1d = 0;
        int q1e = 0;
        
        int q2a = 0;
        int q2b = 0;
        int q2c = 0;
        int q2d = 0;
        int q2e = 0;
        
        int q3a = 0;
        int q3b = 0;
        int q3c = 0;
        
        int q4a = 0;
        int q4b = 0;
        int q4c = 0;
        int q4d = 0;
        int q4e = 0;
        
        int q5a = 0;
        int q5b = 0;
        int q5c = 0;
        
        int q6a = 0;
        int q6b = 0;
        
        int q7a = 0;
        
        int q8a = 0;
        int q8b = 0;
        int q8c = 0;
        
        int q9a = 0;
        
        int q10a = 0;
        
        int q11a = 0;
        
        if(request.getParameter("q1a") != null){
            q1a = Integer.parseInt(request.getParameter("q1a"));
        }
        if(request.getParameter("q1b") != null){
            q1b = Integer.parseInt(request.getParameter("q1b"));
        }
        if(request.getParameter("q1c") != null){
            q1c = Integer.parseInt(request.getParameter("q1c"));
        }
        if(request.getParameter("q1d") != null){
            q1d = Integer.parseInt(request.getParameter("q1d"));
        }
        if(request.getParameter("q1e") != null){
            q1e = Integer.parseInt(request.getParameter("q1e"));
        }
        if(request.getParameter("q2a") != null){
            q2a = Integer.parseInt(request.getParameter("q2a"));
        }
        if(request.getParameter("q2b") != null){
            q2b = Integer.parseInt(request.getParameter("q2b"));
        }
        if(request.getParameter("q2c") != null){
            q2c = Integer.parseInt(request.getParameter("q2c"));
        }
        if(request.getParameter("q2d") != null){
            q2d = Integer.parseInt(request.getParameter("q2d"));
        }
        if(request.getParameter("q2e") != null){
            q2e = Integer.parseInt(request.getParameter("q2e"));
        }
        if(request.getParameter("q3a") != null){
            q3a = Integer.parseInt(request.getParameter("q3a"));
        }
        if(request.getParameter("q3b") != null){
            q3b = Integer.parseInt(request.getParameter("q3b"));
        }
        if(request.getParameter("q3c") != null){
            q3c = Integer.parseInt(request.getParameter("q3c"));
        }
        if(request.getParameter("q4a") != null){
            q4a = Integer.parseInt(request.getParameter("q4a"));
        }
        if(request.getParameter("q4b") != null){
            q4b = Integer.parseInt(request.getParameter("q4b"));
        }
        if(request.getParameter("q4c") != null){
            q4c = Integer.parseInt(request.getParameter("q4c"));
        }
        if(request.getParameter("q4d") != null){
            q4d = Integer.parseInt(request.getParameter("q4d"));
        }
        if(request.getParameter("q4e") != null){
            q4e = Integer.parseInt(request.getParameter("q4e"));
        }
        if(request.getParameter("q5a") != null){
            q5a = Integer.parseInt(request.getParameter("q5a"));
        }
        if(request.getParameter("q5b") != null){
            q5b = Integer.parseInt(request.getParameter("q5b"));
        }
        if(request.getParameter("q5c") != null){
            q5c = Integer.parseInt(request.getParameter("q5c"));
        }
        if(request.getParameter("q6a") != null){
            q6a = Integer.parseInt(request.getParameter("q6a"));
        }
        if(request.getParameter("q6b") != null){
            q6b = Integer.parseInt(request.getParameter("q6b"));
        }
        if(request.getParameter("q7a") != null){
            q7a = Integer.parseInt(request.getParameter("q7a"));
        }
        if(request.getParameter("q8a") != null){
            q8a = Integer.parseInt(request.getParameter("q8a"));
        }
        if(request.getParameter("q8b") != null){
            q8b = Integer.parseInt(request.getParameter("q8b"));
        }
        if(request.getParameter("q8c") != null){
            q8c = Integer.parseInt(request.getParameter("q8c"));
        }
        if(request.getParameter("q9a") != null){
            q9a = Integer.parseInt(request.getParameter("q9a"));
        }
        if(request.getParameter("q10a") != null){
            q10a = Integer.parseInt(request.getParameter("q10a"));
        }
        if(request.getParameter("q11a") != null){
            q11a = Integer.parseInt(request.getParameter("q11a"));
        }
        
        Exame exame = new Exame();
        exame.setQ1a(q1a);
        exame.setQ1b(q1b);
        exame.setQ1c(q1c);
        exame.setQ1d(q1d);
        exame.setQ1e(q1e);
        
        exame.setQ2a(q2a);
        exame.setQ2b(q2b);
        exame.setQ2c(q2c);
        exame.setQ2d(q2d);
        exame.setQ2e(q2e);
        
        exame.setQ3a(q3a);
        exame.setQ3b(q3b);
        exame.setQ3c(q3c);
        
        exame.setQ4a(q4a);
        exame.setQ4b(q4b);
        exame.setQ4c(q4c);
        exame.setQ4d(q4d);
        exame.setQ4e(q4e);
        
        exame.setQ5a(q5a);
        exame.setQ5b(q5b);
        exame.setQ5c(q5c);
        
        exame.setQ6a(q6a);
        exame.setQ6b(q6b);
        
        exame.setQ7a(q7a);
        
        exame.setQ8a(q8a);
        exame.setQ8b(q8b);
        exame.setQ8c(q8c);
        
        exame.setQ9a(q9a);
        
        exame.setQ10a(q10a);
        
        exame.setQ11a(q11a);
        
        Paciente paciente = new Paciente();
        paciente.setId(idPaciente);
        
        exame.setPaciente(paciente);
        
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.inserir(exame);
        
        HttpSession sessao = request.getSession();
        Login login = new Login();
        login.setUsuario(psicologo.getLogin().getUsuario());
        login.setSenha(psicologo.getLogin().getSenha());
        sessao.setAttribute("quantidadeExames", new ExameDAO()
                .quantidadeExamesRealizados(new PsicologoDAO().returnIdPsicologo(login)));
        sessao.setAttribute("mediaPontuacaoExames", new ExameDAO()
                .mediaPontuacaoExame(new PsicologoDAO().returnIdPsicologo(login)));
        
        request.getRequestDispatcher("./RecuperarPacienteController?id=" 
                + idPaciente).forward(request, response);
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
