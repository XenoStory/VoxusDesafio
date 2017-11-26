package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Task;
import br.com.fiap.bo.TaskBO;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
		 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String acao = request.getParameter("acao");
		String retorno = "";
		
		
		switch(acao)
		{
		case "cadastrar":
			try
			{
				cadastrar(request);
				retorno = "index.jsp";
			}
			catch (Exception e)
			{
				retorno = "index.jsp";
				request.setAttribute("erro", e.getMessage());
				e.printStackTrace();
			}
		break;
		case "exibirTask":
			try
			{
				selecionar(request);
				retorno = "alterarTask.jsp";
			}
			catch (Exception e)
			{
				request.setAttribute("erro", e.getMessage());
				retorno = "servlet?acao=listarTask";
			}
		break;
		case "listarTask":
			try
			{
				listarTodos(request);
				retorno = "consultar.jsp";
			}
			catch (Exception e)
			{
				retorno = "index.jsp";
				request.setAttribute("erro", e.getMessage());
			}
		break;
		case "alterar":
			try
			{
				atualizar(request);
				retorno = "index.jsp";
			}
			catch (Exception e)
			{
				retorno = "index.jsp";
				request.setAttribute("erro", e.getMessage());
			}
		break;
		case "excluir":
			try
			{
				excluir(request);
				retorno = "index.jsp";
			}
			catch (Exception e)
			{
				request.setAttribute("erro", e.getMessage());
				retorno = "index.jsp";
			}
		break;
		case "finalizar":
			try
			{
				finalizar(request);
				retorno = "index.jsp";
			}
			catch(Exception e)
			{
				request.setAttribute("erro", e.getMessage());
				retorno = "index.jsp";
			}
		break;
		}
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}
	
	private void cadastrar(HttpServletRequest request) throws Exception
	{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
		String usuario = request.getParameter("nome");
		
		Task t = new Task(codigo, titulo, descricao, prioridade, usuario, 1);
		t.getStatus();
		TaskBO.gravar(t);
		request.setAttribute("msg", "Task cadastrada com sucesso! :)");
	}
	
	private void listarTodos(HttpServletRequest request) throws Exception
	{
		List<Task> lt = TaskBO.selecionarTodos();
		request.setAttribute("lista", lt);
	}
	
	private void atualizar(HttpServletRequest request) throws Exception
	{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
		
		Task t = new Task();
		t.setTitulo(titulo);
		t.setDescricao(descricao);
		t.setPrioridade(prioridade);
		TaskBO.atualizar(codigo, t);
		request.setAttribute("msg", "Task atualizada com sucesso! :D");
	}
	
	private void selecionar(HttpServletRequest request) throws Exception
	{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Task t = TaskBO.selecionar(codigo);
		request.setAttribute("t", t);
	}
	
	private void excluir(HttpServletRequest request) throws Exception
	{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		TaskBO.deletar(codigo);
		request.setAttribute("msg", "Task deletada com sucesso! (:");
	}
	
	private void finalizar(HttpServletRequest request) throws Exception
	{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Task t = new Task();
		t.setStatus(0);
		TaskBO.finalizar(codigo, t);
		request.setAttribute("msg", "Task finalizada com sucesso!");
	}
}
