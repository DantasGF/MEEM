/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.Psicologo;
import br.edu.fescfafic.meem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            String sql = "INSERT INTO psicologo (nome, sobrenome, rua, bairro,"
                    + " cidade, estado, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getSobrenome());
            stmt.setString(3, psicologo.getEndereco().getRua());
            stmt.setString(4, psicologo.getEndereco().getBairro());
            stmt.setString(5, psicologo.getEndereco().getCidade());
            stmt.setString(6, psicologo.getEndereco().getEstado());
            stmt.setString(7, psicologo.getUsuario());
            stmt.setString(8, psicologo.getSenha());
            
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:PsicologoDAO:cadastrar = " + ex);
        }
        return false;
    }
}
