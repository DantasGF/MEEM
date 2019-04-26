<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/topo.jsp"/>

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
                <div id="aviso">
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
                                    <a href="./EditarPacienteController?id=${paciente.id}"><img width="30" height="30" src="imagens/editar-paciente.png"/></a>
                                    | <a href="./ExcluirPacienteController?id=${paciente.id}"><img width="30" height="30" src="imagens/remover-paciente.png"/></a> 
                                    | <a href="#"><img width="30" height="30" src="imagens/exame.png"/></a>
                                </td>
                                
                            </tr>
                            </c:forEach>
                            
                        </table>
                    </center>
                    
                </div>
                
            </div>
        </center>
    </body>
</html>
