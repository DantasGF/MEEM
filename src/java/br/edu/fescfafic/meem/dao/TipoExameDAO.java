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
import java.util.List;

/**
 *
 * @author Gutemberg
 */
public class TipoExameDAO {
    
    private Connection connection;
    
    public TipoExameDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean inserir(TipoExame tipoExame){
        return false;
    
    }
    
    public TipoExame recuperar(int id){
        return null;
    
    }
    
    public List<TipoExame> listar(){
        return null;
    
    }
    
    public boolean editar(TipoExame tipoExame){
        return false;
    
    }
    
    public boolean excluir(int id){
        return false;
        
    }
}
