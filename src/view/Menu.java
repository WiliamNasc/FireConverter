package view;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Menu extends Application implements EventHandler<ActionEvent> {

	public static void main(String[] args) {
		
		
		Application.launch(args);

	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void voltar(Stage palco) throws Exception {
		
		Menu m = new Menu();
		m.start(palco);
	}

	@Override
	public void start(Stage palco) throws Exception {
		

		String op = JOptionPane.showInputDialog("Menu");
		Converter_Video cv = new Converter_Video();
		Converter_Audio ca = new Converter_Audio();
		ConverterVideoToAudio ctva = new ConverterVideoToAudio();
		Novo_Formato nv = new Novo_Formato();
		Relatar_Erro rl = new Relatar_Erro();
		Biblioteca_de_Erros bl = new Biblioteca_de_Erros();
		switch (op) {
		
		case"1":
			cv.start(palco);
			break;
			
		case"2":
			ca.start(palco);
			break;
			
		case"3":
			ctva.start(palco);
			break;
			
		case"4":
			nv.start(palco);
			break;
			
		case"5":
			rl.start(palco);
			break;
			
		case"6":
			bl.start(palco);
			break;

		default:
			break;}
		
	}

	

}
