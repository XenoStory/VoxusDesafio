<%@ include file="javaImport.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Voxus - Cadastro de Processos</title>
	<%@ include file="import.jsp" %>
</head>
<body>
<%@ include file="cabecalho.jsp" %>
<section id="conteudo">
    <div id="cadastro">    
        <div id="formulario" class="input-group input-group-sm">
             	<form action="servlet" method="post">
				<input type="hidden" name="acao" value="alterar">
                <fieldset>
                    <legend>Cadastro de processo</legend>
                <label for="idCodigo">Código: </label>
                    <input type="text" class="form-control" name="codigo" value="${t.codigo}" placeholder="Código do processo..." 
                    aria-describedby="sizing-addon1" readonly><br><br><br><br>
                    <label for="idTitulo">Título do processo: </label>
                    <input type="text" class="form-control" name="titulo" value="${t.titulo}" placeholder="Título do processo..." 
                    aria-describedby="sizing-addon1"><br><br><br><br><br>
                    <label for="idDescricao">Descrição do processo: </label>
                    <input type="text" class="form-control" name="descricao" value="${t.descricao}" placeholder="Descrição do processo..." 
                    aria-describedby="sizing-addon1"><br><br><br><br>
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
					<br><br>
                    <input type="submit" class="btn btn-default">
                    <a href="servlet?acao=listarTask">Voltar</a><br><br>
                    <c:if test="${not empty msg}">
                    	<span class="mensagem">${msg}</span>
                    </c:if>
                    <c:if test="${not empty erro}">
                    	<span class="erro">${erro}</span>
                    </c:if>
                </fieldset>
            </form>
        </div>
    </div>
</section>
<%@ include file="rodape.jsp" %>
</body>
</html>