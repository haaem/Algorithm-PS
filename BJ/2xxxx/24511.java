import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ24511 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] kind = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kind[i] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> B = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String temp = st.nextToken();
			if (kind[i] == 0) {
				B.add(Integer.parseInt(temp));
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			B.addFirst(x);
			sb.append(B.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
