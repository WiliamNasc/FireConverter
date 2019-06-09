package view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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


public class Menu_Principal extends Application implements EventHandler<ActionEvent> {

	private Label lblTitulo1 = new Label("Menu");
	
	private MenuBar menubar = new MenuBar();
	
	private Menu convert_menu = new Menu("Converter Arquivo");
	private Menu relatar_menu = new Menu("Relatar");
	private Menu insere_menu = new Menu("Inserir");
	private Menu consulta_menu = new Menu("Consultar");
	private Menu sair_menu = new Menu("Sair");
	
	private MenuItem item1 = new MenuItem("Converter video");
	private MenuItem item2 = new MenuItem("Converter audio");
	private MenuItem item3 = new MenuItem("Converter video to audio");
	
	private MenuItem item4 = new MenuItem("Relatar erro");
	private MenuItem item5 = new MenuItem("Novo Formato");
	private MenuItem item6 = new MenuItem("Biblioteca de erros");
	private MenuItem item7 = new MenuItem("Logoff");
	
	private Converter_Video converte_v = new Converter_Video();
	private Converter_Audio converte_a = new Converter_Audio();
	private ConverterVideoToAudio converte_v_a = new ConverterVideoToAudio();
	private Relatar_Erro relatar_e = new Relatar_Erro();
	private Novo_Formato novo_arq = new Novo_Formato();
	private Biblioteca_de_Erros bibli_erros = new Biblioteca_de_Erros();
	
	
	private BackgroundImage myBI= new BackgroundImage(new Image("/img/fireconverter.jpg",490,330,false,true),
	        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	
	@Override
	public void start(Stage palco) throws Exception {
		
		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 320);
		
	    palco.setTitle("Tela - Menu");
	    principal.getChildren().add(lblTitulo1);
		principal.setBackground(new Background(myBI));
		principal.getChildren().add(menubar);
		
		
		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);
		
		lblTitulo1.setTranslateY(20);
		lblTitulo1.setTranslateX(200);
		
		
		menubar.setMaxHeight(30);
		menubar.setMinHeight(30);
		menubar.setMaxWidth(400);
		menubar.setMinWidth(400);
		menubar.setTranslateY(40);
		menubar.setTranslateX(50);

		
		item1.setOnAction(e -> {
			try {
				converte_v.start(new Stage());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		item2.setOnAction(e -> {
			try {
				converte_a.start(new Stage());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		
		item3.setOnAction(e -> {
			try {
				converte_v_a.start(new Stage());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		item4.setOnAction(e -> {
			try {
				relatar_e.start(new Stage());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		item5.setOnAction(e -> {
			try {
				novo_arq.start(new Stage());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		item6.setOnAction(e -> {
			try {
				bibli_erros.start(new Stage());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		item7.setOnAction(e -> {
			try {
				palco.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		convert_menu.getItems().add(item1);
		convert_menu.getItems().add(item2);
		convert_menu.getItems().add(item3);
		
		relatar_menu.getItems().add(item4);
		
		insere_menu.getItems().add(item5);
		
		consulta_menu.getItems().add(item6);
		
		sair_menu.getItems().add(item7);
		
		
	    menubar.getMenus().add(convert_menu);
	    menubar.getMenus().add(relatar_menu);
	    menubar.getMenus().add(insere_menu);
	    menubar.getMenus().add(consulta_menu);
	    menubar.getMenus().add(sair_menu);
	    
	    
		palco.setScene(scene);

		
		lblTitulo1.setFont(Font.font("Righteous",
				FontWeight.BOLD , FontPosture.ITALIC, 30));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));
		
		
		
		
		palco.show();
		
	}
	
	public static void main (String args[]){
		
		Application.launch(args);
		
		
	}

// help -  https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	
	@Override
	public void handle(ActionEvent event) {
		
		
		
	}

}
