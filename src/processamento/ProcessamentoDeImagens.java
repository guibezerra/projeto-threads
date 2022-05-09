package processamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

import filtrosDeMedia.FiltroDeMedia;

public class ProcessamentoDeImagens {
	public static void main(String[] args) throws IOException {
		// leitura de arquivo 
		/*
		 * FileReader fr = new
		 * FileReader("C:\\Users\\Murilo\\Downloads\\glassware_noisy.ascii.pgm");
		 * BufferedReader br = new BufferedReader(fr);
		 * 
		 * String tipo = br.readLine();
		 * 
		 * String tamanho = br.readLine();
		 * 
		 * String[] tamanhoVetor = tamanho.split(" ");
		 * 
		 * String Paleta = br.readLine();
		 * 
		 * int linhas = ConversorParaInteiro(tamanhoVetor[1]); int colunas =
		 * ConversorParaInteiro(tamanhoVetor[0]);
		 * 
		 * String matriz; int[][] imagem = new int[linhas][colunas]; int i = 0; int j =
		 * 0;
		 * 
		 * while((matriz=br.readLine()) != null) { String[] valores = matriz.split(" ");
		 * 
		 * 
		 * for(int cont = 0; cont < valores.length;cont++) { imagem[i][j] =
		 * ConversorParaInteiro(valores[cont]); j++; if(j > colunas-1) { j=0; i++; } } }
		 * System.out.println(imagem[427][319]);
		 */
		
		Thread filtragem3 = new Thread(new FiltroDeMedia(3));
		Thread filtragem5 = new Thread(new FiltroDeMedia(5));
		Thread filtragem7 = new Thread(new FiltroDeMedia(7));
		filtragem3.start();
		filtragem5.start();
		filtragem7.start();
	}
	
	
	
	public static int ConversorParaInteiro(String S) {
		return Integer.parseInt(S);
	}
	
	
}
