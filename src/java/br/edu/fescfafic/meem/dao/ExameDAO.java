/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.Exame;
import br.edu.fescfafic.meem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gutemberg
 */
public class ExameDAO {
    
    private Connection connection;
    
    public ExameDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean inserir(Exame exame){
        try {
            String sql = "INSERT INTO exame (id_tipo_exame, q1a ,q1b, q1c, q1d, q1e, "
                    + "q2a, q2b, q2c, q2d, q2e, q3a, q3b, q3c, q4a, q4b, q4c, q4d, q4e, "
                    + "q5a, q5b, q5c, q6a, q6b, q7a, q8a, q8b, q8c, q9a, q10a, q11a) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, 1); //exame.getIdTipoExame()
            stmt.setInt(2, exame.getQ1a());
            stmt.setInt(3, exame.getQ1b());
            stmt.setInt(4, exame.getQ1c());
            stmt.setInt(5, exame.getQ1d());
            stmt.setInt(6, exame.getQ1e());
            
            stmt.setInt(7, exame.getQ2a());
            stmt.setInt(8, exame.getQ2b());
            stmt.setInt(9, exame.getQ2c());
            stmt.setInt(10, exame.getQ2d());
            stmt.setInt(11, exame.getQ2e());
            
            stmt.setInt(12, exame.getQ3a());
            stmt.setInt(13, exame.getQ3b());
            stmt.setInt(14, exame.getQ3c());
            
            stmt.setInt(15, exame.getQ4a());
            stmt.setInt(16, exame.getQ4b());
            stmt.setInt(17, exame.getQ4c());
            stmt.setInt(18, exame.getQ4d());
            stmt.setInt(19, exame.getQ4e());
            
            stmt.setInt(20, exame.getQ5a());
            stmt.setInt(21, exame.getQ5b());
            stmt.setInt(22, exame.getQ5c());
            
            stmt.setInt(23, exame.getQ6a());
            stmt.setInt(24, exame.getQ6b());
            
            stmt.setInt(25, exame.getQ7a());
            
            stmt.setInt(26, exame.getQ8a());
            stmt.setInt(27, exame.getQ8b());
            stmt.setInt(28, exame.getQ8c());
            
            stmt.setInt(29, exame.getQ9a());
            
            stmt.setInt(30, exame.getQ10a());
            
            stmt.setInt(31, exame.getQ11a());
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int pountuacao(int id){
        try {
            String sql = "SELECT SUM(" +
                    "	q1a + q1b + q1c + q1d + q1e +" +
                    "	q2a + q2b + q2c + q2d + q2e +" +
                    "	q3a + q3b + q3c +" +
                    "	q4a + q4b + q4c + q4d + q4e +" +
                    "	q5a + q5b + q5c +" +
                    "	q6a + q6b +" +
                    "	q7a +" +
                    "	q8a + q8b + q8c +" +
                    "	q9a +" +
                    "	q10a +" +
                    "	q11a" +
                    ") AS pontuacao FROM exame WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("pontuacao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
