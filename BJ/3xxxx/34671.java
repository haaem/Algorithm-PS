import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ34671 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer>[] arr = new HashMap[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new HashMap<Integer, Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].merge(b, c, Math::min);
			arr[b].merge(a, c, Math::min);
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int res = -1;
			if (arr[s].containsKey(e)) {
				res = arr[s].get(e);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}

class Node {
	int to, weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
