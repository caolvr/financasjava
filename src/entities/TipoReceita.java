package entities;

public enum TipoReceita {
	SALARIO("salario"),
	ALUGUEL("aluguel"),
	RENDIMENTO("rendimento"),
	OUTRO("outro");
	
	public String descricao;
	
	TipoReceita(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
