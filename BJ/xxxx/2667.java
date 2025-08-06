import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ2667 {
	static int N;
	static int count;
	static int[][] house;
	static int[][] numbered;
	static HashMap<Integer, Integer> sum;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sum = new HashMap<Integer, Integer>();
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		numbered = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (house[i][j] == 1 && numbered[i][j] == 0) {
					count++;
					s = 0;
					dfs(i, j);
					sum.put(count, s);
				}
			}
		}
		System.out.println(count);
		int[] arr = new int[count];
		int index = 0;
		for (int a : sum.keySet()) {
			arr[index++] = sum.get(a);
		}
		Arrays.sort(arr);
		for (int a : arr) {
			System.out.println(a);
		}
	}

	static void dfs(int i, int j) {
		numbered[i][j] = count;
		s++;
		for (int a = 0; a < 4; a++) {
			int y = i + dy[a];
			int x = j + dx[a];
			if (x < 0 || y < 0 || x >= N || y >= N)
				continue;
			if (house[y][x] == 0)
				continue;
			if (numbered[y][x] == 0)
				dfs(y, x);
		}
	}
}
