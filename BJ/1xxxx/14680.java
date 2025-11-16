import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14680 {
	final static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] res = new int[X][Y];
		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				res[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean impossible = false;
		for (int a = 0; a < N - 1; a++) {
			st = new StringTokenizer(br.readLine());
			int newX = Integer.parseInt(st.nextToken());
			int newY = Integer.parseInt(st.nextToken());
			if (Y != newX) {
				impossible = true;
				break;
			}
			int[][] newArr = new int[newX][newY];
			for (int i = 0; i < newX; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < newY; j++) {
					newArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] temp = new int[X][newY];
			for (int i = 0; i < X; i++) {
				for (int k = 0; k < newY; k++) {
					long sum = 0;
					for (int j = 0; j < Y; j++) {
						sum += (long) res[i][j] * newArr[j][k];
						sum %= MOD;
					}
					temp[i][k] = (int) sum;
				}
			}
			res = temp;
			Y = newY;
		}
		if (impossible) {
			System.out.println(-1);
		} else {
			long total = 0;
			for (int i = 0; i < X; i++) {
				for (int j = 0; j < res[0].length; j++) {
					total += res[i][j];
					total %= MOD;
				}
			}
			System.out.println(total % MOD);
		}
	}
}
