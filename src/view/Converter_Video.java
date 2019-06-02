package view;

import java.io.File;

import controler.Controle_Video;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Video;

public class Converter_Video extends Application implements EventHandler<ActionEvent> {

	private ComboBox<String> extenssao = new ComboBox<String>();
	private Button btnConverte = new Button("Converter");
	private Label lblTitulo1 = new Label("Converter V�deo");
	private Label lblTitulo2 = new Label("Exten��o");
	private TextField txt_Arquivo = new TextField();
	private Button btnSeleciona = new Button("Selecionar Arquivo");
	private File arquivo = null;
	FileChooser fc = new FileChooser();
	
	
	@Override
	public void start(Stage palco) throws Exception {
		
		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 400);
		
	    palco.setTitle("Tela - Convers�o de V�deo");
	    principal.getChildren().add(lblTitulo1);
	    principal.getChildren().add(lblTitulo2);
		principal.getChildren().add(extenssao);
		principal.getChildren().add(txt_Arquivo);
		principal.getChildren().add(btnSeleciona);
		principal.getChildren().add(btnConverte);
		
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(180);
		
		txt_Arquivo.setTranslateY(2);
		txt_Arquivo.setTranslateX(18);
		txt_Arquivo.setMaxSize(320, 0);
		
		btnSeleciona.setTranslateY(-23);
		btnSeleciona.setTranslateX(350);
		
		lblTitulo2.setTranslateY(150);
		lblTitulo2.setTranslateX(18);
		
		extenssao.setTranslateY(130);
		extenssao.setTranslateX(100);
		
		btnConverte.setTranslateY(200);
	    btnConverte.setTranslateX(200);
	    
		palco.setScene(scene);
		
		btnSeleciona.setOnAction(this);
		btnConverte.setOnAction(this);
//		
//		extenssao.getItems().addAll("AVI", 
//									"Mp4",
//									"Mkv");
		
		lblTitulo1.setFont(Font.font("Verdana",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		txt_Arquivo.setPromptText("Endere�o do arquivo");
		
		palco.show();
		
	}
	
	public static void main (String args[]){
		
		Application.launch(args);
		
	}

// help -  https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	
	@Override
	public void handle(ActionEvent event) {
		
		if (event.getTarget() == btnSeleciona) { 
			
			arquivo = fc.showOpenDialog(null);
			txt_Arquivo.setText(arquivo.toString());
			Controle_Video c = new Controle_Video(extenssao, txt_Arquivo);
			c.listaVideo();
			
		} else if (event.getTarget() == btnConverte){
			
			Stage palco = new Stage();
			System.out.println("Arquivo Convertido com Sucesso !!!");
			System.out.println("Endere�o do arquivo: " + " " + arquivo.toString());
			Menu m = new Menu();
			try {
				m.voltar(palco);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}

}