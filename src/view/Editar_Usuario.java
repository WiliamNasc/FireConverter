package view;





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

public class Editar_Usuario extends Application implements EventHandler<ActionEvent> {

	private Button btnAtualizar = new Button("Atualizar");
	private Button btnDeletar = new Button("Deletar");
	private Button btnVoltar = new Button("Voltar");
	private Label lblTitulo1 = new Label("Editar usuário");
	
	
	private TextField txtnome = new TextField();
	private TextField txtnome1 = new TextField();

	private TextField txtemail = new TextField();
	private TextField txtemail1 = new TextField();

	private PasswordField txtsenha = new PasswordField();
	private PasswordField txtsenha1 = new PasswordField();
	
	
	Stage p;
	
	BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490, 340, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	public Editar_Usuario(TextField txtemail1, TextField txtnome1, PasswordField txtsenha1) {
		
		this.txtemail1 = txtemail1;
		this.txtnome1 = txtnome1;
		this.txtsenha1 = txtsenha1;
	}
	
	public Editar_Usuario(TextField txtemail1,PasswordField txtsenha1) {
		this.txtemail1 = txtemail1;
		this.txtsenha1 =  txtsenha1;
	}

	public Editar_Usuario() {

	}

	@Override
	public void start(Stage palco) throws Exception {

		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 330);
		palco.setTitle("Tela - Editar usuário");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(txtnome);
		principal.getChildren().add(txtemail);
		principal.getChildren().add(txtsenha);
		principal.getChildren().add(btnAtualizar);
		principal.getChildren().add(btnDeletar);
		principal.getChildren().add(btnVoltar);
		principal.setBackground(new Background(myBI));

		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);

		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(165);

		txtnome.setFocusTraversable(false);
		txtnome.setTranslateY(50);
		txtnome.setTranslateX(135);
		txtnome.setMaxWidth(200);
		
		
		txtemail.setFocusTraversable(false);
		txtemail.setTranslateY(80);
		txtemail.setTranslateX(135);
		txtemail.setMaxWidth(200);
		txtemail.setText(txtemail1.getText());

		txtsenha.setFocusTraversable(false);
		txtsenha.setTranslateY(110);
		txtsenha.setTranslateX(135);
		txtsenha.setMaxWidth(200);
		txtsenha.setText(txtsenha1.getText());

		btnAtualizar.setFocusTraversable(false);
		btnAtualizar.setTranslateY(160);
		btnAtualizar.setTranslateX(100);
		
		btnDeletar.setFocusTraversable(false);
		btnDeletar.setTranslateY(135);
		btnDeletar.setTranslateX(200);
		
		
		btnVoltar.setFocusTraversable(false);
		btnVoltar.setTranslateY(110);
		btnVoltar.setTranslateX(300);

		palco.setScene(scene);

		btnAtualizar.setOnAction(this);
		btnDeletar.setOnAction(this);
		btnVoltar.setOnAction(this);


		lblTitulo1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));

		txtnome.setPromptText("Insira o seu nome");
		//txtemail.setPromptText("Insira o seu email");
		//txtsenha.setPromptText("Insira a sua senha");
		
		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		
		
		p = palco;
		
		
		palco.show();

	}

	public static void main(String args[]) {

		Application.launch(args);

	}

	// help - https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm

	@Override
	public void handle(ActionEvent event) {

		if (event.getTarget() == btnVoltar) {

			Menu_Principal menu = new Menu_Principal();
			try {
				p.setHeight(358.5);
				p.setMinHeight(330);
				p.setMinWidth(480);
				menu.start(p);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		if (event.getTarget() == btnAtualizar){
			
			Controle_Usuario cu = new Controle_Usuario(txtnome, txtemail, txtsenha);
			try {
				cu.alterarInfo_U();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (event.getTarget() == btnDeletar){
			
			Controle_Usuario cu = new Controle_Usuario(txtnome, txtemail, txtsenha);
			
			try {
				cu.deletar_U();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
