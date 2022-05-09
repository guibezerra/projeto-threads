package processamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class ProcessamentoDeImagens {
	public static void main(String[] args) throws IOException {
		// leitura de arquivo 
		FileReader fr = new FileReader("C:\\Users\\guiaa\\Documents\\semestre 2022.1\\sistemas operacionais\\workspace-so\\projeto-threads\\utils\\glassware_noisy.ascii.pgm");
		BufferedReader br = new BufferedReader(fr);
		
		Stream<String> leitura = null; 
		leitura = br.lines();
		
		
	}
}
