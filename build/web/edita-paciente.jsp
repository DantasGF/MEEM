<jsp:include page="includes/topo.jsp"/>
    <div id="barra_lateral_esquerda">
            <ul>
                <li><a href="cadastro-paciente.jsp"><img src="imagens/usuario2.png"
                                    width="25" height="25"> Cadastro Paciente</a></li>
            </ul>
            <ul>
                <li><a href="./ListarPacientesController"><img src="imagens/usuarios.png"
                                    width="25" height="25"> Meus Pacientes</a></li>
            </ul>
            <ul>
                <li><a href="sair.jsp"><img src="imagens/logout.png"
                                    width="25" height="25"> Sair</a></li>
            </ul>
        </div>
        <form action="./EditarPacienteController" method="POST">
        <div id="area_principal">
            <center><div id="caixa-login">
                    <div id="caixa-login-titulo">Editar Paciente</div><br>
                <br><table border="0">
                    <input name="id" value="${paciente.id}" hidden>
                    <tr>
                        <td><input required="true" autofocus="true" id="campo-login" name="nome" 
                                   placeholder="Nome" value="${paciente.nome}"></td>
                    </tr>
                    <tr>
                        <td><input required="true" id="campo-login" name="sobrenome"
                                   placeholder="Sobrenome" value="${paciente.sobrenome}"></td>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                        <td><input required="true" id="campo-login" name="rua" 
                                   placeholder="Rua" value="${paciente.endereco.rua}"></td>
                    </tr>
                    <tr>
                        <td><input required="true" id="campo-login" name="bairro" placeholder="Bairro" value="${paciente.endereco.bairro}"></td>
                    </tr>
                    <tr>
                        <td><input required="true" id="campo-login" name="cidade" placeholder="Cidade" value="${paciente.endereco.cidade}"></td>
                    </tr>
                    <tr>
                        <td><center>
                            <select required="true" id="campo-login" name="estado">
                                <option value="AC">Acre</option>
                                <option value="AL">Alagoas</option>
                                <option value="AP">Amap�</option>
                                <option value="AM">Amazonas</option>
                                <option value="BH">Bahia</option>
                                <option value="CE">Cear�</option>
                                <option value="DF">Distrito Federal</option>
                                <option value="ES">Espirito Santo</option>
                                <option value="GO">Goi�s</option>
                                <option value="MA">Maranh�o</option>
                                <option value="MT">Mato Grosso</option>
                                <option value="MS">Mato Grosso do Sul</option>
                                <option value="MG">Minas Gerais</option>
                                <option value="PA">Par�</option>
                                <option value="PB">Para�ba</option>
                                <option value="PR">Paran�</option>
                                <option value="PE">Pernanbuco</option>
                                <option value="PI">Piau�</option>
                                <option value="RJ">Rio de Janeiro</option>
                                <option value="RN">Rio Grande do Norte</option>
                                <option value="RS">Rio Grande do Sul</option>
                                <option value="RO">Rond�nia</option>
                                <option value="RR">Roraima</option>
                                <option value="SC">Santa Catarina</option>
                                <option value="SP">S�o Paulo</option>
                                <option value="SE">Sergipe</option>
                                <option value="TO">Tocantins</option>
                            </select></center>
                        </td>
                    </tr>
                    <tr>
                        <td><input required="true" id="campo-login" name="telefone" 
                                   placeholder="(XX) X XXXX-XXXX" value="${paciente.telefone}"></td>
                    </tr>
                    <tr>
                        <td><center><input class="botao-login" type="submit" value="Editar"></center></td>
                    </tr>
                </table><br>
                </div></center>
            </div>
        </form><br>
    </body>
</html>
