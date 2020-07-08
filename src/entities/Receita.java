package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Receita extends Transacao {
	private TipoReceita tipo;
	private ArrayList<Receita> receitas;
	File file = new File("receita.txt");

	// Constructor

	public Receita() {
		receitas = new ArrayList<>();
	}

	
	public Receita(String descricao, Double valor, Usuario responsavel, LocalDate data, CondicaoPagamento condicao,
			FormaPagamento forma, TipoReceita tipo) {
		super(descricao, valor, responsavel, data, condicao, forma);
		this.tipo = tipo;
		
		receitas = new ArrayList<>();
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
	public LocalDate getData() {
		// TODO Auto-generated method stub
		return super.getData();
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

	public TipoReceita getTipo() {
		return tipo;
	}

	public void setTipo(TipoReceita tipo) {
		this.tipo = tipo;
	}

	public void adicionaReceita(Receita receita) {
		this.receitas.add(receita);
	}

	@Override
	public void totalizaData(LocalDate data) {
		for (Receita r : receitas) {
			if (data.equals(r.getData())) {

			} else
				;
		}

	}

	public void salvarDados() {

		try {

			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(this.getDescricao());
			pw.println(this.getValor());
			pw.println(this.getResponsavel());
			pw.println(this.getData());
			pw.println(this.getCondicao());
			pw.println(this.getForma());
			pw.println(this.getTipo());
			pw.println();
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void totalizaPeriodo(LocalDate dataInicial, LocalDate dataFinal) {

		try (Scanner input = new Scanner(file)) {
			FileWriter fw = new FileWriter("totPeriodoReceita.txt");
			for(Receita r : receitas) {
				if(r.getData().isEqual(dataInicial)) {
					while(input.hasNext()) {
						fw.write(r.getDescricao());
						fw.write(r.getValor().toString());
						fw.write(r.getResponsavel().getNome());
						fw.write(r.getCondicao().descricao);
						fw.write(r.getForma().descricao);
						fw.write(r.getTipo().descricao);
						fw.write("---------------");
						fw.close();
					}
				}else;
				if(r.getData().isBefore(dataFinal) && (r.getData().isAfter(dataInicial))) {
					while(input.hasNext()) {
						fw.write(r.getDescricao());
						fw.write(r.getValor().toString());
						fw.write(r.getResponsavel().getNome());
						fw.write(r.getCondicao().descricao);
						fw.write(r.getForma().descricao);
						fw.write(r.getTipo().descricao);
						fw.write("---------------");
						fw.close();
					}
				}else;
				if(r.getData().isEqual(dataFinal)) {
					fw.write(r.getDescricao());
					fw.write(r.getValor().toString());
					fw.write(r.getResponsavel().getNome());
					fw.write(r.getCondicao().descricao);
					fw.write(r.getForma().descricao);
					fw.write(r.getTipo().descricao);
					fw.write("---------------");
					fw.close();
				}else;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void totalizaResponsavel(String responsavel) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String s = br.readLine();
			ArrayList<String> lista = new ArrayList<>();
			
			while(s != null) {
				lista.add(s);
				s = br.readLine();
			}
			for(String str : lista) {
				
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void totalizaTipo(TipoReceita tipo) {
		try(Scanner input = new Scanner(file){
			FileWriter fw = new FileWriter("totTipoReceita.txt");
			
			for (Receita r : receitas) {
				if(r.getTipo().equals(tipo)) {
					while(input.hasNext()) {
						fw.write(r.getDescricao());
						fw.write(r.getValor().toString());
						fw.write(r.getResponsavel().getNome());
						fw.write(r.getCondicao().descricao);
						fw.write(r.getForma().descricao);
						fw.write(r.getTipo().descricao);
						fw.write("---------------");
						fw.close();
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void totalizaCondicaoPagamento(CondicaoPagamento condicao) {
		try{
			Scanner input = new Scanner("C:\\Users\\carol\\eclipse-workspace\\cadernoFinancas\\receita.txt");
			FileWriter fw = new FileWriter("totCondicaoReceita.txt");
			
			for (Receita r : receitas) {
				if(r.getCondicao().equals(condicao)) {
					while(input.hasNext()) {
						fw.write(r.getDescricao());
						fw.write(r.getValor().toString());
						fw.write(r.getResponsavel().getNome());
						fw.write(r.getCondicao().descricao);
						fw.write(r.getForma().descricao);
						fw.write(r.getTipo().descricao);
						fw.write("---------------");
						fw.close();
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void totalizaFormaPagamento(FormaPagamento forma) {
		try(Scanner input = new Scanner(Paths.get("receita.txt"))){
			FileWriter fw = new FileWriter("totFormaReceita.txt");
			
			for (Receita r : receitas) {
				if(r.getForma().equals(forma)) {
					while(input.hasNext()) {
						fw.write(r.getDescricao());
						fw.write(r.getValor().toString());
						fw.write(r.getResponsavel().getNome());
						fw.write(r.getCondicao().descricao);
						fw.write(r.getForma().descricao);
						fw.write(r.getTipo().descricao);
						fw.write("---------------");
						fw.close();
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
