<jsp:include page="includes/topo.jsp"/>
    <center>
        <h1>Cadastro de Psicologo</h1>
        <form action="./CadastraPsicologoController" method="POST">
            Nome<br>
            <input name="nome"><br>
            Sobrenome<br>
            <input name="sobrenome"><br>
            Rua<br>
            <input name="rua"><br>
            Bairro<br>
            <input name="bairro"><br>
            Cidade<br>
            <input name="cidade"><br>
            Estado<br>
            <input name="estado"><br>
            Usuário<br>
            <input name="usuario"><br>
            Senha<br>
            <input name="senha" type="password"><br>
            <br><input name="enviar" type="submit" value="Cadastrar">
        </form>
    </center>
    </body>
</html>
