package entities;

import java.time.LocalDate;

public abstract class Transacao {
	private String descricao;
    private Double valor;
    private LocalDate data;
    private CondicaoPagamento condicao;
    private FormaPagamento forma;
    private Usuario usuario;
    
    // Constructor
    public Transacao() {}
    
 
    public Transacao(String descricao, Double valor, Usuario responsavel, LocalDate data, CondicaoPagamento condicao,
			FormaPagamento forma) {
		this.descricao = descricao;
		this.valor = valor;
		this.usuario = responsavel;
		this.data = data;
		this.condicao = condicao;
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}


	public Double getValor() {
		return valor;
	}

	public Usuario getResponsavel() {
		return usuario;
	}

	public LocalDate getData() {
		return data;
	}

	public CondicaoPagamento getCondicao() {
		return condicao;
	}
	
	public FormaPagamento getForma() {
		return forma;
	}

	// Totaliza dados em data específica
	public abstract void totalizaData(LocalDate data);
    // Totaliza dados por responsavel
    public abstract void totalizaResponsavel(String responsavel);
    // Totaliza dados por condição de pagamento
    public abstract void totalizaCondicaoPagamento(CondicaoPagamento condicao);
    // Totaliza dados por forma de pagamento
    public abstract void totalizaFormaPagamento(FormaPagamento forma);
}