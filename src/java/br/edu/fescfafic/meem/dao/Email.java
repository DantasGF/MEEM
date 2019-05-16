package br.edu.fescfafic.meem.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gutemberg
 */
public class Email {
    
    private String smtpHostMail;
    private String smtpPortMail;
    private String smtpAuth;

    public String getSmtpHostMail() {
        return smtpHostMail;
    }

    public void setSmtpHostMail(String smtpHostMail) {
        this.smtpHostMail = smtpHostMail;
    }

    public String getSmtpPortMail() {
        return smtpPortMail;
    }

    public void setSmtpPortMail(String smtpPortMail) {
        this.smtpPortMail = smtpPortMail;
    }

    public String getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(String smtpAuth) {
        this.smtpAuth = smtpAuth;
    }
    
}
