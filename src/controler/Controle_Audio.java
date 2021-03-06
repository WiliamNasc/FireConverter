package controler;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Audio;
import model.Formato_A;
import persistence.AudioDao;
import persistence.Formato_ADao;

public class Controle_Audio implements IControle_A {

	private ComboBox<Formato_A> cmb_extensao;
	private TextField txtendereco;

	public Controle_Audio(ComboBox<Formato_A> cmbextensao) {

		this.cmb_extensao = cmbextensao;
	}

	public Controle_Audio(TextField txtendereco) {

		this.txtendereco = txtendereco;
	}

	public Controle_Audio(ComboBox<Formato_A> cmb_extensao, TextField txtendereco) {

		this.cmb_extensao = cmb_extensao;
		this.txtendereco = txtendereco;

	}

	@Override
	public void listaextensao() {
		try {

			Formato_ADao formato_adao = new Formato_ADao();
			List<Formato_A> listaExtensao = formato_adao.consultar_v();
			if (cmb_extensao.getVisibleRowCount() > 0) {

				cmb_extensao.getItems().removeAll();
			}

			if (listaExtensao != null) {

				for (Formato_A formato : listaExtensao) {

					cmb_extensao.getItems().add(formato);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ", JOptionPane.ERROR_MESSAGE);

		}
	}

	@Override
	public void inserirInfo_A() {

		try {
			AudioDao audiodao = new AudioDao();
			Formato_A formato = new Formato_A();
			Audio audio = new Audio();
			audio.setEndereco(txtendereco.getText());
			formato.setExtensao(cmb_extensao.getValue().toString());
			audiodao.inserir_a(audio, formato);
		} catch (ClassNotFoundException | SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void converter(String ext, String arq, File audio)
			throws IllegalArgumentException, InputFormatException, EncoderException {

		File convertido = new File(arq + "." + ext);

		AudioAttributes aud = new AudioAttributes();
		EncodingAttributes attr = new EncodingAttributes();

		aud.setCodec("pcm_s24le");
		aud.setBitRate(new Integer(128000));
		aud.setChannels(2);
		aud.setSamplingRate(new Integer(44100));

		attr.setFormat(ext);
		attr.setAudioAttributes(aud);

		Encoder enc = new Encoder();
		enc.encode(audio, convertido, attr);
	}

}
