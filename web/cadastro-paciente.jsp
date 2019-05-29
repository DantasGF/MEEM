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
    
    <form action="./CadastraPacienteController" method="POST">
        <div id="area_principal">
            <center>
                <div id="caixa-login">
                    
                    <div id="caixa-login-titulo">Cadastro de Paciente</div><br>
                    
                <br><table border="0">
                        <tr>
                            <td>
                                <input required="true" autofocus="true" id="campo-login" name="nome" placeholder="Nome">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="sobrenome" placeholder="Sobrenome">
                            </td>
                        </tr>
                        
                        <tr>
                            <td><br>
                                <center>
                                    <input required="true" class="campo-login" name="sexo" value="M" type="radio">Masculino
                                    <input class="campo-login" name="sexo" value="F" type="radio">Feminino
                                </center>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="rua" placeholder="Rua">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="bairro" placeholder="Bairro">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="cidade" placeholder="Cidade">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                    <select required="true" style="width: 370px;" id="campo-login" name="estado">
                                        <option value="">Selecione um estado...</option>
                                        <option value="AC">Acre</option>
                                        <option value="AL">Alagoas</option>
                                        <option value="AP">Amapá</option>
                                        <option value="AM">Amazonas</option>
                                        <option value="BH">Bahia</option>
                                        <option value="CE">Ceará</option>
                                        <option value="DF">Distrito Federal</option>
                                        <option value="ES">Espirito Santo</option>
                                        <option value="GO">Goiás</option>
                                        <option value="MA">Maranhão</option>
                                        <option value="MT">Mato Grosso</option>
                                        <option value="MS">Mato Grosso do Sul</option>
                                        <option value="MG">Minas Gerais</option>
                                        <option value="PA">Pará</option>
                                        <option value="PB">Paraíba</option>
                                        <option value="PR">Paraná</option>
                                        <option value="PE">Pernanbuco</option>
                                        <option value="PI">Piauí</option>
                                        <option value="RJ">Rio de Janeiro</option>
                                        <option value="RN">Rio Grande do Norte</option>
                                        <option value="RS">Rio Grande do Sul</option>
                                        <option value="RO">Rondônia</option>
                                        <option value="RR">Roraima</option>
                                        <option value="SC">Santa Catarina</option>
                                        <option value="SP">São Paulo</option>
                                        <option value="SE">Sergipe</option>
                                        <option value="TO">Tocantins</option>
                                </center>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                    <select required="true" style="width: 370px;" id="campo-login" name="grauEscolaridade">
                                        <option value="">Grau de escolaridade...</option>
                                        <option value="0">Analfabeto</option>
                                        <option value="1">1 à 3 anos de estudo</option>
                                        <option value="2">4 à 8+ anos de estudo</option>
                                    </select>
                                </center>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="dataNascimento" type="date">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="email" placeholder="Email">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input required="true" id="campo-login" name="telefone" placeholder="Telefone. Ex. (00) 0 0000-0000">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <center>
                                    <input class="botao-login" type="submit" value="Cadastrar">
                                </center>
                            </td>
                        </tr>
                    </table><br>
                </div>
            </center>
        </div>
    </form><br>
    
</body>
</html>
    <% } %>