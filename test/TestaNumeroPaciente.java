
import br.edu.fescfafic.meem.dao.ExameDAO;
import br.edu.fescfafic.meem.dao.PacienteDAO;
import br.edu.fescfafic.meem.dao.PsicologoDAO;
import br.edu.fescfafic.meem.model.Login;
import br.edu.fescfafic.meem.model.Psicologo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author COMPUTER
 */
public class TestaNumeroPaciente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PacienteDAO pDAO = new PacienteDAO();
        //System.out.println(pDAO.numPaciente(6));
        
        Login login = new Login();
        login.setUsuario("02");
        login.setSenha("02");
        ExameDAO eDAO = new ExameDAO();
        System.out.println(eDAO.mediaPontuacaoExame(new PsicologoDAO().returnIdPsicologo(login)));
    }
    
}
