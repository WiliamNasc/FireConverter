package view;

import javax.swing.JOptionPane;

import controler.Controle_Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
	

	private Button btnEntrar = new Button("Entrar");
	private Label lblTitulo1 = new Label("LOGIN");
	private TextField txtemail = new TextField();
	private PasswordField txtsenha = new PasswordField();
	private Menu_Principal menu_p = new Menu_Principal();
	Stage p;
	private BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490, 330, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	@Override
	public void start(Stage palco) throws Exception {

		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 320);
		palco.setTitle("Tela - Login");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(txtemail);
		principal.getChildren().add(txtsenha);
		principal.getChildren().add(btnEntrar);
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
		
		txtsenha.setFocusTraversable(false);
		txtsenha.setTranslateY(90);
		txtsenha.setTranslateX(135);
		txtsenha.setMaxWidth(200);


		btnEntrar.setFocusTraversable(false);
		btnEntrar.setTranslateY(160);
		btnEntrar.setTranslateX(200);

		palco.setScene(scene);

		p = palco;
		
		btnEntrar.setOnAction(this);

		

		lblTitulo1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));

		
		txtemail.setPromptText("Insira o seu email");
		txtsenha.setPromptText("Senha de acesso");
		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		

		palco.show();

	}

	public static void main(String args[]) {

		Application.launch(args);

	}

	// help - https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	// https://docs.oracle.com/javafx/2/ui_controls/password-field.htm

	@Override
	public void handle(ActionEvent event) {

		if (event.getTarget() == btnEntrar) {

			try {
				
				
				Controle_Usuario cu = new Controle_Usuario(txtemail);
			
				if (cu.consultar_U() != null){
					
					p.setHeight(358.5);
					p.setMinHeight(330);
					p.setMinWidth(480);
					menu_p.start(p);
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Usuário Inválido");
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}

	}

}
