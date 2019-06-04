package controler;

import javafx.stage.Stage;
import view.Biblioteca_de_Erros;
import view.ConverterVideoToAudio;
import view.Converter_Audio;
import view.Converter_Video;
import view.Novo_Formato;
import view.Relatar_Erro;

public class Controle_Menu {

	Converter_Audio ca;
	Converter_Video cv;
	ConverterVideoToAudio cva;
	Novo_Formato nv;
	Biblioteca_de_Erros be;
	Relatar_Erro re;

	public void avaliarOp(String opcao, Stage palco) throws Exception {

		switch (opcao) {
		case "0":
			System.out.println("Fim de Sessão !!!");
		case "1":
			ca.start(palco);
			break;
		case "2":
			cv.start(palco);
			break;
		case "3":
			cva.start(palco);
			break;
		case "4":
			nv.start(palco);
			break;
		case "5":
			be.start(palco);
			break;
		case "6":
			re.start(palco);
			break;
		default:
			System.out.println("Opção inválida !!!");
			break;
		}

	}

}
