
import br.edu.fescfafic.meem.dao.PacienteDAO;
import br.edu.fescfafic.meem.dao.PsicologoDAO;
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
        PacienteDAO pDAO = new PacienteDAO();
        System.out.println(pDAO.numPaciente(6));
    }
    
}
