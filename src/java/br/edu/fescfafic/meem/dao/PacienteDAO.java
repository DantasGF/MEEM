/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.dao;

import br.edu.fescfafic.meem.model.Endereco;
import br.edu.fescfafic.meem.model.Paciente;
import br.edu.fescfafic.meem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laelkayo
 */
public class PacienteDAO {
    private Connection connection;
    
    public PacienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean cadastrar(Paciente paciente){
        try {
            String sql = "INSERT INTO psicologo (nome, sobrenome, rua, bairro,"
                    + " cidade, estado, sexo, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getSobrenome());
            stmt.setString(3, paciente.getEndereco().getRua());
            stmt.setString(4, paciente.getEndereco().getBairro());
            stmt.setString(5, paciente.getEndereco().getCidade());
            stmt.setString(6, paciente.getEndereco().getEstado());
            stmt.setString(7, paciente.getSexo());
            stmt.setString(8, paciente.getTelefone());
            stmt.setString(9, paciente.getDataNascimento());
            
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema no PacienteDao: cadastrar = " + ex);
        }
        return false;
    }
    
    public List<Paciente> listar(){
        try {
            List<Paciente> pacientes = new ArrayList<>();
            String sql = "SELECT * FROM psicologo";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSobrenome(rs.getString("sobrenome"));
                
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                paciente.setEndereco(endereco);
                paciente.setSexo("sexo");
                paciente.setTelefone("telefone");
                paciente.setDataNascimento("dataNascimento");
                
                pacientes.add(paciente);
            }
            rs.close();
            stmt.close();
            return pacientes;
        } catch (SQLException ex) {
            System.out.println("Erro: PacienteDao: listar = " + ex);
        }
        return null;
    }
}
