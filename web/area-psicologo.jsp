<%@page import="br.edu.fescfafic.meem.model.Psicologo"%>
<jsp:include page="includes/topo.jsp"/>
<% 
    HttpSession sessao = request.getSession();
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
                    <a href="editar-senha-psicologo.jsp"> <img src="imagens/senha.png" width="25" height="25"> Editar senha</a>
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
                <div id="aviso">
                    <p>
                        [ ! ] Olá <b>${psicologo.nome}</b>, seja bem-vindo(a) ao nosso sitema.
                        <br><br>
                        <b>
                            O propósito do nosso trabalho é informatizar o Mini
                            Exame do Estado Mental para que você, psicólogo(a) 
                            possa ter uma melhor gestão dos testes realizados 
                            em seus pacientes...
                            <br><br>
                            [ ! ] Você terá acesso aos seguintes recursos do sistema:
                            <br>
                        </b>
                            => Cadastro de pacientes<br>
                            => Gerenciamento de seus pacientes<br>
                            => Realizar exame com o seus pacientes<br>
                            => Visualizar os resultados do exame de seus paciêntes<br>
                            <br><b>- Aviso do Sistema</b>
                    </p>
                </div>
            </div>
        </center>
                        
    </body>
</html>
<% } %>