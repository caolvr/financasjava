package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage stage;
	private static Scene cadUsuario;
	private static Scene cadGastoOuReceita;
	private static Scene cadReceita;
	private static Scene cadGasto;
	private static Scene filtrar;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			Parent fxmlCadUsuario = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
			cadUsuario = new Scene(fxmlCadUsuario);
			
			Parent fxmlCadGastoOuReceita = FXMLLoader.load(getClass().getResource("/view/CadGastoOuReceita.fxml"));
			cadGastoOuReceita = new Scene(fxmlCadGastoOuReceita);
			
			Parent fxmlCadReceita = FXMLLoader.load(getClass().getResource("/view/CadastrarReceita.fxml"));
			cadReceita = new Scene(fxmlCadReceita);
			
			Parent fxmlCadGasto = FXMLLoader.load(getClass().getResource("/view/CadastrarGasto.fxml"));
			cadGasto = new Scene(fxmlCadGasto);
			
			Parent fxmlFiltrar = FXMLLoader.load(getClass().getResource("/view/filtrar.fxml"));
			filtrar = new Scene(fxmlFiltrar);
			
			primaryStage.setScene(cadUsuario);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void mudarTela(Scenes scr) {
		switch(scr) {
		case CADUSUARIO:
			stage.setScene(cadUsuario);
			break;
		case CADRECEITAOUGASTO:
			stage.setScene(cadGastoOuReceita);
			break;
		case CADRECEITA:
			stage.setScene(cadReceita);
			break;
		case CADGASTO:
			stage.setScene(cadGasto);
			break;
		case FILTRAR:
			stage.setScene(filtrar);
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
