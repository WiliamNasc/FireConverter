package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Biblioteca_de_Erros extends Application {

	//private ComboBox<String> cbErros = new ComboBox<String>();
	private TextArea taErros = new TextArea();
	private Button btnVoltar = new Button("Voltar");
	private Button btnSim = new Button("Sim");
	private Button btnNao = new Button("Não");
	private Label lblAjuda = new Label("Isso te ajudou?");
	private Label lblTitulo1 = new Label("Biblioteca de Erros");

	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela, 480, 320);

		
		/*cbErros.getItems().addAll("Erro 404","Erro 403","Erro 500");
		cbErros.setPromptText("--Selecione o erro--");
		cbErros.relocate(175, 20);*/
		
		taErros.setEditable(false);
		taErros.setWrapText(true);
		taErros.setTranslateX(80);
		taErros.setTranslateY(60);
		taErros.setPrefWidth(335);
		taErros.setPrefHeight(175);

		lblTitulo1.setTranslateY(20);
		lblTitulo1.setTranslateX(150);
		lblAjuda.setTranslateX(80);
		lblAjuda.setTranslateY(240);
		btnSim.setTranslateX(80);
		btnSim.setTranslateY(265);
		btnNao.setTranslateX(120);
		btnNao.setTranslateY(265);
		
		btnVoltar.setTranslateX(365);
		btnVoltar.setTranslateY(265);
		
		//tela.getChildren().add(cbErros);
		tela.getChildren().add(taErros);
		tela.getChildren().add(lblTitulo1);
		tela.getChildren().add(lblAjuda);
		tela.getChildren().add(btnSim);
		tela.getChildren().add(btnNao);
		tela.getChildren().add(btnVoltar);

		
		stage.setTitle("Biblioteca de Erros");
		stage.setScene(scn);
		lblTitulo1.setFont(Font.font("Verdana",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

