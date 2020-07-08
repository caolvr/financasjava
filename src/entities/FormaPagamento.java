package entities;

public enum FormaPagamento {
	DINHEIRO("dinheiro"),
    CHEQUE("cheque"), 
    CARTAO("cartao");
    
    public String descricao;
    
    FormaPagamento(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
