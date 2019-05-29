/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.Exame;
import br.edu.fescfafic.meem.model.TipoExame;
import br.edu.fescfafic.meem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
                    + "q5a, q5b, q5c, q6a, q6b, q7a, q8a, q8b, q8c, q9a, q10a, q11a, id_paciente) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            
            stmt.setInt(32, exame.getPaciente().getId());
            
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Exame> listarPorPaciente(int idPaciente){
        List<Exame> exames = new ArrayList<>();
        try {
            String sql = "SELECT * FROM exame as e JOIN tipo_exame as te ON e.id_tipo_exame = te.id WHERE id_paciente = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Exame exame = new Exame();
                exame.setId(rs.getInt("id"));
                
                exame.setQ1a(rs.getInt("q1a"));
                exame.setQ1b(rs.getInt("q1b"));
                exame.setQ1c(rs.getInt("q1c"));
                exame.setQ1d(rs.getInt("q1d"));
                exame.setQ1e(rs.getInt("q1e"));
                
                exame.setQ2a(rs.getInt("q2a"));
                exame.setQ2b(rs.getInt("q2b"));
                exame.setQ2c(rs.getInt("q2c"));
                exame.setQ2d(rs.getInt("q2d"));
                exame.setQ2e(rs.getInt("q2e"));
                
                exame.setQ3a(rs.getInt("q3a"));
                exame.setQ3b(rs.getInt("q3b"));
                exame.setQ3c(rs.getInt("q3c"));
                
                exame.setQ4a(rs.getInt("q4a"));
                exame.setQ4b(rs.getInt("q4b"));
                exame.setQ4c(rs.getInt("q4c"));
                exame.setQ4d(rs.getInt("q4d"));
                exame.setQ4e(rs.getInt("q4e"));
                
                exame.setQ5a(rs.getInt("q5a"));
                exame.setQ5b(rs.getInt("q5b"));
                exame.setQ5c(rs.getInt("q5c"));
                
                exame.setQ6a(rs.getInt("q6a"));
                exame.setQ6b(rs.getInt("q6b"));
                
                exame.setQ7a(rs.getInt("q7a"));
                
                exame.setQ8a(rs.getInt("q8a"));
                exame.setQ8b(rs.getInt("q8b"));
                exame.setQ8c(rs.getInt("q8c"));
                
                exame.setQ9a(rs.getInt("q9a"));
                
                exame.setQ10a(rs.getInt("q10a"));
                
                exame.setQ11a(rs.getInt("q11a"));
                
                TipoExame tipoExame = new TipoExame();
                tipoExame.setTipo(rs.getString("tipo"));
                
                exame.setTipoExame(tipoExame);
                
                exame.setPontuacao(pontuacao(exame.getId()));
                
                exames.add(exame);
            }
            return exames;
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Exame recuperarPorExame(int idExame){
        try {
            String sql = "SELECT * FROM exame as e JOIN tipo_exame as te ON e.id_tipo_exame = te.id WHERE e.id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idExame);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Exame exame = new Exame();
                
                exame.setId(rs.getInt("id"));
                
                exame.setQ1a(rs.getInt("q1a"));
                exame.setQ1b(rs.getInt("q1b"));
                exame.setQ1c(rs.getInt("q1c"));
                exame.setQ1d(rs.getInt("q1d"));
                exame.setQ1e(rs.getInt("q1e"));
                
                exame.setQ2a(rs.getInt("q2a"));
                exame.setQ2b(rs.getInt("q2b"));
                exame.setQ2c(rs.getInt("q2c"));
                exame.setQ2d(rs.getInt("q2d"));
                exame.setQ2e(rs.getInt("q2e"));
                
                exame.setQ3a(rs.getInt("q3a"));
                exame.setQ3b(rs.getInt("q3b"));
                exame.setQ3c(rs.getInt("q3c"));
                
                exame.setQ4a(rs.getInt("q4a"));
                exame.setQ4b(rs.getInt("q4b"));
                exame.setQ4c(rs.getInt("q4c"));
                exame.setQ4d(rs.getInt("q4d"));
                exame.setQ4e(rs.getInt("q4e"));
                
                exame.setQ5a(rs.getInt("q5a"));
                exame.setQ5b(rs.getInt("q5b"));
                exame.setQ5c(rs.getInt("q5c"));
                
                exame.setQ6a(rs.getInt("q6a"));
                exame.setQ6b(rs.getInt("q6b"));
                
                exame.setQ7a(rs.getInt("q7a"));
                
                exame.setQ8a(rs.getInt("q8a"));
                exame.setQ8b(rs.getInt("q8b"));
                exame.setQ8c(rs.getInt("q8c"));
                
                exame.setQ9a(rs.getInt("q9a"));
                
                exame.setQ10a(rs.getInt("q10a"));
                
                exame.setQ11a(rs.getInt("q11a"));
                
                TipoExame tipoExame = new TipoExame();
                tipoExame.setTipo(rs.getString("tipo"));
                
                exame.setTipoExame(tipoExame);
                
                exame.setPontuacao(pontuacao(exame.getId()));
                
                return exame;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int pontuacao(int idExame){
        try {
            String sql = "SELECT SUM(q1a  +  q1b  +  q1c  +  q1d  +  q1e  +  q2a  +  q2b +  q2c +  q2d +  q2e +  q3a +  q3b +  q3c +  q4a +  q4b +  q4c +  q4d +  q4e + q5a + q5b +  q5c +  q6a +  q6b +  q7a +  q8a +  q8b +  q8c +  q9a +  q10a +  q11a) as pontuacao FROM exame WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idExame);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("pontuacao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int quantidadeExamesRealizados(int idPsicologo){
        try {
            String sql = "SELECT COUNT(*) as quantidadeExames FROM exame as e JOIN paciente as p ON p.id = e.id_paciente WHERE p.id_psicologo = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idPsicologo);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("quantidadeExames");
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public double mediaPontuacaoExame(int idPsicologo){
        try {
            String sql = "SELECT AVG(q1a  +  q1b  +  q1c  +  q1d  +  q1e  +  q2a  +  q2b +  q2c +  q2d +  q2e +  q3a +  q3b +  q3c +  q4a +  q4b +  q4c +  q4d +  q4e + q5a + q5b +  q5c +  q6a +  q6b +  q7a +  q8a +  q8b +  q8c +  q9a +  q10a +  q11a) as mediaPontuacao FROM exame as e JOIN paciente as p ON p.id = e.id_paciente WHERE p.id_psicologo = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idPsicologo);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("mediaPontuacao");
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
