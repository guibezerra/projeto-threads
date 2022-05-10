package processamento;

import java.io.IOException;

import filtrosDeMedia.FiltroDeMedia;

public class ProcessamentoDeImagens {
	public static void main(String[] args) throws IOException {

		Thread filtragem3 = new Thread(new FiltroDeMedia(3));
		Thread filtragem5 = new Thread(new FiltroDeMedia(5));
		Thread filtragem7 = new Thread(new FiltroDeMedia(7));
		filtragem3.start();
		filtragem5.start();
		filtragem7.start();
	}
	
}
