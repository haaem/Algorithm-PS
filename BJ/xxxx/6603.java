import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ6603 {
	static int[] S;
	static int[] res;
	static int k;
	static HashSet<Integer> check;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			S = new int[k];
			res = new int[6];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			check = new HashSet<Integer>();
			recursion(0, 0);
			bw.append('\n');
		}
		bw.flush();
		bw.close();
	}

	public static void recursion(int i, int depth) throws IOException {
		if (depth == 6) {
			for (int a : res) {
				bw.append(a + " ");
			}
			bw.append("\n");
			return;
		}
		for (int a = i; a < k; a++) {
			int t = S[a];
			if (!check.contains(t)) {
				check.add(t);
				res[depth] = t;
				recursion(a + 1, depth + 1);
				check.remove(t);
			}
		}
	}
}
