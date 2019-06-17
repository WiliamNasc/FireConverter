package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
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

public class Biblioteca_de_Erros extends Application implements EventHandler<ActionEvent> {

	private TextArea taErros = new TextArea();
	private Button btnvoltar = new Button("Voltar");
	private Label lblTitulo1 = new Label("Biblioteca de Erros");
	Stage p;

	BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490, 330, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	@Override
	public void start(Stage stage) throws Exception {

		Pane tela = new Pane();
		Scene scn = new Scene(tela, 480, 320);

		taErros.setEditable(false);
		taErros.setWrapText(true);
		taErros.setTranslateX(80);
		taErros.setTranslateY(60);
		taErros.setPrefWidth(335);
		taErros.setPrefHeight(175);

		lblTitulo1.setTranslateY(20);
		lblTitulo1.setTranslateX(150);

		btnvoltar.setTranslateX(365);
		btnvoltar.setTranslateY(265);

		tela.getChildren().add(taErros);
		tela.getChildren().add(lblTitulo1);

		tela.getChildren().add(btnvoltar);
		tela.setBackground(new Background(myBI));

		stage.setTitle("Tela - Biblioteca de Erros");
		stage.setScene(scn);
		stage.setMinHeight(320);
		stage.setMinWidth(480);
		stage.setResizable(false);

		lblTitulo1.setFont(Font.font("Righteous", FontWeight.BOLD, FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));

		p = stage;

		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event) {

		if (event.getTarget() == btnvoltar) {

			Menu_Principal menu = new Menu_Principal();
			try {
				menu.start(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
