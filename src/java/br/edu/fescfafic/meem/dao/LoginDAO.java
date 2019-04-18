/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author COMPUTER
 */
public class LoginDAO {
    
    private Connection connection;
    
    public LoginDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean validar(String usuario, String senha){
        try {
            String sql = "SELECT * FROM psicologo "
                    + "WHERE usuario = ? and senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                rs.close();
                stmt.close();
                return true;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:LoginDAO:validar = " + ex);
        }
        return false;
    }
    
    public boolean alterarLogin(int id, String usuario, String senha){
        String sql = "UPDATE psicologo SET usuario = ?, senha = ? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setInt(2,id);
            stmt.execute();
            stmt.close();
            
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }
        return false;
    }
    
     public int idLogin(String usuario, String senha){
        try {
            String sql = "SELECT * FROM psicologo "
                    + "WHERE usuario = ? and senha = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                rs.close();
                stmt.close();
                return rs.getInt("id");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:LoginDAO:validar = " + ex);
        }
        return 0;
    }
}
