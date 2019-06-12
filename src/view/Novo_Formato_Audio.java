package view;

import controler.Controle_Formato_A;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	private TextArea taDescricao = new TextArea();
	private CheckBox cbPadrao = new CheckBox("Definir formato como padrão");
	private CheckBox cbCategoria = new CheckBox("Criar categoria na biblioteca de erros");
	private Button btnEnviar = new Button("Enviar");
	private Label lblTitulo1 = new Label("Novo formato de Aúdio");
	
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
		txFormato.setTranslateY(50);
		
		taDescricao.setFocusTraversable(false);
		taDescricao.setPromptText("Descreva o novo formato");
		taDescricao.setPrefColumnCount(3);
		taDescricao.setWrapText(true);
		taDescricao.setTranslateX(80);
		taDescricao.setTranslateY(90);
		taDescricao.setPrefWidth(335);
		taDescricao.setPrefHeight(100);

		cbPadrao.setFocusTraversable(false);
		cbPadrao.setTranslateX(80);
		cbPadrao.setTranslateY(200);

		cbCategoria.setFocusTraversable(false);
		cbCategoria.setTranslateX(80);
		cbCategoria.setTranslateY(230);

		btnEnviar.setFocusTraversable(false);
		btnEnviar.setTranslateX(200);
		btnEnviar.setTranslateY(270);
		btnEnviar.setOnAction(this);
		
		tela.getChildren().add(txFormato);
		tela.getChildren().add(taDescricao);
		tela.getChildren().add(cbPadrao);
		tela.getChildren().add(cbCategoria);
		tela.getChildren().add(btnEnviar);
		tela.getChildren().add(lblTitulo1);
		tela.setBackground(new Background(myBI));
		
		stage.setTitle("Tela - Novo formato");
		stage.setScene(scn);
		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		cbCategoria.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		cbCategoria.setTextFill(Color.web("#6b6b6b"));
		
		cbPadrao.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		cbPadrao.setTextFill(Color.web("#6b6b6b"));
		
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event){
		
		if(event.getTarget() == btnEnviar) {
			
			Controle_Formato_A ca = new Controle_Formato_A(txFormato);
			ca.inserirInfo_V();
		}
		
	}
	
}
