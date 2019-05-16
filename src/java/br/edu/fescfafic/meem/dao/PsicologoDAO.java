/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.Endereco;
import br.edu.fescfafic.meem.model.Login;
import br.edu.fescfafic.meem.model.Psicologo;
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
public class PsicologoDAO {
    
    private Connection connection;
    
    public PsicologoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean cadastrar(Psicologo psicologo){
        try {
            String sql = "INSERT INTO psicologo (nome, sobrenome, sexo, rua, bairro,"
                    + " cidade, estado, usuario, senha, email) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getSobrenome());
            stmt.setString(3, psicologo.getSexo());
            stmt.setString(4, psicologo.getEndereco().getRua());
            stmt.setString(5, psicologo.getEndereco().getBairro());
            stmt.setString(6, psicologo.getEndereco().getCidade());
            stmt.setString(7, psicologo.getEndereco().getEstado());
            stmt.setString(8, psicologo.getLogin().getUsuario());
            stmt.setString(9, psicologo.getLogin().getSenha());
            stmt.setString(10, psicologo.getEmail());
            
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:PsicologoDAO:cadastrar = " + ex);
        }
        return false;
    }
    
    public List<Psicologo> listar(){
        try {
            List<Psicologo> psicologos = new ArrayList<>();
            String sql = "SELECT * FROM psicologo";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Psicologo psicologo = new Psicologo();
                psicologo.setId(rs.getInt("id"));
                psicologo.setNome(rs.getString("nome"));
                psicologo.setSobrenome(rs.getString("sobrenome"));
                
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                psicologo.setEndereco(endereco);
                Login login = new Login();
                login.setUsuario("usuario");
                login.setSenha("senha");
                psicologo.setLogin(login);
                
                psicologos.add(psicologo);
            }
            rs.close();
            stmt.close();
            return psicologos;
        } catch (SQLException ex) {
            System.out.println("Erro:PsicologoDAO:listar = " + ex);
        }
        return null;
    }
    
    public Psicologo buscarPsicologoLogin(Login login){
        try {
            String sql = "SELECT * FROM psicologo WHERE usuario = ? and senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, login.getUsuario());
            stmt.setString(2, login.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Psicologo psicologo = new Psicologo();
                psicologo.setId(rs.getInt("id"));
                psicologo.setNome(rs.getString("nome"));
                psicologo.setSobrenome(rs.getString("sobrenome"));
                
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                psicologo.setLogin(login);
                
                psicologo.setEndereco(endereco);
                
                return psicologo;
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro:PsicologoDAO:buscarPsicologoLogin = " + ex);
        }
        return null;
    }
    
    public int returnIdPsicologo(Login login){
        try {
            String sql = "SELECT id FROM psicologo WHERE usuario = ? AND senha = ? ";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, login.getUsuario());
            stmt.setString(2, login.getSenha());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PsicologoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
        
    
    public int quantidadePacientes(int idPsicologo){
        try {
            String sql = "SELECT COUNT(*) as quantidadePacientes FROM paciente WHERE id_psicologo = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idPsicologo);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("quantidadePacientes");
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PsicologoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
