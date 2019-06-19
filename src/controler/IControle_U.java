package controler;

import java.sql.SQLException;

public interface IControle_U {
	
	public void inserirInfo_U();
	public String consultar_U() throws Exception, SQLException;
	public String consultar_Nome() throws Exception, SQLException;
	public String consultar_Email() throws Exception, SQLException;
	public String consultar_Senha() throws Exception, SQLException;
	public void alterarInfo_U() throws Exception, SQLException;
	public void deletar_U() throws Exception, SQLException;

}
