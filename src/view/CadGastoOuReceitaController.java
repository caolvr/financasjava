package view;

import application.Main;
import application.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class CadGastoOuReceitaController {
	
	@FXML
	private CheckBox chkRecebimento;
	
	@FXML
	private CheckBox chkGasto;
	
	@FXML
	private Button btOk;
	
	
	public void onBtOk() {
		if(chkRecebimento.isSelected() && !chkGasto.isSelected()) {
			Main.mudarTela(Scenes.CADRECEITA);
		}else if (!chkRecebimento.isSelected() && chkGasto.isSelected()) {
			Main.mudarTela(Scenes.CADGASTO);
		}else;
	}
}
