package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.Email;
import br.edu.fescfafic.meem.model.Paciente;
import br.edu.fescfafic.meem.model.Psicologo;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gutemberg
 */
public class EnviarEmailController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Psicologo psicologo = (Psicologo)request.getSession().getAttribute("psicologo");
            Email email = new Email();
            email.setSmtpHostMail("smtp.gmail.com");
            email.setSmtpPortMail("465");
            email.setSmtpAuth("true");
            
            Properties props = new Properties();
            props.put("mail.smtp.host", email.getSmtpHostMail());
            props.put("mail.smtp.socketFactory.port", email.getSmtpPortMail());
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", email.getSmtpAuth());
            props.put("mail.smtp.port", email.getSmtpPortMail());
            
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("miniexamedoestadomental@gmail.com", "meem123456");
                        }
                    });
            session.setDebug(true);
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miniexamedoestadomental@gmail.com"));
            
            Paciente dadosPaciente = (Paciente) request.getAttribute("dadosPaciente");
            
            Address[] toUser = InternetAddress.parse(dadosPaciente.getEmail());
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Cadastro realizado com sucesso!");
            
            String mensagem = "Parabéns " +dadosPaciente.getNome() + " " + dadosPaciente.getSobrenome() + "! seu cadastro foi realizado com sucesso! Confirme seus dados a seguir.\n"
                    + "Nome: " + dadosPaciente.getNome() + " " + dadosPaciente.getSobrenome() + "\n";
            if(dadosPaciente.getSexo().equalsIgnoreCase("M")){
                mensagem += "Sexo: Masculino\n";
            }
            else if(dadosPaciente.getSexo().equalsIgnoreCase("F")){
                mensagem += "Sexo: Feminino\n";
            }
            mensagem += "Endereço: Rua, " + dadosPaciente.getEndereco().getRua() 
                    + ", " + dadosPaciente.getEndereco().getBairro() 
                    + ", " + dadosPaciente.getEndereco().getCidade() 
                    + " - " + dadosPaciente.getEndereco().getEstado() + "\n";
            mensagem += "Email: " + dadosPaciente.getEmail() + "\n"
                     + "Telefone: " + dadosPaciente.getTelefone() + "\n"
                    + "Psicólogo(a) atendente: " + psicologo.getNome() + " " + psicologo.getSobrenome() + "\n";
            message.setText(mensagem);
            Transport.send(message);
            
            response.sendRedirect("./ListarPacientesController");
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarEmailController.class.getName())
                    .log(Level.SEVERE, null, ex);
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
