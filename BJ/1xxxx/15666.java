import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ15666 {
	static int[] res;
	static ArrayList<Integer> arr;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		arr = new ArrayList<Integer>(set);
		Collections.sort(arr);
		res = new int[M];
		backtracking(0, 0);
		System.out.println(sb);
	}

	static void backtracking(int depth, int a) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = a; i < arr.size(); i++) {
			res[depth] = arr.get(i);
			backtracking(depth + 1, i);
		}
	}
}
