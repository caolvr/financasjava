package view;

import java.time.LocalDate;

import application.Main;
import application.Scenes;
import entities.CondicaoPagamento;
import entities.FormaPagamento;
import entities.Receita;
import entities.TipoReceita;
import entities.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CadastroReceitaController {
	
	@FXML
	private TextField txtDescricao;
	
	@FXML
	private TextField txtValor;
	
	@FXML
	private TextField txtResponsavel;
	
	@FXML
	private TextField txtData;
	
	@FXML
	private ChoiceBox<CondicaoPagamento> cbCondicao;
	
	@FXML
	private ChoiceBox<FormaPagamento> cbForma;
	
	@FXML
	private ChoiceBox<TipoReceita> cbTipo;
	
	@FXML
	private Button btOk;
	
	@FXML
	private Button btFiltrar;
	
	@FXML
	public void initialize() {
		cbCondicao.getItems().addAll(CondicaoPagamento.values());
		cbForma.getItems().addAll(FormaPagamento.values());
		cbTipo.getItems().addAll(TipoReceita.values());
	}
	
	public void onBtOk() {
		String descricao = txtDescricao.getText();
		Double valor = Double.parseDouble(txtValor.getText());
		String responsavel = txtResponsavel.getText();
		Usuario usr = new Usuario(responsavel);
		LocalDate data = LocalDate.parse(txtData.getText());
		CondicaoPagamento condicao = cbCondicao.getValue();
		FormaPagamento forma = cbForma.getValue();
		TipoReceita tipo = cbTipo.getValue();
		
		Receita rc = new Receita(descricao, valor, usr, data, condicao, forma, tipo);
		rc.adicionaReceita(rc);
		rc.salvarDados();
	}
	
	public void onBtFiltrar() {
		Main.mudarTela(Scenes.FILTRAR);
	}
}
