<%@page import="br.edu.fescfafic.meem.model.Psicologo"%>
<jsp:include page="includes/topo.jsp"/>
    <% 
        Psicologo psicologo = (Psicologo) session.getAttribute("psicologo");

        if(psicologo == null){
            response.sendRedirect("./index.jsp");
        }
        else{
    %>
        <div id="barra_lateral_esquerda">
            <ul>
                <li>
                    <a href="area-psicologo.jsp"><img src="imagens/home.png" width="25" height="25"> Início</a>
                </li>
            </ul>
            
            <ul>
                <li>
                    <a href="./ListarPacientesController"><img src="imagens/usuarios.png" width="25" height="25"> Meus Pacientes</a>
                </li>
            </ul>
            
            <ul>
                <li>
                    <a href="sair.jsp"><img src="imagens/logout.png" width="25" height="25"> Sair</a>
                </li>
            </ul>
        </div>
        
        <center>
            <div id="area_principal">
                <h1>Exame</h1>
                <div id="aviso">
                    <ul>
                        <li>
                            Nome do paciente: <b><%= request.getParameter("nome") %></b>
                        </li><br>
                        
                        <li>
                            Sexo: <b><%= request.getParameter("sexo") %></b>
                        </li><br>
                        
                        <li>
                            Data da avaliação: <b>dd/mm/aaaa</b> 
                        </li><br>
                        
                        <li>
                            Avaliador(a): <b>${psicologo.nome} ${psicologo.sobrenome}</b>
                        </li><br>
                        
                        <li>
                            <h3>Orientação Temporal Espacial</h3>
                        </li>
                        <ul>
                            <li>
                                <h4>Tempo<h4>
                            </li>
                            <ul>
                                <li>
                                    Qual é o dia da semana?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Qual é o dia do mês?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Em que mês estamos?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Em que ano estamos?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                            </ul>
                            
                            <li>
                                <h4>Espaço<h4>
                            </li>
                            <ul>
                                <li>
                                    Em qual local estamos?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Qual instituição estamos(casa, rua)?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Em qual bairro estamos?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Em que cidade estamos?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                                
                                <li>
                                    Estamos em qual estado?
                                </li>
                                
                                <li>
                                    <input name="" type="checkbox"> Acertou<br>
                                    <input name="" type="checkbox"> Errou
                                </li><br>
                            </ul>
                        </ul>
                    </ul>
                </div>
            </div>
        </center>
</body>
</html>
 <% } %>