package entities;

public enum CondicaoPagamento {
	AVISTA("a vista"),
    PRAZO("prazo");
    
    public String descricao;
    
    CondicaoPagamento(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
}
