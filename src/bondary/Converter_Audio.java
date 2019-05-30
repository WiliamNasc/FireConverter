package bondary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Converter_Audio extends Application implements EventHandler<ActionEvent> {
	
	private ComboBox<String> extenssao = new ComboBox<>();
	private Button btnConverte = new Button("Converter");
	private Label lblTitulo1 = new Label("Converter Áudio");
	private Label lblTitulo2 = new Label("Extenção");
	private TextField txt_Arquivo = new TextField();
	private Button btnSeleciona = new Button("Selecionar Arquivo");


	@Override
	public void start(Stage palco) throws Exception {
		
		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 400);
	    palco.setTitle("Tela - Conversão de áudio");
	    principal.getChildren().add(lblTitulo1);
	    principal.getChildren().add(lblTitulo2);
		principal.getChildren().add(extenssao);
		principal.getChildren().add(txt_Arquivo);
		principal.getChildren().add(btnSeleciona);
		principal.getChildren().add(btnConverte);
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(180);
		txt_Arquivo.setTranslateY(2);
		txt_Arquivo.setTranslateX(0);
		btnSeleciona.setTranslateY(10);
		btnSeleciona.setTranslateX(180);
		lblTitulo2.setTranslateY(150);
		lblTitulo2.setTranslateX(18);
		extenssao.setTranslateY(130);
		extenssao.setTranslateX(100);
		btnConverte.setTranslateY(200);
	    btnConverte.setTranslateX(200);
		palco.setScene(scene);
		btnConverte.setOnAction(this);
		extenssao.getItems().addAll("Mp3", 
									"Mp4");
		txt_Arquivo.setPromptText("Endereço do arquivo");
		lblTitulo1.setFont(Font.font("Verdana",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		palco.show();
		
	}
	
	public static void main (String args[]){
		
		Application.launch(args);
		
	}

// help -  https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	
	@Override
	public void handle(ActionEvent event) {
		
		if (event.getTarget() == btnConverte) { 
			
			System.out.println(extenssao.getValue());
			System.out.println("Arquivo Convertido com Sucesso !!!");
			
		} 
		
	}
	

}
