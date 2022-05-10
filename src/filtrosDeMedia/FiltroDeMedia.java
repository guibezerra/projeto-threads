package filtrosDeMedia;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FiltroDeMedia implements Runnable {
	
	int w[][];
	int F[][];
	int G[][];
	int x1;
	int y1;
	int soma;
	int M;
	int N;
	int n;
	String tipo;
	String paleta;
	
	public  FiltroDeMedia(int n) {
		this.n = n;
		 w = new int [n][n];
		try {
			leitura();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int x = 1; x < N-2; x++) {
			for (int y = 1; y < M-2; y++) {
				soma = 0;
				for (int i = -x1; i < x1; x1++) {
					for (int j = -y1; j < y1; y1++) {
						soma = soma + w[i][j] * F[x-i][y-j]; 
					}
				}
				
				G[x][y] = soma;
			}
		}
		try {
			escrever();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leitura() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\guiaa\\Documents\\semestre 2022.1\\sistemas operacionais\\workspace-so\\projeto-threads\\utils\\glassware_noisy.ascii.pgm");
		BufferedReader br = new BufferedReader(fr);
		
		tipo = br.readLine();
		
		String tamanho = br.readLine();
		
		String[] tamanhoVetor = tamanho.split(" ");
		
		paleta = br.readLine();
		
		N = ConversorParaInteiro(tamanhoVetor[1]); //Linhas
		M = ConversorParaInteiro(tamanhoVetor[0]); //colunas
		
		F = new int [N][M];
		G = new int [N][M];
		
		String matriz;
		int i = 0;
		int j = 0;
		
		while((matriz=br.readLine()) != null) {
			String[] valores = matriz.split(" ");
			for(int cont = 0; cont < valores.length;cont++) {
				F[i][j] = ConversorParaInteiro(valores[cont]);
				j++;
				if(j > M-1) {
					j=0;
					i++;
				}
			}
		}
		br.close();
	}
	
	public static int ConversorParaInteiro(String S) {
		return Integer.parseInt(S);
	}
	
	public void escrever() throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\guiaa\\Documents\\semestre 2022.1\\sistemas operacionais\\workspace-so\\projeto-threads\\utils\\Filtro" + Integer.toString(n));
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(tipo);
		bw.newLine();
		bw.write(Integer.toString(M) + " " + Integer.toString(N));
		bw.newLine();
		bw.write(paleta);
		bw.newLine();
		
		int cont = 0;
		
		for(int i = 0;i< N ;i++) {
			for(int j = 0;j< M ;j++) {
				bw.write(Integer.toString(G[i][j]));
				cont++;
				if(cont > 20) {
					cont = 0;
					bw.newLine();
				}
				else {
					bw.write(" ");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
