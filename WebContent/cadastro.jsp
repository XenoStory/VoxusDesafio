<%@ include file="javaImport.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Voxus - Cadastro de Processos</title>
	<%@ include file="import.jsp" %>
</head>
<body>
<%@ include file="cabecalho.jsp" %>
<section id="conteudoc">
	<br><br>
	<div id="login-google">
		<p>Faça login no botão abaixo com sua conta do google para ter acesso às opções!</p>
		<div id="google" class="g-signin2" data-onsuccess="onSignIn" id="myP">Faça login com sua conta do google!</div>
	</div>
    <div id="cadastro" style="display: none;">    
        <div id="formulario" class="input-group input-group-sm">
             	<form action="servlet" method="post">
				<input type="hidden" name="acao" value="cadastrar">
                <fieldset>
                    <legend>Cadastro de processo</legend>
                <label for="idCodigo">Código: </label>
                    <input type="text" class="form-control" id="idCodigo" name="codigo" placeholder="Código do processo..." 
                    aria-describedby="sizing-addon1"  onblur="setUsuario()"><br><br><br><br>
                    <label for="idTitulo">Título do processo: </label>
                    <input type="text" class="form-control" id="idTitulo" name="titulo" placeholder="Título do processo..." 
                    aria-describedby="sizing-addon1"><br><br><br><br>
                    <label for="idDescricao">Descrição do processo: </label>
                    <input type="text" class="form-control" id="idDescricao" name="descricao" placeholder="Descrição do processo..." aria-describedby="sizing-addon1"><br><br><br><br>
                    <label for="idPrioridade">Prioridade do processo: </label>
                    <select name="prioridade" id="idPrioridade">
  						<option value="1">1</option> 
  						<option value="2">2</option>
  						<option value="3">3</option>
  						<option value="4">4</option>
  						<option value="5">5</option>
					</select><br><br>
					<label for="idArquivo">Arquivo de documentação: </label>
					<input type="file" name="arquivo" multiple accept=".doc">
					<input type="hidden" name="nome" id="nomeI">
					<br><br>
                    <input type="submit" class="btn btn-default">
                    <a href="index.jsp">Voltar</a><br><br>
                    <c:if test="${not empty msg}">
                    	<span id="painel" class="mensagem">${msg}</span>
                    </c:if>
                    <c:if test="${not empty erro}">
                    	<span id="painel" class="erro">${erro}</span>
                    </c:if>
                </fieldset>
            </form>
        </div>
    </div>
</section>
<%@ include file="rodape.jsp" %>
</body>
</html>