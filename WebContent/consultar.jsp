<%@ include file="javaImport.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Voxus - Consulta de Processos</title>
	<%@ include file="import.jsp" %>
</head>
<body>
<%@ include file="cabecalho.jsp" %>
<section id="conteudo">   
	<br><br>
	<div id="login-google">
		<p>Faça login no botão abaixo com sua conta do google para ter acesso às opções!</p>
		<div id="google" class="g-signin2" data-onsuccess="onSignIn" id="myP">Faça login com sua conta do google!</div>
	</div>
    <div id="consultar">
        <table id="u" class="table table-bordered table-hover">
            <thead class="thead-inverse">
              <tr>
                <th>*</th>
                <th>Título</th>
                <th>Descrição</th>
                <th>Prioridade</th>
                <th>Usuário submeteu</th>
                <th>Status</th>
                <th>Atualizar</th>
                <th>Excluir</th>
                <th>Finalizar</th>
              </tr>
             </thead>
             <tbody>
               <c:forEach items="${lista}" var="task">
               <tr>
                 <th scope="row" class="numero">${task.codigo}</th>
                   <td>${task.titulo}</td>
                   <td>${task.descricao}</td>
                   <td>${task.prioridade}</td>
                   <td>${task.usuario}</td>
                   <td>${task.status}</td>
                   <td>
                   		<c:url value="servlet" var="atualizar">
							<c:param name="acao" value="exibirTask"/>
							<c:param name="codigo" value="${task.codigo}"/>
						</c:url>
						<a href="${atualizar}">Atualizar</a>
                   </td>
                   <td>
                   		<c:url value="servlet" var="deletar">
							<c:param name="acao" value="excluir"/>
							<c:param name="codigo" value="${task.codigo}"/>
						</c:url>
						<a href="${deletar}">Deletar</a>
					</td>
					<td>
                   		<c:url value="servlet" var="finalizar">
							<c:param name="acao" value="finalizar"/>
							<c:param name="codigo" value="${task.codigo}"/>
						</c:url>
						<a href="${finalizar}">Finalizar</a>
					</td>
                </tr>
                </c:forEach>
              </tbody>
          </table>
           <c:if test="${not empty msg}">
                    	<span class="mensagem">${msg}</span>
                    </c:if>
                    <c:if test="${not empty erro}">
                    	<span class="erro">${erro}</span>
          </c:if>
           <strong><a href="index.jsp">Voltar</a><br><br></strong>

 	</div>
</section>
<%@ include file="rodape.jsp" %>
</body>
</html>