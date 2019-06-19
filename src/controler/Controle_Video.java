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
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Formato_V;
import model.Video;
import persistence.Formato_VDao;
import persistence.VideoDao;

public class Controle_Video implements IControle_V {

	private ComboBox<Formato_V> cmb_extensao;
	private TextField txtendereco;

	public Controle_Video(ComboBox<Formato_V> cmbextensao) {

		this.cmb_extensao = cmbextensao;
	}

	public Controle_Video(TextField txtendereco) {

		this.txtendereco = txtendereco;
	}

	public Controle_Video(ComboBox<Formato_V> cmb_extensao, TextField txtendereco) {

		this.cmb_extensao = cmb_extensao;
		this.txtendereco = txtendereco;

	}

	@Override
	public void listaextensao() {

		try {

			Formato_VDao formato_vdao = new Formato_VDao();
			List<Formato_V> listaExtensao = formato_vdao.consultar_v();
			if (cmb_extensao.getVisibleRowCount() > 0) {

				cmb_extensao.getItems().removeAll();
			}

			if (listaExtensao != null) {

				for (Formato_V formato : listaExtensao) {

					cmb_extensao.getItems().add(formato);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ", JOptionPane.ERROR_MESSAGE);

		}
	}

	@Override
	public void inserirInfo_V() {

		try {
			VideoDao videodao = new VideoDao();
			Formato_V formato = new Formato_V();
			Video video = new Video();
			video.setEndereco(txtendereco.getText());
			formato.setExtensao(cmb_extensao.getValue().toString());
			videodao.inserir_v(video, formato);
		} catch (ClassNotFoundException | SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void converter(String ext, String arq, File video)
			throws IllegalArgumentException, InputFormatException, EncoderException {

		File convertido = new File(arq + "." + ext);

		AudioAttributes audio = new AudioAttributes();
		audio.setBitRate(new Integer(128000));
		audio.setChannels(2);
		audio.setSamplingRate(new Integer(44100));
		
		VideoAttributes vid = new VideoAttributes();
		vid.setFrameRate(30);
		if(ext.equals("mp4")){
			vid.setCodec(VideoAttributes.DIRECT_STREAM_COPY);
			vid.setSize(new VideoSize(720, 480));
		}else if(ext.equals("wmv")){
			vid.setCodec("wmv");
		}else if(ext.equals("avi")){
			ext.equals("avi");
		}
		vid.setBitRate(new Integer(128000));
		
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("avi");
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(vid);
		
		Encoder encoder = new Encoder();
		encoder.encode(video, convertido, attrs);;
		
		
		
	}

	@Override
	public void listaConvertidos() {
		
		
		
	}

}
