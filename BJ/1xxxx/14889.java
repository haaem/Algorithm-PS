import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ14889 {
	static int[][] score;
	static int N;
	static int[] start;
	static int diff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		score = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = new int[N / 2];
		diff = Integer.MAX_VALUE;
		combi(0, 1);
		System.out.println(diff);
	}

	static void combi(int depth, int s) {
		if (depth == N / 2) {
			calculate();
			return;
		}
		for (int i = s; i <= N; i++) {
			start[depth] = s;
			combi(depth + 1, i + 1);
		}
	}

	static void calculate() {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N / 2; i++) {
			set.add(start[i]);
		}
		int sumStart = 0;
		int sumLink = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (set.contains(i) && set.contains(j)) {
					sumStart += score[i][j] + score[j][i];
				} else if (!set.contains(i) && !set.contains(j)) {
					sumLink += score[i][j] + score[j][i];
				}
			}
		}
		diff = Math.min(Math.abs(sumStart - sumLink), diff);
	}
}
