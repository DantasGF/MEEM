<jsp:include page="includes/topo.jsp"/>
    <div id="barra_horizontal_topo">
        <img id="logo_psicologia" src="imagens/psicologia_icone.png" width="40" height="40"/>
        <h3>Mini Exame do Estado Mental</h3>
    </div>
    <form action="./CadastraPsicologoController" method="POST">
        <center><div id="caixa-login">
                <div id="caixa-login-titulo">Cadastro de Psicólogo</div><br>
            <br><table border="0">
                <tr>
                    <td><input id="campo-login" name="nome" placeholder="Nome"></td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="sobrenome" placeholder="Sobrenome"></td>
                </tr>
                <tr>
                    <td><br><center><input class="campo-login" name="sexo" value="M" type="radio">Masculino
                    <input class="campo-login" name="sexo" value="F" type="radio">Feminino</center>
                    </td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="rua" placeholder="Rua"></td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="bairro" placeholder="Bairro"></td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="cidade" placeholder="Cidade"></td>
                </tr>
                <tr>
                    <td><center>
                        <select id="campo-login" name="estado">
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
                        </select></center>
                    </td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="email" placeholder="Email"></td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="usuario" placeholder="Usuário"></td>
                </tr>
                <tr>
                    <td><input id="campo-login" name="senha" placeholder="Senha" type="password"></td>
                </tr>
                <tr>
                    <td><center><input class="botao-login" type="submit" value="Cadastrar"></center></td>
                </tr>
            </table><br>
            </div></center>
        </form><br>
    </body>
</html>
