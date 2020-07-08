package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gasto extends Transacao {
	
	private TipoGasto tipo;
	private ArrayList<Gasto> gastos;
	private LocalDate dataVencimento;
	private Usuario usuario;
	
	// Constructor
	
	public Gasto() {
		gastos = new ArrayList<>();
	}
	
	public Gasto(String descricao, Double valor, Usuario responsavel, LocalDate data, LocalDate dtVencimento, CondicaoPagamento condicao,
			FormaPagamento forma, TipoGasto tipo) {
		super(descricao, valor, responsavel, data, condicao, forma);
		this.tipo = tipo;
		this.dataVencimento = dtVencimento;
		
	}

	public TipoGasto getTipo() {
		return tipo;
	}

	public void setTipo(TipoGasto tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return super.getDescricao();
	}

	@Override
	public Double getValor() {
		// TODO Auto-generated method stub
		return super.getValor();
	}

	@Override
	public Usuario getResponsavel() {
		// TODO Auto-generated method stub
		return super.getResponsavel();
	}

	@Override
	public void totalizaResponsavel(String responsavel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocalDate getData() {
		// TODO Auto-generated method stub
		return super.getData();
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	@Override
	public CondicaoPagamento getCondicao() {
		// TODO Auto-generated method stub
		return super.getCondicao();
	}

	@Override
	public FormaPagamento getForma() {
		// TODO Auto-generated method stub
		return super.getForma();
	}

	public void adicionaGasto(Gasto gasto) {
		this.gastos.add(gasto);
	}
	
	
	// Methods 
	
	public String salvarDados() {

			
		try {
			
			FileWriter fw = new FileWriter("gasto.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			
			String desc = this.getDescricao();
			Double val = this.getValor();
			String responsavel = this.getResponsavel().getNome();
			LocalDate data = this.getData();
			LocalDate dataVenc = this.getDataVencimento();
			CondicaoPagamento condicao = this.getCondicao();
			FormaPagamento forma = this.getForma();
			TipoGasto tipo = this.getTipo();
			
			pw.println("Descrição: " + desc);
			pw.println("Valor: " + val);
			pw.println("Responsavel: " + responsavel);
			pw.println("Data: " + data);
			pw.println("Data Vencimento: " + dataVenc);
			pw.println("Condição: " + condicao);
			pw.println("Forma Recebimento: " + forma);
			pw.println("Tipo: " + tipo);
			pw.println("-----------------");
			pw.flush();
			pw.close();
			fw.close();
			pw.append(desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void totalizaData(LocalDate data) {
		
		
	}

	public void totalizaPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		double val = 0;
		for (Gasto g : gastos) {
			if(g.getData().isEqual(dataInicial)){
                val += g.getValor();
            }else;
            if((g.getData().isBefore(dataFinal)) && (g.getData().isAfter(dataInicial))){
                val += g.getValor();
            }else;
            if(g.getData().isEqual(dataFinal)){
                val += g.getValor();
            }else;
		}
		
	}


	public void totalizaTipo(TipoGasto tipo) {
		double val = 0;
		for (Gasto g : gastos) {
			if(tipo.equals(g.tipo)) {
				val += g.getValor();
			}
		}
	}
	
	@Override
	public void totalizaCondicaoPagamento(CondicaoPagamento condicao) {
		double val = 0;
		for (Gasto g : gastos) {
			if(condicao.equals(g.getCondicao())) {
				val += g.getValor();
			}else;
		}
		
	}

	@Override
	public void totalizaFormaPagamento(FormaPagamento forma) {
		double val = 0;
		for (Gasto g : gastos) {
			if(forma.equals(g.getForma())) {
				val += g.getValor();
			}
		}
		
	}
	
	
	
	
}
