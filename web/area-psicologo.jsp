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
                <a href="editar-senha-psicologo.jsp"> <img src="imagens/senha2.png" width="25" height="25"> Editar Senha</a>
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
            <h1>�rea do Psic�logo</h1>
            <center>
            <div id="dashboard">
                <div id="info-dash">
                    N�mero de pacientes<br>
                    <center>
                        <h2>${quantidadePaciente} Pacientes</h2>
                    </center>
                </div>
                <div id="info-dash">
                   Total de exames realizados<br>
                    <center>
                        <h2>${quantidadeExames} Exames</h2>
                    </center>
                </div>
                <div id="info-dash">
                    M�dia das pontua��es<br>
                    <center>
                        <h2>${mediaPontuacaoExames} Pontos</h2>
                    </center>
                </div>
            </div>
            </center>
            <div id="aviso">
                <p>
                    Ol� <b>${psicologo.nome}</b>, seja bem-vindo(a) ao nosso sitema.
                    <br><br>
                    <b>
                        O prop�sito do nosso trabalho � informatizar o Mini
                        Exame do Estado Mental para que voc�, psic�logo(a) 
                        possa ter uma melhor experi�ncia e praticidade ao realizar os testes 
                        em seus pacientes.
                        <br><br>
                        [ ! ] Voc� ter� acesso aos seguintes recursos do sistema:
                        <br>
                    </b>
                        <br>
                            - Cadastro de pacientes
                        <br>
                        <br>
                            - Gerenciamento de seus pacientes(editar, remover e realizar exame)
                        <br>
                        <br>
                            - Visualizar os resultados do exame de seus paci�ntes
                        <br>
                        <br>
                            - Gerar relat�rio dos testes do seus pacientes
                        <br>
                        <br><b>- Aviso do Sistema</b>
                </p>
            </div>
        </div>
    </center>

</body>
</html>
    <% } %>