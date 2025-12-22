import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ33872 {
	static int N, H, S, E, max;
	static int[] B, count;
	static char[] K;
	static ArrayList<Integer>[] branch;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		B = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		K = new char[N + 1];
		branch = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			K[i] = st.nextToken().charAt(0);
			branch[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			branch[u].add(v);
			branch[v].add(u);
		}
		count = new int[N + 1];
		max = -1;
		count[S] = 1;
		int temp = B[S];
		B[S] = 0;
		backtracking(H, S, temp);
		System.out.println(max);
	}

	static void backtracking(int strength, int cur, int sum) {
		if (count[E] == 2 && strength > 0)
			return;
		if (strength == 0) {
			if (cur == E) {
				max = Math.max(max, sum);
			}
			return;
		}
		for (int a : branch[cur]) {
			if (K[a] == '0' && count[a] < 2) {
				int c = B[a];
				B[a] = 0;
				count[a]++;
				backtracking(strength - 1, a, sum + c);
				B[a] = c;
				count[a]--;
			}
		}
	}
}
