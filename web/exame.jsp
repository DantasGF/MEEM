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
                    <a href="area-psicologo.jsp"><img src="imagens/home.png" width="25" height="25"> In�cio</a>
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
        
        <center>
            <div id="area_principal">
                <h1>Exame</h1>
                <div id="aviso">
                    <form action="" method="post">
                        <ul>
                            <!--<li>
                                Nome do paciente: <b><%= request.getParameter("nome") %></b>
                            </li><br>

                            <li>
                                Sexo: <b><%= request.getParameter("sexo") %></b>
                            </li><br>

                            <li>
                                Data da avalia��o: <b>dd/mm/aaaa</b> 
                            </li><br>

                            <li>
                                Avaliador(a): <b>${psicologo.nome} ${psicologo.sobrenome}</b>
                            </li><br>-->

                            <li>
                                <h3>
                                    1 - Orienta��o Temporal (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <input type="checkbox">Qual � o dia da semana?<br>
                                <br>
                                    <input type="checkbox">Qual � o dia do m�s?
                                <br>
                                <br>
                                    <input type="checkbox">Qual o m�s atual?
                                <br>
                                <br>
                                    <input type="checkbox">Qual o ano atual?
                                <br>
                                <br>
                                    <input type="checkbox">Hora aproximada?
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    2 - Orienta��o Espacial (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <input type="checkbox">Em qual local estamos?<br>
                                <br>
                                    <input type="checkbox">Em qual institui��o estamos(casa, rua...)?
                                <br>
                                <br>
                                    <input type="checkbox">Em qual bairro estamos?
                                <br>
                                <br>
                                    <input type="checkbox">Estamos em qual cidade?
                                <br>
                                <br>
                                    <input type="checkbox">Estamos em qual estado?
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    3 - Registros (0 - 3 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Mencione tr�s palavras levando um segundo para cada uma.
                                        Pe�a ao paciente para repetir as tr�s palavras que voc� mencionou.
                                        Estabele�a um ponto para cada resposta correta. 
                                    </b>
                                </p>
                                <input type="checkbox">Vaso<br>
                                <br>
                                    <input type="checkbox">Carro
                                <br>
                                <br>
                                    <input type="checkbox">Tijolo
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    4 - Aten��o (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Pedir a o paci�nte para
                                        soletar a palavra MUNDO de tr�s para frente. 
                                    </b>
                                </p>
                                <input type="checkbox">O<br>
                                <br>
                                    <input type="checkbox">D
                                <br>
                                <br>
                                    <input type="checkbox">N
                                <br>
                                <br>
                                    <input type="checkbox">U
                                <br>
                                <br>
                                    <input type="checkbox">M
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    5 - Lembran�as - Mem�ria de Evoca��o (0 - 3 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Pergunte o nome das tr�s palavras mencionadas na quest�o 
                                        <b style="color:red;">3</b>. Estabele�a um ponto para cada resposta.
                                        correta. 
                                    </b>
                                </p>
                                <input type="checkbox">Vaso<br>
                                <br>
                                    <input type="checkbox">Carro
                                <br>
                                <br>
                                    <input type="checkbox">Tijolo
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    6 - Linguagem (0 - 2 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Aponte para um l�pis e um rel�gio.
                                        Fa�a o paciente dizer o nome desses objetos conforme voc� os aponta.
                                    </b>
                                </p>
                                <input type="checkbox">L�pis<br>

                                <br>
                                    <input type="checkbox">Rel�gio
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    7 - Linguagem (0 - 1 ponto)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Fa�a o paciente. Repetir "Nem aqui, nem ali, nem l�"
                                    </b>
                                </p>
                                <input type="checkbox">Nem aqui, nem al�, nem l�<br>
                            </ul>

                            <li>
                                <h3>
                                    8 - Linguagem (0 - 3 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Fa�a o paciente seguir o comando de tr�s est�gios.
                                        "Pegue o papel com a m�o direita. Dobre o papel ao
                                        meio. Coloque o papel na mesa".
                                    </b>
                                </p>
                                <input type="checkbox">Pegar o papel com a m�o direita<br>
                                <br>
                                    <input type="checkbox">Dobrar o papel ao meio
                                <br>
                                <br>
                                    <input type="checkbox">Colocar o papel na mesa
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    9 - Linguagem (0 - 1 ponto)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Fa�a o paciente ler e obedecer ao seguinte: FECHE OS OLHOS. 
                                    </b>
                                </p>
                                <input type="checkbox">Obedeceu ao comando<br>
                            </ul>

                            <li>
                                <h3>
                                    10 - Linguagem (0 - 1 ponto)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Fa�a o paciente escrever uma frase de sua
                                        pr�pria autoria. A frase deve conter um sujeito e um
                                        objeto e fazer sentido.
                                        <b style="color:red;">(Ignore erros de ortografia ao marcar o ponto)</b>
                                    </b>
                                </p>
                                <input type="checkbox">O paciente conseguiu escrever a frase com sucesso<br>
                            </ul>

                            <li>
                                <h3>
                                    11 - Linguagem (0 - 1 ponto)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Copie o desenho abaixo.
                                        Estabele�a um ponto se todos os lados e
                                        �ngulos forem preservados e se os lados da interse��o
                                        formarem um quadril�tero.
                                    </b>
                                <center>
                                    <img src="imagens/11.jpg"/>
                                </center>
                                </p>
                                <input type="checkbox">O paciente realizou a tarefa com sucesso<br>
                            </ul>
                        </ul>
                        <br>
                            <center>
                                <input type="submit" value="Finalizar Exame">
                                <input type="reset" value="Limpar op��es">
                            </center>
                        <br>
                    </form>
                </div>
            </div>
        </center>
</body>
</html>
 <% } %>