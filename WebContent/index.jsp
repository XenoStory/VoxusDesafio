<%@ include file="javaImport.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Voxus - Painel de Processos</title>
	<%@ include file="import.jsp" %>
</head>
<body>
<%@ include file="cabecalho.jsp" %>
<section id="conteudo">
	  <br><br>
	  <div id="login-google">
	  	<div id="google" class="g-signin2" data-onsuccess="onSignIn" id="g">Faça login com sua conta do google!</div>
	  </div>
	  <br><br>
        <div id="opcoes" style="display: none;">
                <img src="img/register.png" onMouseOver="this.src='img/register_hover.png'" onMouseOut="this.src='img/register.png'" width="125px" height="125px" />
                <img src="img/pesquisa.png" onMouseOver="this.src='img/pesquisa_hover.png'" onMouseOut="this.src='img/pesquisa.png'" id="producao" width="125px" height="125px" />
            </div>
            <div id="nomeOpcoes" style="display: none;">
                <span id="item"><a href="cadastro.jsp">Cadastrar</a></span>
                <span><a href="servlet?acao=listarTask">Consultar</a></span><br><br>
                <c:if test="${not empty msg}">
                	<span class="mensagem">${msg}</span>
                </c:if>
                <c:if test="${not empty erro}">
                	<span class="erro">${erro}</span>
                </c:if>
            </div>
</section>
<%@ include file="rodape.jsp" %>
</body>
</html>