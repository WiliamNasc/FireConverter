package view;

import java.io.File;

import controler.Controle_Video;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import persistence.VideoDao;

public class Converter_Video extends Application implements EventHandler<ActionEvent> {

	private ComboBox<String> extenssao = new ComboBox<String>();
	private Button btnConverte = new Button("Converter");
	private Label lblTitulo1 = new Label("Converter Vídeo");
	private Label lblTitulo2 = new Label("Extenção");
	private TextField txt_Arquivo = new TextField();
	private Button btnSeleciona = new Button("Selecionar Arquivo");
	private File arquivo = null;
	FileChooser fc = new FileChooser();
	VideoDao vd = new VideoDao();
	
	BackgroundImage myBI= new BackgroundImage(new Image("/img/fireconverter.jpg",490,330,false,true),
	        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	
	@Override
	public void start(Stage palco) throws Exception {
		
		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 320);
		
	    palco.setTitle("Tela - Conversão de Vídeo");
	    principal.getChildren().add(lblTitulo1);
	    principal.getChildren().add(lblTitulo2);
		principal.getChildren().add(extenssao);
		principal.getChildren().add(txt_Arquivo);
		principal.getChildren().add(btnSeleciona);
		principal.getChildren().add(btnConverte);
		principal.setBackground(new Background(myBI));
		
		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);
		
		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(180);
		
		txt_Arquivo.setTranslateY(2);
		txt_Arquivo.setTranslateX(18);
		txt_Arquivo.setMaxSize(320, 0);
		
		btnSeleciona.setTranslateY(-23);
		btnSeleciona.setTranslateX(350);
		
		lblTitulo2.setTranslateY(150);
		lblTitulo2.setTranslateX(18);
		
		extenssao.setTranslateY(130);
		extenssao.setTranslateX(100);
		
		btnConverte.setTranslateY(150);
	    btnConverte.setTranslateX(200);
	    
		palco.setScene(scene);
		
		btnSeleciona.setOnAction(this);
		btnConverte.setOnAction(this);
//		
//		extenssao.getItems().addAll("AVI", 
//									"Mp4",
//									"Mkv");
		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		lblTitulo2.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 15));
		lblTitulo2.setTextFill(Color.web("#6b6b6b"));
		
		txt_Arquivo.setPromptText("Endereço do arquivo");
		
		
		
		palco.show();
		
	}
	
	public static void main (String args[]){
		
		Application.launch(args);
		
		
	}

// help -  https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	
	@Override
	public void handle(ActionEvent event) {
		
		if (event.getTarget() == btnSeleciona) { 
			
			arquivo = fc.showOpenDialog(null);
			txt_Arquivo.setText(arquivo.toString());
			Controle_Video c = new Controle_Video(extenssao, txt_Arquivo);
			c.listaVideo();
			
		} else if (event.getTarget() == btnConverte){
			
			/*Stage palco = new Stage();
			System.out.println("Arquivo Convertido com Sucesso !!!");
			System.out.println("Endereço do arquivo: " + " " + arquivo.toString());
			Menu m = new Menu();
*/			
			vd.add_formato(extenssao.getValue(),
					txt_Arquivo.getText());
			vd.ver();
			try {
				//m.voltar(palco);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}

}
