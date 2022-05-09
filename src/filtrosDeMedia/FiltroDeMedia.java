package filtrosDeMedia;

public class FiltroDeMedia implements Runnable {
	
	public void convolucao (int n, int M, int N) {
		int x1 = n/2;
		int y1 = n/2;
		int soma;
		
		int w[][] = new int [n][n];
		int F[][] = new int [M][N];
		int G[][] = new int [M][N];
		
		for (int x = 1; x < M-2; x++) {
			for (int y = 1; y < N-2; y++) {
				soma = 0;
				for (int i = -x1; i < x1; x1++) {
					for (int j = -y1; j < y1; y1++) {
						soma = soma + w[i][j] * F[x-i][y-j]; 
					}
				}
				
				G[x][y] = soma;
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
