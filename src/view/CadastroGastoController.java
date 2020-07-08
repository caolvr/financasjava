package view;

import java.time.LocalDate;

import entities.CondicaoPagamento;
import entities.FormaPagamento;
import entities.Gasto;
import entities.TipoGasto;
import entities.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CadastroGastoController {
	
	@FXML
	private TextField txtDescricao;
	
	@FXML
	private TextField txtValor;
	
	@FXML
	private TextField txtResponsavel;
	
	@FXML
	private TextField txtData;
	
	@FXML
	private TextField txtDataVencimento;
	
	@FXML
	private ChoiceBox<CondicaoPagamento> cbCondicao;
	
	@FXML
	private ChoiceBox<FormaPagamento> cbForma;
	
	@FXML
	private ChoiceBox<TipoGasto> cbTipo;
	
	@FXML
	private Button btOk;
	
	@FXML
	public void initialize() {
		cbCondicao.getItems().addAll(CondicaoPagamento.values());
		cbForma.getItems().addAll(FormaPagamento.values());
		cbTipo.getItems().addAll(TipoGasto.values());
	}
	
	public void onBtOk() {
		String descricao = txtDescricao.getText();
		Double valor = Double.parseDouble(txtValor.getText());
		String responsavel = txtResponsavel.getText();
		Usuario usr = new Usuario(responsavel);
		LocalDate data = LocalDate.parse(txtData.getText());
		LocalDate vencimento = LocalDate.parse(txtDataVencimento.getText());
		CondicaoPagamento condicao = cbCondicao.getValue();
		FormaPagamento forma = cbForma.getValue();
		TipoGasto tipo = cbTipo.getValue();
		
		Gasto gasto = new Gasto(descricao, valor, usr, data, vencimento, condicao, forma, tipo);
		gasto.salvarDados();
	}
}
