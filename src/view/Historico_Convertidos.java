package view;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import model.Erro;
import persistence.ErroDao;



public class Convertidos extends Application implements EventHandler<ActionEvent> {

	private Button btnVoltar = new Button("Voltar");
	private Label lblTitulo1 = new Label("Convertidos");
	private TableView<Convertidos> tblConvertidos;
	private ObservableList<Convertidos> erro;
	Stage p;

	private BackgroundImage myBI = new BackgroundImage(new Image("/img/fireconverter.jpg", 490, 330, false, true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	@Override
	public void start(Stage palco) throws Exception {

		VBox principal = new VBox();
		Scene scene = new Scene(principal, 480, 320);

		palco.setTitle("Tela - Convertidos");
		principal.getChildren().add(lblTitulo1);
		principal.getChildren().add(btnVoltar);
		principal.setBackground(new Background(myBI));

		palco.setMinHeight(320);
		palco.setMinWidth(480);
		palco.setResizable(false);

		lblTitulo1.setTranslateY(10);
		lblTitulo1.setTranslateX(200);

		
		
		
		btnVoltar.setTranslateY(250);
		btnVoltar.setTranslateX(200);

		palco.setScene(scene);

		
		btnVoltar.setOnAction(this);

		lblTitulo1.setFont(Font.font("Righteous", FontWeight.BOLD, FontPosture.ITALIC, 20));
		lblTitulo1.setTextFill(Color.web("#6b6b6b"));

		p = palco;
		
		tblConvertidos = new TableView<Convertidos>();
		tblConvertidos.setItems(erro);
		
		TableColumn<Erro, Integer> colunaCodigo = new TableColumn<Erro,Integer>("C�digo");
		TableColumn<Erro, String> colunaCategoria = new TableColumn<Erro,String>("Categoria");
		TableColumn<Erro, String> colunaDescricao = new TableColumn<Erro,String>("Descricao");

		colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("cod_video"));
		colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		
		List<Convertidos> listtblConvertidos = new ArrayList<Convertidos>();
		
		/*ErroDao eDao = new ErroDao();
		listConvertidos = eDao.consultar_e();
		erro = FXCollections.observableArrayList(listConvertidos);*/
		
		palco.show();

	}

	public static void main(String args[]) {

		Application.launch(args);

	}

	// help - https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
	// https://medium.com/@antonio.gabriel/javafx-trabalhando-com-tableview-5cc1065babab
	// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html

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

	}

}
