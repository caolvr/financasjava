package entities;

public enum TipoGasto {
	LUZ("luz"),
    AGUA("agua"),
    INTERNET("internet"),
    VESTUARIO("vestuario"),
    IMPOSTOS("impostos"),
    ALIMENTACAO("alimentação"),
    EDUCACAO("educação"),
    OUTROS("outros");
    
    private String descricao;
    
    TipoGasto(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
