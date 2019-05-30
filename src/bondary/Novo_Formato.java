package bondary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Novo_Formato extends Application implements EventHandler<ActionEvent>{

	private TextField txFormato = new TextField();
	private TextArea taDescricao = new TextArea();
	private CheckBox cbPadrao = new CheckBox("Definir formato como padrão");
	private CheckBox cbCategoria = new CheckBox("Criar categoria na biblioteca de erros");
	private Button btnEnviar = new Button("Enviar");
	private Label lblTitulo1 = new Label("Novo formato");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela, 480,320);
		
		lblTitulo1.setFont(Font.font("Verdana",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(200);
		
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
		cbCategoria.setTranslateY(220);

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
		
		
		stage.setTitle("Inserir novo formato");
		stage.setScene(scn);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event){
		
		if(event.getTarget() == btnEnviar) {
			System.out.println(txFormato.getText());
			System.out.println(taDescricao.getText());
			System.out.println(cbPadrao.isSelected());
			System.out.println(cbCategoria.isSelected());
		}
		
	}
	
}
