
import br.edu.fescfafic.meem.dao.PsicologoDAO;
import br.edu.fescfafic.meem.model.Endereco;
import br.edu.fescfafic.meem.model.Psicologo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gutemberg
 */
public class CadastrarPsicologo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setRua("sasdasdsd");
        endereco.setBairro("asdasdas");
        endereco.setCidade("asdasdas");
        endereco.setEstado("asdasdasdasd");
        
        Psicologo psicologo = new Psicologo();
        psicologo.setNome("masdasdse");
        psicologo.setSobrenome("sadasdsad");
        psicologo.setEndereco(endereco);
        psicologo.setUsuario("asdasdasd");
        psicologo.setSenha("nhsadasdasa");
        
        PsicologoDAO psicologoDAO = new PsicologoDAO();
        psicologoDAO.cadastrar(psicologo);
    }
    
}
