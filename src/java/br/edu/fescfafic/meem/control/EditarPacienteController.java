package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.PacienteDAO;
import br.edu.fescfafic.meem.model.Endereco;
import br.edu.fescfafic.meem.model.Paciente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laelkayo
 */
public class EditarPacienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = new PacienteDAO().recuperarPaciente(id);
        request.setAttribute("paciente", paciente);
        request.getRequestDispatcher("./edita-paciente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String telefone = request.getParameter("telefone");
        
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        
        Paciente paciente = new Paciente();
        paciente.setId(id);
        paciente.setNome(nome);
        paciente.setSobrenome(sobrenome);
        paciente.setEndereco(endereco);
        paciente.setTelefone(telefone);
        
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.editar(paciente);
        
        response.sendRedirect("./ListarPacientesController");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
