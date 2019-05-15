/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.model;


/**
 *
 * @author Laelkayo
 */
public class Paciente extends Pessoa {
    
    private Psicologo psicologo;
    private String grauEscolaridade;

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }
    
    
}