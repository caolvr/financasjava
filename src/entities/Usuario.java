package entities;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private String profissao;
	private Integer contato;
	private ArrayList<Usuario> usuarios;

	// Constructor
	public Usuario() {

	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public Usuario(String nome, String profissao, Integer contato) {
		this.nome = nome;
		this.profissao = profissao;
		this.contato = contato;

		usuarios = new ArrayList<>();
	}

	public void adicionaUsuario(Usuario user) {
		this.usuarios.add(user);
	}

	public void listaUsuarios() {
		for (Usuario u : usuarios) {
			System.out.println(u.nome);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Integer getContato() {
		return contato;
	}

	public void setContato(Integer contato) {
		this.contato = contato;
	}

	public void escreverDados() {
		try {

			FileWriter fw = new FileWriter("usuario.txt", true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(this.getNome());
			pw.println(this.getProfissao());
			pw.println(this.getContato());
			pw.flush();
			pw.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void lerDados() {
		try (Scanner input = new Scanner(Paths.get("usuario.txt"))){
			while(input.hasNext()) {
				String nome = input.next();
				String profissao = input.next();
				int contato = input.nextInt();
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
