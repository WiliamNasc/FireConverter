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

	private int cont=0;
	private Button btnEntrar = new Button("Entrar");
	private Button btnCadastrar = new Button("Novo usuário");
	private Label lblTitulo1 = new Label("LOGIN");
	private TextField txtemail = new TextField();
	private PasswordField txtsenha = new PasswordField();
	private Menu_Principal menu_p = new Menu_Principal();
	private Cadastro_Usuario cadastro_Usuario = new Cadastro_Usuario();
	private Editar_Usuario editar_Usuario = new Editar_Usuario();
	
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
		principal.getChildren().add(btnCadastrar);
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
		btnEntrar.setTranslateX(120);
		
		btnCadastrar.setFocusTraversable(false);
		btnCadastrar.setTranslateY(135);
		btnCadastrar.setTranslateX(260);

		palco.setScene(scene);

		p = palco;

		btnEntrar.setOnAction(this);
		btnCadastrar.setOnAction(this);

		lblTitulo1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));

		txtemail.setPromptText("Insira o seu email ou nome");
		txtsenha.setPromptText("Senha de acesso");

		lblTitulo1.setFont(Font.font("Righteous", FontWeight.BOLD, FontPosture.ITALIC, 20));
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

				Controle_Usuario cu = new Controle_Usuario(txtemail, txtsenha);

				if (txtemail.getText().trim().isEmpty() || txtsenha.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Por favor, Insira todos os campos !!!");

				} else {
					
					if(cu.consultar_U() != null && cu.consultar_Senha() != null){
						
						JOptionPane.showMessageDialog(null, "Seja Bem vindo, "
								+ cu.consultar_U() + " , é sempre um prazer "+
								"revelo ;)");
						p.setHeight(360);
						p.setMinHeight(330);
						p.setMinWidth(480);
						menu_p.start(p);
						
					}else{
						
						cont++;
						
						if (cont == 3){
							
							JOptionPane.showMessageDialog(null,
									"Devido a quantida de erros, \n" + 
							"por favor redefina as suas informações !!!");
							p.setHeight(365);
							p.setMinHeight(330);
							p.setMinWidth(480);
							editar_Usuario.start(p);
						}
					}

				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		
		
		if (event.getTarget() == btnCadastrar){
			
			p.setHeight(365);
			p.setMinHeight(330);
			p.setMinWidth(480);
			try {
				cadastro_Usuario.start(p);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
