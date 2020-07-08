package entities;

public enum Filtros {
	TIPO(1),
	CONDICAO(2),
	FORMA(3),
	RESPONSAVEL(4),
	DATA(5),
	PERIODO(6);

	private int opcao;
	
	Filtros(int op) {
		this.opcao = op;
	}
	
	public int getOpcao() {
		return opcao;
	}
	
}
