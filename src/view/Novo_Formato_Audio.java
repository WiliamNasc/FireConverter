package view;

import controler.Controle_Formato_A;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class Novo_Formato_Audio extends Application implements EventHandler<ActionEvent>{

	private TextField txFormato = new TextField();
	private TextArea txtDescricao = new TextArea();
	private Button btnEnviar = new Button("Enviar");
	private Label lblTitulo1 = new Label("Novo formato de A�dio");
	Stage p;
	
	BackgroundImage myBI= new BackgroundImage(new Image("/img/fireconverter.jpg",490,330,false,true),
	        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela, 480,330);
		
		lblTitulo1.setFont(Font.font("Verdana",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(145);
		
		txFormato.setFocusTraversable(false);
		txFormato.setPromptText("Insira o novo formato");
		txFormato.setTranslateX(80);
		txFormato.setTranslateY(60);
		
		txtDescricao.setFocusTraversable(false);
		txtDescricao.setPromptText("Descreva o novo formato");
		txtDescricao.setPrefColumnCount(3);
		txtDescricao.setWrapText(true);
		txtDescricao.setTranslateX(80);
		txtDescricao.setTranslateY(100);
		txtDescricao.setPrefWidth(335);
		txtDescricao.setPrefHeight(100);

		btnEnviar.setFocusTraversable(false);
		btnEnviar.setTranslateX(200);
		btnEnviar.setTranslateY(250);
		btnEnviar.setOnAction(this);
		
		tela.getChildren().add(txFormato);
		tela.getChildren().add(txtDescricao);
		tela.getChildren().add(btnEnviar);
		tela.getChildren().add(lblTitulo1);
		tela.setBackground(new Background(myBI));
		
		stage.setTitle("Tela - Novo formato");
		stage.setScene(scn);
		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		p = stage;
		
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event){
		
		if(event.getTarget() == btnEnviar) {
			
			Controle_Formato_A ca = new Controle_Formato_A(txFormato, txtDescricao);
			ca.inserirInfo_A();
			Menu_Principal menu = new Menu_Principal();
			try {
				p.setHeight(360);
				p.setMinHeight(330);
				p.setMinWidth(480);
				menu.start(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
