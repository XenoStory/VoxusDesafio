package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Task;
import br.com.fiap.conexao.ConnectionFactory;

public class TaskDAO 
{
	private Connection conexao;
	
	public TaskDAO() throws Exception
	{
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public String fecharConexao() throws Exception
	{
		conexao.close();
		return "Conexão finalizada com sucesso!";
	}
	
	public String gravar(Task t) throws Exception
	{
		PreparedStatement stmt = conexao.prepareStatement
				("INSERT INTO T_VX_TASK(CD_TASK, DS_TITULO, DS_DESCRICAO, NR_PRIORIDADE, NM_USUARIO, DS_STATUS)"
						+ "VALUES(?,?,?,?,?,?)");
		stmt.setInt(1, t.getCodigo());
		stmt.setString(2, t.getTitulo());
		stmt.setString(3, t.getDescricao());
		stmt.setInt(4, t.getPrioridade());
		stmt.setString(5, t.getUsuario());
		stmt.setInt(6, t.getStatus());
		stmt.executeUpdate();
		stmt.close();
		
		return "Task inserida com sucesso!";
	}
	
	public Task selecionar(int pCodigo) throws Exception
	{
		PreparedStatement stmt = conexao.prepareStatement
				("SELECT * FROM T_VX_TASK WHERE CD_TASK=?");
		stmt.setInt(1, pCodigo);
		ResultSet pesquisa = stmt.executeQuery();
		Task t = new Task();
		if(pesquisa.next())
		{
			t.setCodigo(pesquisa.getInt("CD_TASK"));
			t.setTitulo(pesquisa.getString("DS_TITULO"));
			t.setDescricao(pesquisa.getString("DS_DESCRICAO"));
			t.setPrioridade(pesquisa.getInt("NR_PRIORIDADE"));
			t.setUsuario(pesquisa.getString("NM_USUARIO"));
			t.setStatus(pesquisa.getInt("DS_STATUS"));
		}
		
		pesquisa.close();
		stmt.close();
		return t;
	}
	
	public List<Task> selecionarTodos() throws Exception
	{
		PreparedStatement stmt = conexao.prepareStatement
				("SELECT * FROM T_VX_TASK ORDER BY CD_TASK");
		ResultSet pesquisa=stmt.executeQuery();
		List<Task> lt = new ArrayList<Task>();
		Task t;
		while(pesquisa.next())
		{
			t = new Task();
			t.setCodigo(pesquisa.getInt("CD_TASK"));
			t.setTitulo(pesquisa.getString("DS_TITULO"));
			t.setDescricao(pesquisa.getString("DS_DESCRICAO"));
			t.setPrioridade(pesquisa.getInt("NR_PRIORIDADE"));
			t.setUsuario(pesquisa.getString("NM_USUARIO"));
			t.setStatus(pesquisa.getInt("DS_STATUS"));
			lt.add(t);
		}
		return lt;
	}
	
	public String atualizar(int pCodigo, Task t) throws Exception
	{
		PreparedStatement stmt = conexao.prepareStatement
				("UPDATE T_VX_TASK SET DS_TITULO=?, DS_DESCRICAO=?, NR_PRIORIDADE=? WHERE CD_TASK=?");
		stmt.setString(1, t.getTitulo());
		stmt.setString(2, t.getDescricao());
		stmt.setInt(3, t.getPrioridade());
		stmt.setInt(4, pCodigo);
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno + " task(s) atualizada(s)!";
	}
	
	public String deletar(int pCodigo) throws Exception
	{
		PreparedStatement stmt = conexao.prepareStatement
				("DELETE FROM T_VX_TASK WHERE CD_TASK=?");
		stmt.setInt(1, pCodigo);
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno + " task(s) foram deletada(s)!";
	}
	
	public String finalizar(int pCodigo, Task t) throws Exception
	{
		PreparedStatement stmt = conexao.prepareStatement
				("UPDATE T_VX_TASK SET DS_STATUS=? WHERE CD_TASK=?");
		stmt.setInt(1, t.getStatus());
		stmt.setInt(2, pCodigo);
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno + " task(s) foram finalizada(s)!";
		
	}
}
