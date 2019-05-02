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
                    <a href="sair.jsp"><img src="imagens/logout.png" width="25" height="25"> Sair</a>
                </li>
            </ul>
            
        </div>
        
       <form action="./EditarSenhaPsicologoController" method="POST">
        <div id="area_principal">
            <center>
                <div id="caixa-login">
                    <div id="caixa-login-titulo">Alterar Senha Psicologo</div><br>
                <br>
                
                <table border="0">
                    <input name="id" value="${psicologo.id}" type="hidden">
                    
                    <tr>
                        <td>
                            <input required="true" id="campo-login" name="senhaAntiga" placeholder="Senha atual" type="password">
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <input required="true" id="campo-login" name="senhaNova1" placeholder="Nova senha" type="password">
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <td>
                            <input required="true" id="campo-login" name="senhaNova2" placeholder="Repita a nova senha" type="password">
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <center>
                                <input class="botao-login" type="submit" value="Alterar">
                            </center>
                        </td>
                    </tr>
                    
                </table><br>
                
                </div>
            </center>
        </div>
    </form>
                        
</body>
</html>
    <% } %>
