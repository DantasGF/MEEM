<jsp:include page="includes/topo.jsp"/>
    <form action="./LoginPsicologoController" method="post"><br><br><br><br><br>
        <center>
            <div id="caixa-login">

                <div id="caixa-login-titulo">
                    <img src="imagens/chave.png" width="20" height="20"/> Faça seu login</div><br>
                <br>

                <table border="0">
                    <tr>
                        <td>
                            <img src="imagens/usuario.png" width="20" height="20"/>
                            <input required="true" autocomplete="on" id="campo-login" name="usuario" placeholder="Usuário">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <img src="imagens/senha.png" width="20" height="20"/> 
                            <input required="true" autocomplete="on" id="campo-login" name="senha" placeholder="Senha" type="password">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <center>
                                <input class="botao-login" type="submit" name="login" value="Login">
                            </center>
                        </td>
                    </tr>

                </table><br>

                <div id="aviso-caixa-login">
                    Não possui cadastro? Cadastre-se <a href="cadastro-psicologo.jsp"><b>aqui!</b></a>
                </div><br>

            </div>
        </center>           

    </form>
</body>
</html>
