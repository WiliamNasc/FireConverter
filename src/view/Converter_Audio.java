package view;

import java.io.File;

import javax.swing.JOptionPane;

import controler.Controle_Audio;
import it.sauronsoftware.jave.EncoderException;
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
import model.Formato_A;
import javafx.stage.FileChooser.ExtensionFilter;

public class Converter_Audio extends Application implements EventHandler<ActionEvent> {

	private ComboBox<Formato_A> cmbextensao = new ComboBox<Formato_A>();
	private Button btnConverte = new Button("Converter");
	private Label lblTitulo1 = new Label("Converter Áudio");
	private Label lblTitulo2 = new Label("Extensão");
	private TextField txt_Arquivo = new TextField();
	private Button btnSeleciona = new Button("Selecionar Arquivo");
	private File arquivo = null;
	Stage p;
	
	FileChooser fc = new FileChooser();

	BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490, 330, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	@Override
	public void start(Stage palco) throws Exception {

		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 320);
		palco.setTitle("Tela - Conversão de áudio");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(lblTitulo2);
		principal.getChildren().add(cmbextensao);
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

		cmbextensao.setTranslateY(130);
		cmbextensao.setTranslateX(100);

		btnConverte.setTranslateY(150);
		btnConverte.setTranslateX(200);

		palco.setScene(scene);

		btnSeleciona.setOnAction(this);
		btnConverte.setOnAction(this);
		

		txt_Arquivo.setPromptText("Endereço do arquivo");

		lblTitulo1.setFont(Font.font("Righteous", FontWeight.BOLD, FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));

		lblTitulo2.setFont(Font.font("Righteous", FontWeight.BOLD, FontPosture.ITALIC, 15));
		lblTitulo2.setTextFill(Color.web("#6b6b6b"));

		p = palco;
		
		palco.show();

	}

	public static void main(String args[]) {

		Application.launch(args);

	}

	// help - https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	// https://www.youtube.com/watch?v=-JJQL42WLk8
	// https://www.guj.com.br/t/quebra-de-linha-automatica-resolvido/128227

	@Override
	public void handle(ActionEvent event) {

		if (event.getTarget() == btnSeleciona) {

			fc.getExtensionFilters().addAll(new ExtensionFilter("MP3", "*.mp3"),
											new ExtensionFilter("MP4", "*.mp4"),
											new ExtensionFilter("Ogg", "*.ogg"),
											new ExtensionFilter("WAV", "*.wav"),
											new ExtensionFilter("WMA", "*.wma"));

			arquivo = fc.showOpenDialog(null);
			txt_Arquivo.setText(arquivo.toString());
			
			Controle_Audio ca = new Controle_Audio(cmbextensao);
			ca.listaextensao();

		} else if (event.getTarget() == btnConverte) {
			
			Controle_Audio ca = new Controle_Audio(cmbextensao, txt_Arquivo);
			ca.inserirInfo_A();
			Menu_Principal menu = new Menu_Principal();
			
			String[] file = txt_Arquivo.getText().split("");
			String FileAux = "";
			String arq = "";
			int i = 0;
			
			for(i = 0; i<file.length; i++) {
				if(file[i].equals("\\")){
					file[i] = "/";
				}
				FileAux += file[i];
				System.out.println(FileAux);
			}
			
			i=0;
			
			while(!file[i].equals(".")) {
				arq += file[i];
				i++;
			}
			
			
			
			try {
				ca.converter(cmbextensao.getValue().toString(), arq,new File(FileAux));
			} catch (IllegalArgumentException | EncoderException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				JOptionPane.showMessageDialog(null, "Arquivo Convertido, com Sucesso !!!");
				p.setHeight(358.5);
				p.setMinHeight(330);
				p.setMinWidth(480);
				menu.start(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
