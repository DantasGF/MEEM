/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.Endereco;
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
                psicologo.setUsuario("usuario");
                psicologo.setSenha("senha");
                
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
}
