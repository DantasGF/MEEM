/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.meem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gutemberg
 */
public class Exame {
    
    private int id;
    private TipoExame tipoExame;
    private Paciente paciente;
    private int pontuacao;
    
    private int q1a;
    private int q1b;
    private int q1c;
    private int q1d;
    private int q1e;
    
    private int q2a;
    private int q2b;
    private int q2c;
    private int q2d;
    private int q2e;
    
    private int q3a;
    private int q3b;
    private int q3c;
    
    private int q4a;
    private int q4b;
    private int q4c;
    private int q4d;
    private int q4e;
    
    private int q5a;
    private int q5b;
    private int q5c;
    
    private int q6a;
    private int q6b;
    
    private int q7a;
    
    private int q8a;
    private int q8b;
    private int q8c;
    
    private int q9a;
    
    private int q10a;
    
    private int q11a;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }
    
    public int getQ1a() {
        return q1a;
    }

    public void setQ1a(int q1a) {
        this.q1a = q1a;
    }

    public int getQ1b() {
        return q1b;
    }

    public void setQ1b(int q1b) {
        this.q1b = q1b;
    }

    public int getQ1c() {
        return q1c;
    }

    public void setQ1c(int q1c) {
        this.q1c = q1c;
    }

    public int getQ1d() {
        return q1d;
    }

    public void setQ1d(int q1d) {
        this.q1d = q1d;
    }

    public int getQ1e() {
        return q1e;
    }

    public void setQ1e(int q1e) {
        this.q1e = q1e;
    }

    public int getQ2a() {
        return q2a;
    }

    public void setQ2a(int q2a) {
        this.q2a = q2a;
    }

    public int getQ2b() {
        return q2b;
    }

    public void setQ2b(int q2b) {
        this.q2b = q2b;
    }

    public int getQ2c() {
        return q2c;
    }

    public void setQ2c(int q2c) {
        this.q2c = q2c;
    }

    public int getQ2d() {
        return q2d;
    }

    public void setQ2d(int q2d) {
        this.q2d = q2d;
    }

    public int getQ2e() {
        return q2e;
    }

    public void setQ2e(int q2e) {
        this.q2e = q2e;
    }

    public int getQ3a() {
        return q3a;
    }

    public void setQ3a(int q3a) {
        this.q3a = q3a;
    }

    public int getQ3b() {
        return q3b;
    }

    public void setQ3b(int q3b) {
        this.q3b = q3b;
    }

    public int getQ3c() {
        return q3c;
    }

    public void setQ3c(int q3c) {
        this.q3c = q3c;
    }

    public int getQ4a() {
        return q4a;
    }

    public void setQ4a(int q4a) {
        this.q4a = q4a;
    }

    public int getQ4b() {
        return q4b;
    }

    public void setQ4b(int q4b) {
        this.q4b = q4b;
    }

    public int getQ4c() {
        return q4c;
    }

    public void setQ4c(int q4c) {
        this.q4c = q4c;
    }

    public int getQ4d() {
        return q4d;
    }

    public void setQ4d(int q4d) {
        this.q4d = q4d;
    }

    public int getQ4e() {
        return q4e;
    }

    public void setQ4e(int q4e) {
        this.q4e = q4e;
    }

    public int getQ5a() {
        return q5a;
    }

    public void setQ5a(int q5a) {
        this.q5a = q5a;
    }

    public int getQ5b() {
        return q5b;
    }

    public void setQ5b(int q5b) {
        this.q5b = q5b;
    }

    public int getQ5c() {
        return q5c;
    }

    public void setQ5c(int q5c) {
        this.q5c = q5c;
    }

    public int getQ6a() {
        return q6a;
    }

    public void setQ6a(int q6a) {
        this.q6a = q6a;
    }

    public int getQ6b() {
        return q6b;
    }

    public void setQ6b(int q6b) {
        this.q6b = q6b;
    }

    public int getQ7a() {
        return q7a;
    }

    public void setQ7a(int q7a) {
        this.q7a = q7a;
    }

    public int getQ8a() {
        return q8a;
    }

    public void setQ8a(int q8a) {
        this.q8a = q8a;
    }

    public int getQ8b() {
        return q8b;
    }

    public void setQ8b(int q8b) {
        this.q8b = q8b;
    }

    public int getQ8c() {
        return q8c;
    }

    public void setQ8c(int q8c) {
        this.q8c = q8c;
    }

    public int getQ9a() {
        return q9a;
    }

    public void setQ9a(int q9a) {
        this.q9a = q9a;
    }

    public int getQ10a() {
        return q10a;
    }

    public void setQ10a(int q10a) {
        this.q10a = q10a;
    }

    public int getQ11a() {
        return q11a;
    }

    public void setQ11a(int q11a) {
        this.q11a = q11a;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
