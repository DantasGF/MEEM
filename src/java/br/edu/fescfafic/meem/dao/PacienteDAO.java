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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String sql = "INSERT INTO paciente (nome, sobrenome, sexo, rua, bairro,"
                    + " cidade, estado, telefone, email, grau_escolaridade, id_psicologo)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getSobrenome());
            stmt.setString(3, paciente.getSexo());
            stmt.setString(4, paciente.getEndereco().getRua());
            stmt.setString(5, paciente.getEndereco().getBairro());
            stmt.setString(6, paciente.getEndereco().getCidade());
            stmt.setString(7, paciente.getEndereco().getEstado());
            stmt.setString(8, paciente.getTelefone());
            stmt.setString(9, paciente.getEmail());
            stmt.setInt(10, paciente.getGrauEscolaridade());
            stmt.setInt(11, paciente.getPsicologo().getId());
            
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:PacienteDAO:cadastrar = " + ex);
        }
        return false;
    }
    
    public List<Paciente> listar(int id, int limite, int offset){
        try {
            List<Paciente> pacientes = new ArrayList<>();
            
            String sql = "SELECT * FROM paciente WHERE id_psicologo = ? ORDER BY nome ASC LIMIT ? OFFSET ?";
            //SELECT id, nome FROM clientes ORDER BY id DESC LIMIT 15 OFFSET ?
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.setInt(2, limite);
            stmt.setInt(3, offset);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSobrenome(rs.getString("sobrenome"));
                paciente.setEndereco(endereco);
                paciente.setSexo(rs.getString("sexo"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setGrauEscolaridade(rs.getInt("grau_escolaridade"));
                pacientes.add(paciente);
            }
            rs.close();
            stmt.close();
            return pacientes;
        } catch (SQLException ex) {
            System.out.println("Erro:PacienteDAO:listar = " + ex);
        }
        return null;
    }
    public Paciente recuperarPaciente(int id){
        try {
            String sql = "SELECT * FROM paciente WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSobrenome(rs.getString("sobrenome"));
                paciente.setEndereco(endereco);
                paciente.setSexo(rs.getString("sexo"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setGrauEscolaridade(rs.getInt("grau_escolaridade"));
                return paciente;
            }
        } catch (SQLException ex) {
            System.out.println("Erro:PacienteDAO:recuperarPaciente = " + ex);
        }
        return null;
    }
    
    public boolean editar(Paciente paciente) {
        try {
            String sql  = "UPDATE paciente SET nome = ?, sobrenome = ?, rua = ?, bairro = ?,"
                    + " cidade = ?, estado = ?, telefone = ? WHERE id = ?";
            PreparedStatement stmt  = this.connection.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getSobrenome());
            stmt.setString(3, paciente.getEndereco().getRua());
            stmt.setString(4, paciente.getEndereco().getBairro());
            stmt.setString(5, paciente.getEndereco().getCidade());
            stmt.setString(6, paciente.getEndereco().getEstado());
            stmt.setString(7, paciente.getTelefone());
            stmt.setInt(8, paciente.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean excluir(int id){
        try {
            String sql = "DELETE FROM paciente WHERE id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:PacienteDAO:excluir = " + ex);
        }
        return false;
    }
    
    public int numPaciente(int id){
        int num = 0;
        try {
            String sql = "SELECT COUNT(*) as numeroPacientes FROM paciente "
                    + "WHERE id_psicologo = ? ";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return num = rs.getInt("numeroPacientes");
            }
            stmt.execute();
            stmt.close();
            return num;
        } catch (SQLException ex) {
            System.out.println("Erro:PacienteDAO:numPaciente = " + ex);
        }
        return num;
    }
    
}
