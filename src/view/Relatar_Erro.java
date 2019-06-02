package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Ctrl + Shift + f = para identar.
// Ctrl + Shift + o = tirar imports n�o usados.
// Ctrl + Shift + c = para comentar linhas.
//Ctrl + Shift + l = para comentar linhas.

public class Relatar_Erro extends Application implements EventHandler<ActionEvent> {

	
	private Button btnRelatar = new Button("Relatar");
	private Label lblTitulo1 = new Label("Relatar Erro");
	private ComboBox<String> cmb_tipo = new ComboBox<String>();
	private TextField txtnome = new TextField();
	private TextField txtemail = new TextField();
	private TextArea txtcomentario = new TextArea();
	
	@Override
	public void start(Stage palco) throws Exception {

		
		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 500);
		palco.setTitle("Tela - Relatar Erro");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(txtnome);
		principal.getChildren().add(txtemail);
		principal.getChildren().add(txtcomentario);
		principal.getChildren().add(cmb_tipo);
		principal.getChildren().add(btnRelatar);
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(180);
		txtnome.setFocusTraversable(false);
		txtnome.setTranslateY(50);
		txtnome.setTranslateX(135);
		txtnome.setMaxWidth(200);
		txtemail.setFocusTraversable(false);
		txtemail.setTranslateY(80);
		txtemail.setTranslateX(135);
		txtemail.setMaxWidth(200);
		txtcomentario.setFocusTraversable(false);
		txtcomentario.setTranslateY(160);
		txtcomentario.setTranslateX(135);
		txtcomentario.setMaxWidth(200);
		cmb_tipo.setFocusTraversable(false);
		cmb_tipo.setTranslateY(-80);
		cmb_tipo.setTranslateX(135);
		btnRelatar.setFocusTraversable(false);
		btnRelatar.setTranslateY(160);
		btnRelatar.setTranslateX(200);
		palco.setScene(scene);
		btnRelatar.setOnAction(this);
		cmb_tipo.getItems().addAll("�udio",
								"V�deo");
		lblTitulo1.setFont(Font.font("Verdana",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		txtnome.setPromptText("Insira o seu nome");
		txtemail.setPromptText("Insira o seu email");
		txtcomentario.setPromptText("Deixe o seu feedbck ...");
		txtcomentario.setWrapText(true);
		cmb_tipo.setPromptText("Categoria");
		palco.show();

	}

	public static void main(String args[]) {

		Application.launch(args);

	}

	// help - https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm

	@Override
	public void handle(ActionEvent event) {

		if (event.getTarget() == btnRelatar) {

			System.out.println("Arquivo Convertido com Sucesso !!!");

		}

	}

}
