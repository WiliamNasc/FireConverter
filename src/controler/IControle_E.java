package controler;

import java.sql.SQLException;
import java.util.List;

import model.Erro;

public interface IControle_E {
	
	public void inserirInfo_U();
	public List<Erro> tabelaErro() throws SQLException ;

}
