import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ1018 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][] board;
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		for (int i=0; i<N; i++) {
			String s = new StringTokenizer(bf.readLine()).nextToken();
			for (int j=0; j<M; j++) {
				if (s.charAt(j) == 'B') {
					board[i][j] = true;
				}
					
			}
		}
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				findMin(i, j);
			}
		}
		System.out.println(min);
	}
	
	static void findMin(int i, int j) {
		boolean color = board[i][j];
		int count = 0;
		for (int x=0; x<8; x++) {
			for (int y=0; y<8; y++) {
				if (board[x+i][y+j] != color) {
					count++;
				}
				color = !color;
			}
			color = !color;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}
}