package view;

import controler.Controle_Erro;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

public class Relatar_Erro extends Application implements EventHandler<ActionEvent> {

	private Button btnRelatar = new Button("Relatar");
	private Label lblTitulo1 = new Label("Relatar Erro");
	private ComboBox<String> cmb_tipo = new ComboBox<String>();
	private TextArea txtcomentario = new TextArea();
	Stage p;
	
	BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490,340, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	@Override
	public void start(Stage palco) throws Exception {

		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480,330);
		palco.setTitle("Tela - Relatar Erro");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(txtcomentario);
		principal.getChildren().add(cmb_tipo);
		principal.getChildren().add(btnRelatar);
		principal.setBackground(new Background(myBI));

		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);

		lblTitulo1.setTranslateY(15);
		lblTitulo1.setTranslateX(180);


		txtcomentario.setFocusTraversable(false);
		txtcomentario.setTranslateY(30);
		txtcomentario.setTranslateX(135);
		txtcomentario.setMaxWidth(200);

		cmb_tipo.setFocusTraversable(false);
		cmb_tipo.setTranslateY(-150);
		cmb_tipo.setTranslateX(350);

		btnRelatar.setFocusTraversable(false);
		btnRelatar.setTranslateY(50);
		btnRelatar.setTranslateX(200);

		palco.setScene(scene);

		btnRelatar.setOnAction(this);

		cmb_tipo.getItems().addAll("Áudio", "Vídeo");

		lblTitulo1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));


		txtcomentario.setPromptText("Deixe o seu feedbck ...");
		txtcomentario.setWrapText(true);
		cmb_tipo.setPromptText("Categoria");
		
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

		if (event.getTarget() == btnRelatar) {

			Controle_Erro ce = new Controle_Erro(cmb_tipo, txtcomentario);
			ce.inserirInfo_U();
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

	}

}
