<jsp:include page="includes/topo.jsp"/>
    <form action="./CadastraPsicologoController" method="POST"><br><br><br>
        <div id="barra_lateral_esquerda" style="margin-top: -55px;">
        <ul>
            <li>
                <a href="index.jsp"> <img src="imagens/home.png" width="25" height="25"> Voltar</a>
            </li>
        </ul>

    </div>
            <div id="area_principal">
            <center><div id="caixa-login">
                <div id="caixa-login-titulo">Cadastro de Psic�logo</div><br><br>
                <table border="0">
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
                            <center>
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
                                </select>
                            </center>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <input required="true" id="campo-login" name="email" placeholder="Email">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <input required="true" id="campo-login" name="usuario" placeholder="Usu�rio">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <input required="true" id="campo-login" name="senha" placeholder="Senha" type="password">
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
