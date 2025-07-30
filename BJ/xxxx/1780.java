import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780 {
	static int c1;
	static int c2;
	static int c3;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursion(N, 0, 0);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}

	public static void recursion(int n, int r, int c) {
		if (check(r, c, n)) {
			if (arr[r][c] == -1)
				c1++;
			else if (arr[r][c] == 0) {
				c2++;
			} else {
				c3++;
			}
			return;
		}
		int size = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				recursion(size, r + i * size, c + j * size);
			}
		}
	}

	public static boolean check(int r, int c, int n) {
		int num = arr[r][c];
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (arr[i][j] != num)
					return false;
			}
		}
		return true;
	}
}
