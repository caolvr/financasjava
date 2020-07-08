package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import application.Main;
import application.Scenes;
import entities.Usuario;

public class MainController {
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtProfissao;
	
	@FXML
	private TextField txtContato;
	
	@FXML
	private Button btCadastrar;
	
	
	public void onBtCadastroAction() {
		String nome = txtNome.getText();
		String profissao = txtProfissao.getText();
		Integer contato = Integer.parseInt(txtContato.getText());
		
		Usuario user = new Usuario(nome, profissao, contato);
		user.adicionaUsuario(user);
		user.escreverDados();
		
		Main.mudarTela(Scenes.CADRECEITAOUGASTO);
		
	}
	
}
