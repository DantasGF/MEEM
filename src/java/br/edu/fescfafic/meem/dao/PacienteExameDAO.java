/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.PacienteExame;
import br.edu.fescfafic.meem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gutemberg
 */
public class PacienteExameDAO {
    
    private Connection connection;
    
    public PacienteExameDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean inserir(PacienteExame pacienteExame){
        try {
            String sql = "INSERT INTO (id_paciente, id_exame) VALUES (?, ?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setInt(1, pacienteExame.getPaciente().getId());
            stmt.setInt(2, pacienteExame.getExame().getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
