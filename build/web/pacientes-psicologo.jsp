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
                    <a href="cadastro-paciente.jsp"><img src="imagens/usuario2.png" width="25" height="25"> Cadastro Paciente</a>
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
                <h1>Meus Pacientes</h1>
                <div id="aviso"><br>
                    <center>
                        <table id="tabela" border="0">
                            <tr id="tr-tabela">
                                <td id="td-tabela">Nome</td>
                                <td id="td-tabela">Sexo</td>
                                <td id="td-tabela">Endereço</td>
                                <td id="td-tabela">Telefone</td>
                                <td id="td-tabela">Ações</td>
                            </tr>
                            
                            <tr id="tr-tabela">
                            <c:forEach items="${pacientes}" var="paciente">
                                
                                <td id="td-tabela">${paciente.nome} ${paciente.sobrenome}</td>
                            
                                <td id="td-tabela"><center>${paciente.sexo}</center></td>
                                
                                <td id="td-tabela">R. ${paciente.endereco.rua}, 
                                    Bairro ${paciente.endereco.bairro},
                                    ${paciente.endereco.cidade} - ${paciente.endereco.estado}
                                </td>
                                
                                <td id="td-tabela">${paciente.telefone}</td>
                                
                                <td id="td-tabela">
                                    <a href="./EditarPacienteController?id=${paciente.id}"><img title="Editar Paciente" width="30" height="30" src="imagens/editar-paciente.png"/></a>
                                    | <a href="./ExcluirPacienteController?id=${paciente.id}"><img title="Remover Paciente" width="30" height="30" src="imagens/remover-paciente.png"/></a> 
                                    | <a href="./RecuperarPacienteController?id=${paciente.id}"><img title="Gerenciar exames do paciente" width="30" height="30" src="imagens/exame.png"/></a>
                                </td>
                                
                            </tr>
                            </c:forEach>
                            
                        </table>

                    <br>  
                    
                    <%
                        int totalPagina = (int)request.getSession().getAttribute("totalPagina");
                        for (int i = 1; i <= totalPagina; i++) {
                                out.println("<a id=\"botao-paginacao\" href=./ListarPacientesController?paginacao=" + i + ">" + i + "</a>");
                        }
                    %>
                    <br><br>
                    </center>
                </div>
                
            </div>
        </center>
</body>
</html>
 <% } %>