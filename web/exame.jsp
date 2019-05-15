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
                    <form action="./CadastrarExameController" method="post">
                        <input name="pid" value="<%= request.getParameter("pid") %>" hidden>
                        <ul>
                            <li>
                                <h3>
                                    1 - Orienta��o Temporal (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <input name="q1a" value="1" type="checkbox">Qual � o dia da semana?<br>
                                <br>
                                    <input name="q1b" value="1" type="checkbox">Qual � o dia do m�s?
                                <br>
                                <br>
                                    <input name="q1c" value="1" type="checkbox">Qual o m�s atual?
                                <br>
                                <br>
                                    <input name="q1d" value="1" type="checkbox">Qual o ano atual?
                                <br>
                                <br>
                                    <input name="q1e" value="1" type="checkbox">Hora aproximada?
                                <br>
                            </ul>

                            <li>
                                <h3>
                                    2 - Orienta��o Espacial (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <input name="q2a" value="1"  type="checkbox">Em qual local estamos?<br>
                                <br>
                                    <input name="q2b" value="1"  type="checkbox">Em qual institui��o estamos(casa, rua...)?
                                <br>
                                <br>
                                    <input name="q2c" value="1"  type="checkbox">Em qual bairro estamos?
                                <br>
                                <br>
                                    <input name="q2d" value="1"  type="checkbox">Estamos em qual cidade?
                                <br>
                                <br>
                                    <input name="q2e" value="1"  type="checkbox">Estamos em qual estado?
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
                                <input name="q3a" value="1"  type="checkbox">Vaso<br>
                                <br>
                                    <input name="q3b" value="1"  type="checkbox">Carro
                                <br>
                                <br>
                                    <input name="q3c" value="1"  type="checkbox">Tijolo
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
                                <input name="q4a" value="1"  type="checkbox">O<br>
                                <br>
                                    <input name="q4b" value="1"  type="checkbox">D
                                <br>
                                <br>
                                    <input name="q4c" value="1"  type="checkbox">N
                                <br>
                                <br>
                                    <input name="q4d" value="1"  type="checkbox">U
                                <br>
                                <br>
                                    <input name="q4e" value="1"  type="checkbox">M
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
                                <input name="q5a" value="1"  type="checkbox">Vaso<br>
                                <br>
                                    <input name="q5b" value="1"  type="checkbox">Carro
                                <br>
                                <br>
                                    <input name="q5c" value="1"  type="checkbox">Tijolo
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
                                <input name="q6a" value="1"  type="checkbox">L�pis<br>

                                <br>
                                    <input name="q6b" value="1"  type="checkbox">Rel�gio
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
                                <input name="q7a" value="1"  type="checkbox">Nem aqui, nem al�, nem l�<br>
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
                                <input name="q8a" value="1"  type="checkbox">Pegar o papel com a m�o direita<br>
                                <br>
                                    <input name="q8b" value="1"  type="checkbox">Dobrar o papel ao meio
                                <br>
                                <br>
                                    <input name="q8c" value="1"  type="checkbox">Colocar o papel na mesa
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
                                <input name="q9a" value="1"  type="checkbox">Obedeceu ao comando<br>
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
                                <input name="q10a" value="1"  type="checkbox">O paciente conseguiu escrever a frase com sucesso<br>
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
                                <input name="q11a" value="1"  type="checkbox">O paciente realizou a tarefa com sucesso<br>
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