package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Task;
import br.com.fiap.dao.TaskDAO;

public class TaskBO 
{
	public static String gravar(Task t) throws Exception
	{
		if(t.getCodigo() <= 0)
		{
			throw new Exception("Código inválido!");
		}
		else if(t.getTitulo().length() < 5)
		{
			throw new Exception("Título inválido!");
		}
		else if(t.getDescricao().length() < 10)
		{
			throw new Exception("Descrição inválida!");
		}
		else if(t.getPrioridade() <= 0 || t.getPrioridade() > 5)
		{
			throw new Exception("Prioridade inválida!");
		}
		else if(t.getUsuario() == "")
		{
			throw new Exception("Usuário inválido!");
		}
		else if(t.getStatus() < 0 || t.getStatus() > 1)
		{
			throw new Exception("Status inválido!");
		}
		
		TaskDAO dao = new TaskDAO();
		String retorno = dao.gravar(t);
		dao.fecharConexao();
		return retorno;
	}
	
	public static Task selecionar(int pCodigo) throws Exception
	{
		TaskDAO dao = new TaskDAO();
		Task t = dao.selecionar(pCodigo);
		dao.fecharConexao();
		return t;
	}
	
	public static List<Task> selecionarTodos() throws Exception
	{
		TaskDAO dao = new TaskDAO();
		List<Task> lt = dao.selecionarTodos();
		dao.fecharConexao();
		return lt;
	}
	
	public static String atualizar(int pCodigo, Task t) throws Exception
	{
		if(pCodigo <= 0)
		{
			throw new Exception("Código inválido!");
		}
		else if(t.getTitulo().length() < 5)
		{
			throw new Exception("Título inválido!");
		}
		else if(t.getDescricao().length() < 10)
		{
			throw new Exception("Descrição inválida!");
		}
		else if(t.getPrioridade() <= 0 || t.getPrioridade() > 5)
		{
			throw new Exception("Prioridade inválida!");
		}
		
		TaskDAO dao = new TaskDAO();
		String retorno = dao.atualizar(pCodigo, t);
		dao.fecharConexao();
		return retorno;
	}
	
	public static String deletar(int pCodigo) throws Exception
	{
		TaskDAO dao = new TaskDAO();
		String retorno = dao.deletar(pCodigo);
		dao.fecharConexao();
		return retorno;
	}
	
	public static String finalizar(int pCodigo, Task t) throws Exception
	{
		if(pCodigo <= 0)
		{
			throw new Exception("Código inválido!");
		}
		
		TaskDAO dao = new TaskDAO();
		String retorno = dao.finalizar(pCodigo, t);
		dao.fecharConexao();
		return retorno;
	}
}
