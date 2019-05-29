package br.edu.fescfafic.meem.control;

import br.edu.fescfafic.meem.dao.ExameDAO;
import br.edu.fescfafic.meem.dao.PacienteDAO;
import br.edu.fescfafic.meem.model.Exame;
import br.edu.fescfafic.meem.model.Paciente;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

/**
 *
 * @author Gutemberg
 */
public class GerarRelatorioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idPaciente = Integer.parseInt(request.getParameter("pid"));
            int idExame = Integer.parseInt(request.getParameter("eid"));
            
            PacienteDAO pacienteDAO = new PacienteDAO();
            Paciente paciente = pacienteDAO.recuperarPaciente(idPaciente);
            
            ExameDAO exameDAO = new ExameDAO();
            Exame exame = exameDAO.recuperarPorExame(idExame);
            
            Document documento = new Document();
            documento.setPageSize(PageSize.A4);
            response.setHeader("Content-disposition", "filename=Relatório"+ paciente.getNome() +".pdf");
            PdfWriter.getInstance(documento, response.getOutputStream());
            
            documento.open();
            
            Paragraph paragrafo = new Paragraph();
            paragrafo.add("Nome do paciente: " + paciente.getNome() + " " + paciente.getSobrenome() + "\n");
            
            if(paciente.getSexo().equalsIgnoreCase("M")){
                paragrafo.add("Sexo: Masculino\n");
            }else if(paciente.getSexo().equalsIgnoreCase("F")){
                paragrafo.add("Sexo: Feminino\n");
            }
            paragrafo.add("Endereço: Rua, " + paciente.getEndereco().getRua() 
                    + ", " + paciente.getEndereco().getBairro() 
                    + ", " + paciente.getEndereco().getCidade() 
                    + " - " + paciente.getEndereco().getEstado()+"\n");
            paragrafo.add("Telefone: " + paciente.getTelefone() + "\n");
            
            if(paciente.getGrauEscolaridade() == 0){
                paragrafo.add("Grau de escolaridade: Analfabeto\n\n");
            }
            else if(paciente.getGrauEscolaridade() == 1){
                paragrafo.add("Grau de escolaridade: 1 à 3 anos de estudo\n\n");
            }
            else if(paciente.getGrauEscolaridade() == 2){
                paragrafo.add("Grau de escolaridade: 4 à 8+ anos de estudo\n\n");
            }
            
            paragrafo.add("Pontuação do Exame: " + exame.getPontuacao()+"\n");
            
            if(exame.getPontuacao() > 27 && exame.getPontuacao() <= 30){
                paragrafo.add("Avaliação: Normal\n");
            }
            else if(paciente.getGrauEscolaridade() == 1 && exame.getPontuacao() >= 0 && exame.getPontuacao() <= 17){
                paragrafo.add("Avaliação: Demência\n");
            }
            else if(paciente.getGrauEscolaridade() == 0 && exame.getPontuacao() >= 0 && exame.getPontuacao() <= 17){
                paragrafo.add("Avaliação: Demência\n");
            }
            else if(paciente.getGrauEscolaridade() == 1 && exame.getPontuacao() > 17){
                paragrafo.add("Avaliação: Normal\n");
            }
            else if(paciente.getGrauEscolaridade() == 0 && exame.getPontuacao() > 17){
                paragrafo.add("Avaliação: Normal\n");
            }
            else if(paciente.getGrauEscolaridade() == 2 && exame.getPontuacao() >= 17 && exame.getPontuacao() <= 24 ){
                paragrafo.add("Avaliação: Demência\n");
            }
            else{
                paragrafo.add("Avaliação: Demência\n");
            }
            
            if(exame.getPontuacao() >= 19 && exame.getPontuacao() <= 27){
                paragrafo.add("Escore médio para depressão: Depressão não-complicada\n\n");
            }
            else if(exame.getPontuacao() < 19){
                paragrafo.add("Escore médio para depressão: Prejuízo cognitivo por depressão\n\n");
            }
            else if(exame.getPontuacao() > 27){
                paragrafo.add("Escore médio para depressão: Normal\n\n");
            }
            else{
                paragrafo.add("Escore médio para depressão: Normal\n\n");
            }
            documento.add(paragrafo);
            
            Paragraph titulo = new Paragraph();
            titulo.add("\nQuestões do exame\n\n");
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            
            Paragraph questoes = new Paragraph();
            
            //Image acerto = Image.getInstance("C:\\Users\\Gutemberg\\Documents\\ProjetosGithub\\MEEM\\web\\imagens/acerto.png");
            //acerto.scaleToFit(40, 40);
            
            questoes.add("1 - Orientação Temporal (0 - 5 pontos)\n");
            if(exame.getQ1a() == 1){
                questoes.add("     Qual é o dia da semana? - ACERTOU\n");
            }else{
                questoes.add("     Qual é o dia da semana? - ERROU\n");
            }
            
            if(exame.getQ1b() == 1){
                questoes.add("     Qual é o dia do mês? - ACERTOU\n");
            }else{
                questoes.add("     Qual é o dia do mês? - ERROU\n");
            }
            
            if(exame.getQ1c() == 1){
                questoes.add("     Qual o mês atual? - ACERTOU\n");
            }else{
                questoes.add("     Qual o mês atual? - ERROU\n");
            }
            
            if(exame.getQ1d() == 1){
                questoes.add("     Qual o ano atual? - ACERTOU\n");
            }else{
                questoes.add("     Qual o ano atual? - ERROU\n");
            }
            
            if(exame.getQ1e() == 1){
                questoes.add("     Hora aproximada? - ACERTOU\n\n");
            }else{
                questoes.add("     Hora aproximada? - ERROU\n\n");
            }
            
            questoes.add("2 - Orientação Espacial (0 - 5 pontos)\n");
            if(exame.getQ2a() == 1){
                questoes.add("     Em qual local estamos? - ACERTOU\n");
            }else{
                questoes.add("     Em qual local estamos? - ERROU\n");
            }
            
            if(exame.getQ2b() == 1){
                questoes.add("     Em qual instituição estamos(casa, rua...)? - ACERTOU\n");
            }else{
                questoes.add("     Em qual instituição estamos(casa, rua...)? - ERROU\n");
            }
            
            if(exame.getQ2c() == 1){
                questoes.add("     Em qual bairro estamos? - ACERTOU\n");
            }else{
                questoes.add("     Em qual bairro estamos? - ERROU\n");
            }
            
            if(exame.getQ2d() == 1){
                questoes.add("     Estamos em qual cidade? - ACERTOU\n");
            }else{
                questoes.add("     Estamos em qual cidade? - ERROU\n");
            }
            
            if(exame.getQ2e() == 1){
                questoes.add("     Estamos em qual estado? - ACERTOU\n\n");
            }else{
                questoes.add("     Estamos em qual estado? - ERROU\n\n");
            }
            
            questoes.add("3 - Registros (0 - 3 pontos)\n");
            if(exame.getQ3a() == 1){
                questoes.add("     Vaso - ACERTOU\n");
            }else{
                questoes.add("     Vaso - ERROU\n");
            }
            
            if(exame.getQ3b() == 1){
                questoes.add("     Carro - ACERTOU\n");
            }else{
                questoes.add("     Carro - ERROU\n");
            }
            
            if(exame.getQ3c() == 1){
                questoes.add("     Tijolo - ACERTOU\n\n");
            }else{
                questoes.add("     Tijolo - ERROU\n\n");
            }
            
            questoes.add("4 - Atenção (0 - 5 pontos)\n");
            if(exame.getQ4a() == 1){
                questoes.add("     O - ACERTOU\n");
            }else{
                questoes.add("     O - ERROU\n");
            }
            
            if(exame.getQ4b() == 1){
                questoes.add("     D - ACERTOU\n");
            }else{
                questoes.add("     D - ERROU\n");
            }
            
            if(exame.getQ4c() == 1){
                questoes.add("     N - ACERTOU\n");
            }else{
                questoes.add("     N - ERROU\n");
            }
            
            if(exame.getQ4d() == 1){
                questoes.add("     U - ACERTOU\n");
            }else{
                questoes.add("     U - ERROU\n");
            }
            
            if(exame.getQ4e() == 1){
                questoes.add("     M - ACERTOU\n\n");
            }else{
                questoes.add("     M - ERROU\n\n");
            }
            
            
            questoes.add("5 - Lembranças - Memória de Evocação (0 - 3 pontos)\n");
            if(exame.getQ5a() == 1){
                questoes.add("     Vaso - ACERTOU\n");
            }else{
                questoes.add("     Vaso - ERROU\n");
            }
            
            if(exame.getQ5b() == 1){
                questoes.add("     Carro - ACERTOU\n");
            }else{
                questoes.add("     Carro - ERROU\n");
            }
            
            if(exame.getQ5c() == 1){
                questoes.add("     Tijolo - ACERTOU\n\n");
            }else{
                questoes.add("     Tijolo - ERROU\n\n");
            }
            
            
            questoes.add("6 - Linguagem (0 - 2 pontos)\n");
            if(exame.getQ6a() == 1){
                questoes.add("     Lápis - ACERTOU\n");
            }else{
                questoes.add("     Lápis - ERROU\n");
            }
            
            if(exame.getQ6b() == 1){
                questoes.add("     Relógio - ACERTOU\n\n");
            }else{
                questoes.add("     Relógio - ERROU\n\n");
            }
            
            
            questoes.add("7 - Linguagem (0 - 1 ponto)\n");
            if(exame.getQ7a() == 1){
                questoes.add("     Nem aqui, nem alí, nem lá - ACERTOU\n\n");
            }else{
                questoes.add("     Nem aqui, nem alí, nem lá - ERROU\n\n");
            }
            
            
            questoes.add("8 - Linguagem (0 - 3 pontos)\n");
            if(exame.getQ8a() == 1){
                questoes.add("     Pegar o papel com a mão direita - ACERTOU\n");
            }else{
                questoes.add("     Pegar o papel com a mão direita - ERROU\n");
            }
            if(exame.getQ8b() == 1){
                questoes.add("     Dobrar o papel ao meio - ACERTOU\n");
            }else{
                questoes.add("     Dobrar o papel ao meio - ERROU\n");
            }
            
            if(exame.getQ8c() == 1){
                questoes.add("     Colocar o papel na mesa - ACERTOU\n\n");
            }else{
                questoes.add("     Colocar o papel na mesa - ERROU\n\n");
            }
            
            
            questoes.add("9 - Linguagem (0 - 1 ponto)\n");
            if(exame.getQ9a() == 1){
                questoes.add("     Obedeceu o comando de Fechar os Olhos? - SIM\n\n");
            }else{
                questoes.add("     Obedeceu o comando de Fechar os Olhos? - NÃO\n\n");
            }
            
            
            questoes.add("10 - Linguagem (0 - 1 ponto)\n");
            if(exame.getQ10a() == 1){
                questoes.add("     O paciente conseguiu escrever a frase com sucesso? - SIM\n\n");
            }else{
                questoes.add("     O paciente conseguiu escrever a frase com sucesso? - NÃO\n\n");
            }
            
            
            questoes.add("11 - Linguagem (0 - 1 ponto)\n");
            if(exame.getQ11a() == 1){
                questoes.add("     O paciente realizou a tarefa com sucesso? - SIM\n\n");
            }else{
                questoes.add("     O paciente realizou a tarefa com sucesso? - NÃO\n\n");
            }
            documento.add(questoes);
            documento.close();
            
            request.getRequestDispatcher("./area-psicologo.jsp").forward(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(GerarRelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
