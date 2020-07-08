package view;

import entities.Receita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import entities.TipoReceita;

import java.time.LocalDate;

import entities.CondicaoPagamento;
import entities.FormaPagamento;

public class FiltroController {
	@FXML private TextField txtDtInicial;
	@FXML private TextField txtDtFinal;
	@FXML private Button btPeriodo;
	
	@FXML private TextField txtResponsavel;
	@FXML private Button btResponsavel;
	
	@FXML private ChoiceBox<TipoReceita> cbTipo;
	@FXML private ChoiceBox<CondicaoPagamento> cbCondicao;
	@FXML private ChoiceBox<FormaPagamento> cbForma;
	@FXML private Button btOkTipo;
	@FXML private Button btOkCond;
	@FXML private Button btOkForma;
	
	@FXML private TextField txtData;
	@FXML private Button btData;
	
	Receita rc = new Receita();
	
	@FXML
	// inicializa os choicebox com os valores
	public void initialize() {
		cbTipo.getItems().addAll(TipoReceita.values());
		cbCondicao.getItems().addAll(CondicaoPagamento.values());
		cbForma.getItems().addAll(FormaPagamento.values());
	}
	
	// filtrar por periodo
	public void onBtPeriodo() {
		LocalDate dtI = LocalDate.parse(txtDtInicial.getText());
		LocalDate dtF = LocalDate.parse(txtDtFinal.getText());
		rc.totalizaPeriodo(dtI, dtF);
	}
	
	//filtrar por responsavel
	public void onBtResponsavel() {
		String responsavel = txtResponsavel.getText();
		rc.totalizaResponsavel(responsavel);
	}
	
	//filtrar por tipo
	public void onBtOkTipo() {
		rc.totalizaTipo(cbTipo.getValue());
	}
	
	//filtrar por condição
	public void onBtOkCond() {
		rc.totalizaCondicaoPagamento(cbCondicao.getValue());
	}
	
	//filtrar por forma
	public void onBtOkForma() {
		rc.totalizaFormaPagamento(cbForma.getValue());
	}
	
}