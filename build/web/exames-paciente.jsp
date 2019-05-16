<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="cadastro-paciente.jsp"> <img src="imagens/usuario2.png" width="25" height="25"> Cadastro Paciente</a>
            </li>
        </ul>

        <ul>
            <li>
                <a href="./ListarPacientesController"> <img src="imagens/usuarios.png" width="25" height="25"> Meus Pacientes</a>
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
            <h1>Exames do Paciente</h1>
            <div id="aviso">
                <p>
                    Nome: <b>${paciente.nome} ${paciente.sobrenome}</b> - <a href="exame.jsp?pid=${paciente.id}">Novo Exame</a><br>
                    <br>Sexo: <b>${paciente.sexo}</b><br>
                    <br>Telefone: <b>${paciente.telefone}</b><br>
                    <br>Endereço: <b>Rua, ${paciente.endereco.rua},
                        ${paciente.endereco.bairro}, ${paciente.endereco.cidade} - ${paciente.endereco.estado}</b><br>
                <p><br>
                <center>
                    <h2>Exames</h2>
                    <table id="tabela" border="0">
                        <tr id="tr-tabela">
                            <td id="td-tabela">Tipo do Exame</td>
                            <td id="td-tabela">Pontuação</td>
                            <td id="td-tabela">Avaliação</td>
                            <td id="td-tabela">Escore médio para depressão</td>
                            <td id="td-tabela">Ações</td>
                        </tr>

                        <tr id="tr-tabela">
                            <c:forEach items="${exame}" var="exame">
                            <td id="td-tabela">
                                ${exame.tipoExame.tipo}
                            </td>

                            <td id="td-tabela">
                                <center>
                                    ${exame.pontuacao}
                                </center>
                            </td>
                            
                            <td id="td-tabela">
                                <center>
                                    <c:if test="${exame.pontuacao > 27}">
                                        Normal
                                    </c:if>
                                    <c:if test="${exame.pontuacao <= 27}">
                                        Demência
                                    </c:if>
                                </center>
                            </td>
                            
                            <td id="td-tabela">
                                <center>
                                    <c:choose>
                                        <c:when test="${(exame.pontuacao >= 19) and (exame.pontuacao < 25)}">
                                            Depressão não-complicada
                                        </c:when>
                                        <c:when test="${exame.pontuacao < 19}">
                                            Prejuízo cognitivo por depressão
                                        </c:when>
                                        <c:when test="${exame.pontuacao > 27}">
                                            Normal
                                        </c:when>
                                        <c:otherwise>
                                            Normal
                                        </c:otherwise>
                                    </c:choose>
                                </center>
                            </td>

                            <td id="td-tabela">
                                <center>
                                    <a target="_blank" href="./GerarRelatorioController?pid=${paciente.id}&eid=${exame.id}">
                                        <img title="Baixar PDF" width="30" height="30" src="imagens/pdf.png"/></a>
                                </center>
                            </td>
                        </tr>
                        </c:forEach>
                    </table><br>
                </center>
            </div>
        </div>
    </center>

</body>
</html>
    <% } %>