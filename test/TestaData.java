
import br.edu.fescfafic.meem.model.Paciente;
import br.edu.fescfafic.meem.model.Pessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gutemberg
 */
public class TestaData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String data = "29/06/1999";
        
        Paciente paciente = new Paciente();
        paciente.setDataNascimento(data);
        
        System.out.println(paciente.getDataNascimento());
        
    }
    
}
