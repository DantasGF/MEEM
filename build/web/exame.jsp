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
                                    1 - Orientação Temporal (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <input name="q1a" value="1" type="checkbox">Qual é o dia da semana?<br>
                                <br>
                                    <input name="q1b" value="1" type="checkbox">Qual é o dia do mês?
                                <br>
                                <br>
                                    <input name="q1c" value="1" type="checkbox">Qual o mês atual?
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
                                    2 - Orientação Espacial (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <input name="q2a" value="1"  type="checkbox">Em qual local estamos?<br>
                                <br>
                                    <input name="q2b" value="1"  type="checkbox">Em qual instituição estamos(casa, rua...)?
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
                                        <b style="color:red;">[ ! ]</b> Mencione três palavras levando um segundo para cada uma.
                                        Peça ao paciente para repetir as três palavras que você mencionou.
                                        Estabeleça um ponto para cada resposta correta. 
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
                                    4 - Atenção (0 - 5 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Pedir a o paciênte para
                                        soletar a palavra MUNDO de trás para frente. 
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
                                    5 - Lembranças - Memória de Evocação (0 - 3 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Pergunte o nome das três palavras mencionadas na questão 
                                        <b style="color:red;">3</b>. Estabeleça um ponto para cada resposta.
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
                                        <b style="color:red;">[ ! ]</b> Aponte para um lápis e um relógio.
                                        Faça o paciente dizer o nome desses objetos conforme você os aponta.
                                    </b>
                                </p>
                                <input name="q6a" value="1"  type="checkbox">Lápis<br>

                                <br>
                                    <input name="q6b" value="1"  type="checkbox">Relógio
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
                                        <b style="color:red;">[ ! ]</b> Faça o paciente. Repetir "Nem aqui, nem ali, nem lá"
                                    </b>
                                </p>
                                <input name="q7a" value="1"  type="checkbox">Nem aqui, nem alí, nem lá<br>
                            </ul>

                            <li>
                                <h3>
                                    8 - Linguagem (0 - 3 pontos)
                                </h3>
                            </li>
                            <ul>
                                <p>
                                    <b>
                                        <b style="color:red;">[ ! ]</b> Faça o paciente seguir o comando de três estágios.
                                        "Pegue o papel com a mão direita. Dobre o papel ao
                                        meio. Coloque o papel na mesa".
                                    </b>
                                </p>
                                <input name="q8a" value="1"  type="checkbox">Pegar o papel com a mão direita<br>
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
                                        <b style="color:red;">[ ! ]</b> Faça o paciente ler e obedecer ao seguinte: FECHE OS OLHOS. 
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
                                        <b style="color:red;">[ ! ]</b> Faça o paciente escrever uma frase de sua
                                        própria autoria. A frase deve conter um sujeito e um
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
                                        Estabeleça um ponto se todos os lados e
                                        ângulos forem preservados e se os lados da interseção
                                        formarem um quadrilátero.
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
                                <input type="reset" value="Limpar opções">
                            </center>
                        <br>
                    </form>
                </div>
            </div>
        </center>
</body>
</html>
 <% } %>