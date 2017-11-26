package br.com.fiap.beans;

public class Task 
{
	private int codigo;
	private String titulo;
	private String descricao;
	private int prioridade;
	private String usuario;
	private int status;
	
	public Task()
	{
		
	}
	
	public Task(int pCodigo, String pTitulo, String pDescricao, int pPrioridade, String pUsuario, int pStatus)
	{
		setCodigo(pCodigo);
		setTitulo(pTitulo);
		setDescricao(pDescricao);
		setPrioridade(pPrioridade);
		setUsuario(pUsuario);
		setStatus(pStatus);
	}
	
	public Task(int pCodigo, String pTitulo, String pDescricao, int pPrioridade) // Quando é alteração
	{
		setCodigo(pCodigo);
		setTitulo(pTitulo);
		setDescricao(pDescricao);
		setPrioridade(pPrioridade);
	}
	
	public Task(int pCodigo, int pStatus) // para deleção
	{
		setCodigo(pCodigo);
		setStatus(pStatus);
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int pCodigo) 
	{
		this.codigo = pCodigo;
	}
	public String getTitulo() 
	{
		return titulo;
	}
	public void setTitulo(String pTitulo) 
	{
		this.titulo = pTitulo.toUpperCase();
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setDescricao(String pDescricao)
	{
		this.descricao = pDescricao.toUpperCase();
	}
	
	public int getPrioridade()
	{
		return prioridade;
	}
	
	public void setPrioridade(int pPrioridade)
	{
		this.prioridade = pPrioridade;
	}
	
	public String getUsuario()
	{
		return usuario;
	}
	
	public void setUsuario(String pUsuario)
	{
		this.usuario = pUsuario;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int pStatus)
	{
		this.status = pStatus;
	}

	public String getTudo()
	{
		return " Código da task: " + getCodigo() + "\n " + "Título: " + getTitulo() + "\n " + "Descrição: " + getDescricao() + "\n" + " Prioridade: " 
				+ getPrioridade() + "\n" + "Usuário submeteu: " + getUsuario() + "\n" + " Status: " + getStatus();
	}
	
	public void setTudo(int pCodigo, String pTitulo, String pDescricao, int pPrioridade, String pUsuario, int pStatus)
	{
		setCodigo(pCodigo);
		setTitulo(pTitulo);
		setDescricao(pDescricao);
		setPrioridade(pPrioridade);
		setUsuario(pUsuario);
		setStatus(pStatus);
	}
	
}
