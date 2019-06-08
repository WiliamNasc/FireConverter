package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Ctrl + Shift + f = para identar.
// Ctrl + Shift + o = tirar imports não usados.
// Ctrl + Shift + c = para comentar linhas.
//Ctrl + Shift + l = para comentar linhas.

public class Login extends Application implements EventHandler<ActionEvent> {

	private Button btnRelatar = new Button("Entrar");
	private Label lblTitulo1 = new Label("LOGIN");
	private TextField txtemail = new TextField();
	private TextField txtchave = new TextField();

	BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490, 340, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	@Override
	public void start(Stage palco) throws Exception {

		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 330);
		palco.setTitle("Tela - Login");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(txtemail);
		principal.getChildren().add(txtchave);
		principal.getChildren().add(btnRelatar);
		principal.setBackground(new Background(myBI));

		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);

		lblTitulo1.setTranslateY(20);
		lblTitulo1.setTranslateX(200);
		
		

		txtemail.setFocusTraversable(false);
		txtemail.setTranslateY(60);
		txtemail.setTranslateX(135);
		txtemail.setMaxWidth(200);
		
		txtchave.setFocusTraversable(false);
		txtchave.setTranslateY(90);
		txtchave.setTranslateX(135);
		txtchave.setMaxWidth(200);


		btnRelatar.setFocusTraversable(false);
		btnRelatar.setTranslateY(160);
		btnRelatar.setTranslateX(200);

		palco.setScene(scene);

		btnRelatar.setOnAction(this);

		

		lblTitulo1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));

		
		txtemail.setPromptText("Insira o seu email");
		txtchave.setPromptText("Chave de acesso");
		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		

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
