package view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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


public class Menu extends Application implements EventHandler<ActionEvent> {

	
	private Button btnConverte = new Button("Converter");
	private Label lblTitulo1 = new Label("Menu");
	private Button btnSeleciona = new Button("Selecionar Arquivo");
	
	
	BackgroundImage myBI= new BackgroundImage(new Image("/img/fireconverter.jpg",490,330,false,true),
	        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	
	@Override
	public void start(Stage palco) throws Exception {
		
		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 320);
		
	    palco.setTitle("Tela - Menu");
	    principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(btnSeleciona);
		principal.getChildren().add(btnConverte);
		principal.setBackground(new Background(myBI));
		
		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);
		
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(200);
		
		
		btnSeleciona.setTranslateY(-23);
		btnSeleciona.setTranslateX(350);

		
		btnConverte.setTranslateY(150);
	    btnConverte.setTranslateX(200);
	    
		palco.setScene(scene);
		
		btnSeleciona.setOnAction(this);
		btnConverte.setOnAction(this);

		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		
		
		
		palco.show();
		
	}
	
	public static void main (String args[]){
		
		Application.launch(args);
		
		
	}

// help -  https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	
	@Override
	public void handle(ActionEvent event) {
		
		if (event.getTarget() == btnSeleciona) { 
			
		
		} else if (event.getTarget() == btnConverte){
		
			
			
			
		}
		
	}

}
