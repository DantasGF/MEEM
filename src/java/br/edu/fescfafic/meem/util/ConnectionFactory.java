/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gutemberg
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost/meem";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro:ConnectionFactory:getConnection = " + ex);
        }
        return null;
    }
}
