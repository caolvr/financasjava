package application;

public enum Scenes {
	CADUSUARIO(1),
	CADRECEITAOUGASTO(2),
	CADRECEITA(3),
	CADGASTO(4),
	FILTRAR(5);
	
	public int tela;

	Scenes(int i) {
		tela = i;
	}

	public int getTela() {
		return tela;
	}
}
